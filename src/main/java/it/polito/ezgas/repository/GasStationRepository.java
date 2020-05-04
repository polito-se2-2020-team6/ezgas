package it.polito.ezgas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;

public interface GasStationRepository extends CrudRepository<GasStation, Integer> {
	@Override
	  List <GasStation> findAll();

	void delete(GasStation gs);
	 
}
