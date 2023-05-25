package com.Crud.Backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Crud.Backend.model.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
	
}
