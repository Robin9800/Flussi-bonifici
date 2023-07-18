package com.springdatajpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="dettagli")
public class Dettaglio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 35, nullable = false, unique = true)
	private String trn;
	
	@Column(name = "iban_provenienza_dettaglio", length = 30, nullable = false, unique = true)
	private String ibanProvenienzaD;
	
	@Column(name = "iban_destinazione_dettaglio", length = 30, nullable = false, unique = true)
	private String ibanDestinazioneD;
	
	@Column(length = 255, nullable = false)
	private String intestatario;
	
	@Column(nullable = false)
	private Double importo;
	
	@Column(name = "data_solare", columnDefinition = "DATE", nullable = false)
	private String dataSol;
	
	@Column(name = "data_contabile", columnDefinition = "DATE", nullable = false)
	private String dataCont;
	
	@Column(name = "data_valuta", columnDefinition = "DATE", nullable = false)
	private String dataVal;
	
	@Column(name = "dove_eseguito", length = 100, nullable = false)
	private String doveEseguito;
	
	@Column(name = "tipo_bonifico", nullable = false)
	private String tipoBonifico;
	
	@ManyToOne
	@JoinColumn(name="id_flusso")
	private Flusso flusso;
	
	public Dettaglio(String trn, String ibanProvenienzaD, String ibanDestinazioneD, String intestatario,
			Double importo, String dataSol, String dataCont, String dataVal, String doveEseguito, String tipoBonifico) {
		super();
		this.trn = trn;
		this.ibanProvenienzaD = ibanProvenienzaD;
		this.ibanDestinazioneD = ibanDestinazioneD;
		this.intestatario = intestatario;
		this.importo = importo;
		this.dataSol = dataSol;
		this.dataCont = dataCont;
		this.dataVal = dataVal;
		this.doveEseguito = doveEseguito;
		this.tipoBonifico = tipoBonifico;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getIbanProvenienzaD() {
		return ibanProvenienzaD;
	}

	public void setIbanProvenienzaD(String ibanProvenienzaD) {
		this.ibanProvenienzaD = ibanProvenienzaD;
	}

	public String getIbanDestinazioneD() {
		return ibanDestinazioneD;
	}

	public void setIbanDestinazioneD(String ibanDestinazioneD) {
		this.ibanDestinazioneD = ibanDestinazioneD;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getDataSol() {
		return dataSol;
	}

	public void setDataSol(String dataSol) {
		this.dataSol = dataSol;
	}

	public String getDataCont() {
		return dataCont;
	}

	public void setDataCont(String dataCont) {
		this.dataCont = dataCont;
	}

	public String getDataVal() {
		return dataVal;
	}

	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}

	public String getDoveEseguito() {
		return doveEseguito;
	}

	public void setDoveEseguito(String doveEseguito) {
		this.doveEseguito = doveEseguito;
	}

	public String getTipoBonifico() {
		return tipoBonifico;
	}

	public void setTipoBonifico(String tipoBonifico) {
		this.tipoBonifico = tipoBonifico;
	}

	public Flusso getFlusso() {
		return flusso;
	}

	public void setFlusso(Flusso flusso) {
		this.flusso = flusso;
	}
	
	

}
