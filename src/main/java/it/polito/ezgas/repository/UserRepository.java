package it.polito.ezgas.repository;
import it.polito.ezgas.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
	
	List <User> findAll();
	
	int countByAdmin(boolean admin);	
	
	User findByEmail (String username);
	
}
