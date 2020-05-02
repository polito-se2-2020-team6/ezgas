package it.polito.ezgas.repository;

import org.springframework.data.repository.CrudRepository;

import it.polito.ezgas.entity.PriceReport;

public interface PriceReportRepository extends CrudRepository<PriceReport, Integer>{

}
