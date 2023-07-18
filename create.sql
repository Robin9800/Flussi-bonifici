
    create table dettagli (
        id_dettaglio integer not null auto_increment,
        id_flusso integer,
        iban_provenienza_dettaglio varchar(30) not null,
        iban_destinazione_dettaglio varchar(30) not null,
        intestatario varchar(255) not null,
        importo float(53) not null,
        data_contabile DATE not null,
        data_solare DATE not null,
        data_valuta DATE not null,
        dove_eseguito varchar(100) not null,
        tipo_bonifico varchar(255) not null,
         trn varchar(35) not null,
        primary key (id_dettaglio)
    ) engine=InnoDB;

    create table flussi (
        id_flusso integer not null auto_increment,
        abi_provenienza varchar(5) not null,
        cab_provenienza varchar(5) not null,
        iban_provenienza varchar(30) not null,
        abi_destinazione varchar(5) not null,
        cab_destinazione varchar(5) not null,
        iban_destinazione varchar(30) not null,
        abi_provenienza_coda varchar(5) not null,
        abi_destinazione_coda varchar(5) not null,
        somma_importi float(53) not null,
        totale_bonifici integer not null,
        
        primary key (id_flusso)
    ) engine=InnoDB;

    alter table dettagli 
       add constraint UK_hiyekuk0mete48dtybfxr01l0 unique (iban_destinazione_dettaglio);

    alter table dettagli 
       add constraint UK_2ii0mbeb0rbfks68wt9p843ii unique (iban_provenienza_dettaglio);

    alter table dettagli 
       add constraint UK_odfxsa7s45lt1isvuggct7r3d unique (trn);

    alter table flussi 
       add constraint UK_qn9mmof8rby91yy58k8dj89co unique (somma_importi);

    alter table flussi 
       add constraint UK_q3vs6b53hnh5y44smc2x4f242 unique (totale_bonifici);

    alter table flussi 
       add constraint UK_65fnge593lwjpl3h8npn4vfhl unique (abi_destinazione);

    alter table flussi 
       add constraint UK_q1m579lw89m2ona42v26vfn2n unique (abi_destinazione_coda);

    alter table flussi 
       add constraint UK_6lcsi9hv7vm3aja7fa3qcx4rv unique (abi_provenienza);

    alter table flussi 
       add constraint UK_pd1m6kitit3yhx5esqdga4iwb unique (abi_provenienza_coda);

    alter table flussi 
       add constraint UK_jjg0wljby76pwowpiu2u108fl unique (cab_destinazione);

    alter table flussi 
       add constraint UK_94c01gm41mavah3lucq6qb5vp unique (cab_provenienza);

    alter table flussi 
       add constraint UK_ivblvqqm1i9ttgm1npmkyrpjq unique (iban_destinazione);

    alter table flussi 
       add constraint UK_ebt0a66g64i0towicuqttpi7x unique (iban_provenienza);

    alter table dettagli 
       add constraint FKcw98it7jk0h0jdfl80ejfp7s7 
       foreign key (id_flusso) 
       references flussi (id_flusso);

   
    create table dettagli (
        id_dettaglio integer not null auto_increment,
        id_flusso integer,
        importo float(53) not null,
        iban_destinazione_dettaglio varchar(30) not null,
        iban_provenienza_dettaglio varchar(30) not null,
        trn varchar(35) not null,
        dove_eseguito varchar(100) not null,
        data_contabile DATE not null,
        data_solare DATE not null,
        data_valuta DATE not null,
        intestatario varchar(255) not null,
        tipo_bonifico varchar(255) not null,
        primary key (id_dettaglio)
    ) engine=InnoDB;

    create table flussi (
        id_flusso integer not null auto_increment,
        somma_importi float(53) not null,
        totale_bonifici integer not null,
        abi_destinazione varchar(5) not null,
        abi_destinazione_coda varchar(5) not null,
        abi_provenienza varchar(5) not null,
        abi_provenienza_coda varchar(5) not null,
        cab_destinazione varchar(5) not null,
        cab_provenienza varchar(5) not null,
        iban_destinazione varchar(30) not null,
        iban_provenienza varchar(30) not null,
        primary key (id_flusso)
    ) engine=InnoDB;

    alter table dettagli 
       add constraint UK_hiyekuk0mete48dtybfxr01l0 unique (iban_destinazione_dettaglio);

    alter table dettagli 
       add constraint UK_2ii0mbeb0rbfks68wt9p843ii unique (iban_provenienza_dettaglio);

    alter table dettagli 
       add constraint UK_odfxsa7s45lt1isvuggct7r3d unique (trn);

    alter table flussi 
       add constraint UK_qn9mmof8rby91yy58k8dj89co unique (somma_importi);

    alter table flussi 
       add constraint UK_q3vs6b53hnh5y44smc2x4f242 unique (totale_bonifici);

    alter table flussi 
       add constraint UK_65fnge593lwjpl3h8npn4vfhl unique (abi_destinazione);

    alter table flussi 
       add constraint UK_q1m579lw89m2ona42v26vfn2n unique (abi_destinazione_coda);

    alter table flussi 
       add constraint UK_6lcsi9hv7vm3aja7fa3qcx4rv unique (abi_provenienza);

    alter table flussi 
       add constraint UK_pd1m6kitit3yhx5esqdga4iwb unique (abi_provenienza_coda);

    alter table flussi 
       add constraint UK_jjg0wljby76pwowpiu2u108fl unique (cab_destinazione);

    alter table flussi 
       add constraint UK_94c01gm41mavah3lucq6qb5vp unique (cab_provenienza);

    alter table flussi 
       add constraint UK_ivblvqqm1i9ttgm1npmkyrpjq unique (iban_destinazione);

    alter table flussi 
       add constraint UK_ebt0a66g64i0towicuqttpi7x unique (iban_provenienza);

    alter table dettagli 
       add constraint FKcw98it7jk0h0jdfl80ejfp7s7 
       foreign key (id_flusso) 
       references flussi (id_flusso);

    create table dettagli (
        id_dettaglio integer not null auto_increment,
        id_flusso integer,
        importo float(53) not null,
        iban_destinazione_dettaglio varchar(30) not null,
        iban_provenienza_dettaglio varchar(30) not null,
        trn varchar(35) not null,
        dove_eseguito varchar(100) not null,
        data_contabile DATE not null,
        data_solare DATE not null,
        data_valuta DATE not null,
        intestatario varchar(255) not null,
        tipo_bonifico varchar(255) not null,
        primary key (id_dettaglio)
    ) engine=InnoDB;

    create table flussi (
        id_flusso integer not null auto_increment,
        somma_importi float(53) not null,
        totale_bonifici integer not null,
        abi_destinazione varchar(5) not null,
        abi_destinazione_coda varchar(5) not null,
        abi_provenienza varchar(5) not null,
        abi_provenienza_coda varchar(5) not null,
        cab_destinazione varchar(5) not null,
        cab_provenienza varchar(5) not null,
        iban_destinazione varchar(30) not null,
        iban_provenienza varchar(30) not null,
        primary key (id_flusso)
    ) engine=InnoDB;

    alter table dettagli 
       add constraint UK_hiyekuk0mete48dtybfxr01l0 unique (iban_destinazione_dettaglio);

    alter table dettagli 
       add constraint UK_2ii0mbeb0rbfks68wt9p843ii unique (iban_provenienza_dettaglio);

    alter table dettagli 
       add constraint UK_odfxsa7s45lt1isvuggct7r3d unique (trn);

    alter table flussi 
       add constraint UK_qn9mmof8rby91yy58k8dj89co unique (somma_importi);

    alter table flussi 
       add constraint UK_q3vs6b53hnh5y44smc2x4f242 unique (totale_bonifici);

    alter table flussi 
       add constraint UK_65fnge593lwjpl3h8npn4vfhl unique (abi_destinazione);

    alter table flussi 
       add constraint UK_q1m579lw89m2ona42v26vfn2n unique (abi_destinazione_coda);

    alter table flussi 
       add constraint UK_6lcsi9hv7vm3aja7fa3qcx4rv unique (abi_provenienza);

    alter table flussi 
       add constraint UK_pd1m6kitit3yhx5esqdga4iwb unique (abi_provenienza_coda);

    alter table flussi 
       add constraint UK_jjg0wljby76pwowpiu2u108fl unique (cab_destinazione);

    alter table flussi 
       add constraint UK_94c01gm41mavah3lucq6qb5vp unique (cab_provenienza);

    alter table flussi 
       add constraint UK_ivblvqqm1i9ttgm1npmkyrpjq unique (iban_destinazione);

    alter table flussi 
       add constraint UK_ebt0a66g64i0towicuqttpi7x unique (iban_provenienza);

    alter table dettagli 
       add constraint FKcw98it7jk0h0jdfl80ejfp7s7 
       foreign key (id_flusso) 
       references flussi (id_flusso);
