package com.niltech.template.data.jpa.mysql;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called myDataRepository
// CRUD refers Create, Read, Update, Delete

@Repository
//@Profile("PROD")
public interface MySQLDataRepository extends CrudRepository<MyDBData, Long> {

}