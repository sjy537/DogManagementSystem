package com.bodlapatiClasses.DMS.repository;
/**
* @author Sowmya Reddy Bodlapati
*
*/
import java.util.List;

/**
* @author Sowmya Reddy Bodlapati
*
*/
import org.springframework.data.repository.CrudRepository;

import com.bodlapatiClasses.DMS.Models.Dog;

public interface DogRepository extends CrudRepository<Dog, Integer>{
	List<Dog> findByName(String name);
}
