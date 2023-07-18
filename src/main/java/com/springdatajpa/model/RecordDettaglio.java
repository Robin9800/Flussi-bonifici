package com.springdatajpa.model;
import lombok.Getter;
import lombok.Setter;


public class RecordDettaglio extends RecordBonifici{

	private String trn;
	
	private String ibanProvenienzaD;
	
	private String ibanDestinazioneD;
	
	private String intestatario;
	
	private Double importo;
	
	private String dataSol;
	
	private String dataCont;
	
	private String dataVal;
	
	private String doveEseguito;
	
	private String tipoBonifico;
	
	public RecordDettaglio(String ibanProvenienzaD, String ibanDestinazioneD, String intestatario,
			Double importo, String dataSol, String dataCont, String dataVal, String doveEseguito, String tipoBonifico, String trn) {
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

}
