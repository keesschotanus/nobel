package com.schotanus.nobel.repository;
  
import com.schotanus.nobel.entity.NobelPrizeCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  
@Repository 
public interface NobelPrizeCategoryRepository extends JpaRepository<NobelPrizeCategory, String>{
}