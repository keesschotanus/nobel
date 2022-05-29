package com.schotanus.nobel.repository;

import com.schotanus.nobel.entity.Scientist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientistRepository extends JpaRepository<Scientist, String>{
    
}

