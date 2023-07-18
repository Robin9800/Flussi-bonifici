package com.springdatajpa.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

import com.springdatajpa.model.Dettaglio;
import com.springdatajpa.model.Flusso;
import com.springdatajpa.model.RecordBonifici;
import com.springdatajpa.model.RecordCoda;
import com.springdatajpa.model.RecordDettaglio;
import com.springdatajpa.model.RecordTesta;
import com.springdatajpa.repository.BatchContext;
import com.springdatajpa.repository.IDettaglioRepository;
import com.springdatajpa.repository.IFlussoRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	public JobRepository jobRepository;
	
	@Autowired
	public IFlussoRepository flussoRepository;
	
	@Autowired
	public IDettaglioRepository dettaglioRepository;
	
    @Autowired
    private BatchContext batchContext;
    
    @Bean
    public FlatFileItemReader<String> reader() {
        return new FlatFileItemReaderBuilder<String>()
                .name("recordReader")
                .resource(new ClassPathResource("flussi.svc"))
                .lineMapper(lineMapper())
                .build();
    }

    @Bean
    public LineMapper<String> lineMapper() {
        DefaultLineMapper<String> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(new DelimitedLineTokenizer(","));
        lineMapper.setFieldSetMapper(fieldSetMapper());
        return lineMapper;
    }

    @Bean
    public FieldSetMapper<String> fieldSetMapper() {
        return new FieldSetMapper<String>() {
            @Override
            public String mapFieldSet(FieldSet fieldSet) {
                String recordType = fieldSet.readString(0);
                if (recordType.equals("T")) {
                    RecordTesta recordTesta = mapRecordTesta(fieldSet);
                    batchContext.addRecord(recordTesta);
                } else if (recordType.equals("D")) {
                    RecordDettaglio recordDettaglio = mapRecordDettaglio(fieldSet);
                    batchContext.addRecord(recordDettaglio);
                } else if (recordType.equals("C")) {
                    RecordCoda recordCoda = mapRecordCoda(fieldSet);
                    batchContext.addRecord(recordCoda);
                }
                return null;
            }

            private RecordTesta mapRecordTesta(FieldSet fieldSet) {
                String abiProv = fieldSet.readString(1);
                String cabProv = fieldSet.readString(2);
                String ibanProv = fieldSet.readString(3);
                String abiDest = fieldSet.readString(4);
                String cabDest = fieldSet.readString(5);
                String ibanDest = fieldSet.readString(6);
                return new RecordTesta(abiProv, cabProv, ibanProv, abiDest, cabDest, ibanDest);
            }

            private RecordDettaglio mapRecordDettaglio(FieldSet fieldSet) {
                String trn = fieldSet.readString(1);
                String ibanProvenienzaD = fieldSet.readString(2);
                String ibanDestinazioneD = fieldSet.readString(3);
                String intestatario = fieldSet.readString(4);
                Double importo = fieldSet.readDouble(5);
                String dataSol = fieldSet.readString(6);
                String dataCont = fieldSet.readString(7);
                String dataVal = fieldSet.readString(8);
                String doveEseguito = fieldSet.readString(9);
                String tipoBonifico = fieldSet.readString(10);
                return new RecordDettaglio(ibanProvenienzaD, ibanDestinazioneD, intestatario, importo, dataSol, dataCont, dataVal, doveEseguito, tipoBonifico, trn);
            }

            private RecordCoda mapRecordCoda(FieldSet fieldSet) {
                String abiProvC = fieldSet.readString(1);
                String abiDestC = fieldSet.readString(2);
                Double sommaTotImp = fieldSet.readDouble(3);
                Integer totBon = fieldSet.readInt(4);
                return new RecordCoda(abiProvC, abiDestC, sommaTotImp, totBon);
            }
        };
    }

    @Bean
    public ItemWriter<RecordBonifici> writer(BatchContext batchContext) {
        return new ItemWriter<RecordBonifici>() {

			@Override
			public void write(Chunk<? extends RecordBonifici> chunk) throws Exception {
				for (RecordBonifici item : chunk) {
                    if (item instanceof RecordTesta || item instanceof RecordCoda) {
                        Flusso flusso = convertToFlusso((RecordBonifici) item);
                        flussoRepository.save(flusso);
                        System.out.println(item);
                    } else if (item instanceof RecordDettaglio) {
                        Dettaglio dettaglio = convertToDettaglio((RecordDettaglio) item);
                        dettaglioRepository.save(dettaglio);
                    }
                }
				
			}
        };
    }

 // Dichiarazione della variabile di stato
    private RecordTesta currentRecordTesta;

    // Metodo per convertire il record di testa e coda in un oggetto Flusso
    private Flusso convertToFlusso(RecordBonifici item) {
        if (item instanceof RecordTesta) {
            currentRecordTesta = (RecordTesta) item;
        } else if (item instanceof RecordCoda) {
            RecordCoda recordCoda = (RecordCoda) item;
            return new Flusso(currentRecordTesta.getAbiProv(), currentRecordTesta.getCabProv(), currentRecordTesta.getIbanProv(),
                    currentRecordTesta.getAbiDest(), currentRecordTesta.getCabDest(), currentRecordTesta.getIbanDest(),
                    recordCoda.getAbiProvC(), recordCoda.getAbiDestC(), recordCoda.getSommaTotImp(), recordCoda.getTotBon());
        }
        return null;
    }

    private Dettaglio convertToDettaglio(RecordDettaglio recordDettaglio) {
        return new Dettaglio(recordDettaglio.getTrn(), recordDettaglio.getIbanProvenienzaD(),
                recordDettaglio.getIbanDestinazioneD(), recordDettaglio.getIntestatario(), recordDettaglio.getImporto(),
                recordDettaglio.getDataSol(), recordDettaglio.getDataCont(), recordDettaglio.getDataVal(),
                recordDettaglio.getDoveEseguito(), recordDettaglio.getTipoBonifico());
    }



    @Bean
	public Job importUserJob(JobRepository jobRepository, Step step1) {
	    return new JobBuilder("importUserJob", jobRepository)  
	        .incrementer(new RunIdIncrementer()) 
	        .flow(step1)  
	        .end()  
	        .build(); 
	}
	
	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, ItemWriter<RecordBonifici> writer) {
		return new StepBuilder("step1", jobRepository)
				.<String, RecordBonifici>chunk(10, transactionManager)
				.reader(reader())
				.writer(writer)
				.build();
	}
}
