package com.schotanus.nobel.repository;
  
import com.schotanus.nobel.entity.NobelPrizeLaureate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  
@Repository 
public interface NobelPrizeLaureateRepository extends JpaRepository<NobelPrizeLaureate, String>{
}