package com.schotanus.nobel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schotanus.nobel.entity.Scientist;
import com.schotanus.nobel.service.ScientistService;

@RestController
@RequestMapping(value = "/scientists")
public class ScientistController {

    @Autowired
    private ScientistService scientistService;

    @GetMapping
    public List<Scientist> getScientists() {
        return this.scientistService.getScientists();
    }
    
    @GetMapping("/{id}")
    public Scientist getScientist(@PathVariable Long id) {
        return this.scientistService.getScientist(id);
    }

}