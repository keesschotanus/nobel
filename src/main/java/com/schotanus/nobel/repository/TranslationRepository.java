package com.schotanus.nobel.repository;

import com.schotanus.nobel.entity.Translation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
  
@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long>{
    
}
