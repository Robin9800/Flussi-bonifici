package com.springdatajpa.model;
import lombok.Getter;
import lombok.Setter;


public class RecordCoda extends RecordBonifici{
	
	private String abiProvC;
	
	private String abiDestC;
	
	private Double sommaTotImp;
	
	private Integer totBon;
	
	public RecordCoda(String abiProvC, String abiDestC, Double sommaTotImp, Integer totBon) {
		super();
		this.abiProvC = abiProvC;
		this.abiDestC = abiDestC;
		this.sommaTotImp = sommaTotImp;
		this.totBon = totBon;
	}

	public String getAbiProvC() {
		return abiProvC;
	}

	public void setAbiProvC(String abiProvC) {
		this.abiProvC = abiProvC;
	}

	public String getAbiDestC() {
		return abiDestC;
	}

	public void setAbiDestC(String abiDestC) {
		this.abiDestC = abiDestC;
	}

	public Double getSommaTotImp() {
		return sommaTotImp;
	}

	public void setSommaTotImp(Double sommaTotImp) {
		this.sommaTotImp = sommaTotImp;
	}

	public Integer getTotBon() {
		return totBon;
	}

	public void setTotBon(Integer totBon) {
		this.totBon = totBon;
	}
 
}
