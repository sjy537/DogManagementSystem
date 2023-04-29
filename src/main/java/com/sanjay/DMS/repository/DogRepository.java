package com.sanjay.DMS.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sanjay.DMS.Models.Dog;

/**
* @author Sanjay Kumar Pilli
*
*/

public interface DogRepository extends CrudRepository<Dog, Integer>{
    List<Dog> findByName(String name);

}

