package com.springdatajpa.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="flussi")
public class Flusso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFlusso;

	@Column(name = "abi_provenienza", length = 5, nullable = false, unique = true)
	private String abiProv;
	
	@Column(name = "cab_provenienza", length = 5, nullable = false, unique = true)
	private String cabProv;
	
	@Column(name = "iban_provenienza", length = 30, nullable = false, unique = true)
	private String ibanProv;
	
	@Column(name = "abi_destinazione", length = 5, nullable = false, unique = true)
	private String abiDest;
	
	@Column(name = "cab_destinazione", length = 5, nullable = false, unique = true)
	private String cabDest;
	
	@Column(name = "iban_destinazione", length = 30, nullable = false, unique = true)
	private String ibanDest;
	
	@Column(name = "abi_provenienza_coda", length = 5, nullable = false, unique = true)
	private String abiProvC;
	
	@Column(name = "abi_destinazione_coda", length = 5, nullable = false, unique = true)
	private String abiDestC;
	
	@Column(name = "somma_importi", nullable = false, unique = true)
	private Double sommaTotImp;
	
	@Column(name = "totale_bonifici", nullable = false, unique = true)
	private Integer totBon;
	
	@OneToMany(mappedBy = "flusso", fetch = FetchType.EAGER)
	private Set<Dettaglio> dettagli;
	
	public Set<Dettaglio> getDettagli(){
		return dettagli;
	}
	
	public Flusso() {}

	public Flusso(String abiProv, String cabProv, String ibanProv, String abiDest, String cabDest, String ibanDest, String abiProvC, String abiDestC, Double sommaTotImp, Integer totBon) {
	        this.abiProv = abiProv;
	        this.cabProv = cabProv;
	        this.ibanProv = ibanProv;
	        this.abiDest = abiDest;
	        this.cabDest = cabDest;
	        this.ibanDest = ibanDest;
	        this.abiProvC = abiProvC;
	        this.abiDestC = abiDestC;
	        this.sommaTotImp = sommaTotImp;
	        this.totBon = totBon;
	    }

	public Integer getIdFlusso() {
		return idFlusso;
	}

	public void setIdFlusso(Integer idFlusso) {
		this.idFlusso = idFlusso;
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

	public void setDettagli(Set<Dettaglio> dettagli) {
		this.dettagli = dettagli;
	}
	
	
}
