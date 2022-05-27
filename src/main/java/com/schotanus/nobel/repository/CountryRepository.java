package com.schotanus.nobel.repository;
  
import com.schotanus.nobel.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  
@Repository 
public interface CountryRepository extends JpaRepository<Country, String>{
}