package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.Flusso;

@Repository
public interface IFlussoRepository extends CrudRepository<Flusso, Integer>{
	
	


}
