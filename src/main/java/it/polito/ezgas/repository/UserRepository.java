package it.polito.ezgas.repository;
import it.polito.ezgas.entity.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer>{
	
	List <User> findAll();
	
	int countByAdmin(boolean admin);
	
	<S extends User> S save(User user);
	
	
}
