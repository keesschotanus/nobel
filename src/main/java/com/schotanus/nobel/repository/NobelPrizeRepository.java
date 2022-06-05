package com.schotanus.nobel.repository;
  
import com.schotanus.nobel.entity.NobelPrize;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  
@Repository 
public interface NobelPrizeRepository extends JpaRepository<NobelPrize, String>{
}