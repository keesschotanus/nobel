package com.schotanus.nobel.repository;
  
import com.schotanus.nobel.entity.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
  
@Repository 
public interface LanguageRepository extends JpaRepository<Language, String>{
}