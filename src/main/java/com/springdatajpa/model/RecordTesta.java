package com.springdatajpa.model;
import lombok.Getter;
import lombok.Setter;

public class RecordTesta extends RecordBonifici{
	
	private String abiProv;
	
	private String cabProv;
	
	private String ibanProv;
	
	private String abiDest;
	
	private String cabDest;
	
	private String ibanDest;
	

	public RecordTesta(String abiProv, String cabProv, String ibanProv, String abiDest, String cabDest,
			String ibanDest) {
		super();
		this.abiProv = abiProv;
		this.cabProv = cabProv;
		this.ibanProv = ibanProv;
		this.abiDest = abiDest;
		this.cabDest = cabDest;
		this.ibanDest = ibanDest;
	}


	public String getAbiProv() {
		return abiProv;
	}


	public void setAbiProv(String abiProv) {
		this.abiProv = abiProv;
	}


	public String getCabProv() {
		return cabProv;
	}


	public void setCabProv(String cabProv) {
		this.cabProv = cabProv;
	}


	public String getIbanProv() {
		return ibanProv;
	}


	public void setIbanProv(String ibanProv) {
		this.ibanProv = ibanProv;
	}


	public String getAbiDest() {
		return abiDest;
	}


	public void setAbiDest(String abiDest) {
		this.abiDest = abiDest;
	}


	public String getCabDest() {
		return cabDest;
	}


	public void setCabDest(String cabDest) {
		this.cabDest = cabDest;
	}


	public String getIbanDest() {
		return ibanDest;
	}


	public void setIbanDest(String ibanDest) {
		this.ibanDest = ibanDest;
	}
 

}
