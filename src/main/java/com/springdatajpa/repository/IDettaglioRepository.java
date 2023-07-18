package com.springdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdatajpa.model.Dettaglio;
import com.springdatajpa.model.RecordDettaglio;

@Repository
public interface IDettaglioRepository extends CrudRepository<Dettaglio, Integer>{

}
