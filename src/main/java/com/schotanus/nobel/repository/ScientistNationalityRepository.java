package com.schotanus.nobel.repository;

import com.schotanus.nobel.entity.ScientistNationality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ScientistNationalityRepository extends JpaRepository<ScientistNationality, String>{
    
}
