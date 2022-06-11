package com.schotanus.nobel.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.entity.NobelPrizeCategory;
import com.schotanus.nobel.entity.Scientist;
import com.schotanus.nobel.repository.NobelPrizeRepository;
import com.schotanus.nobel.repository.ScientistRepository;

@Service
public class NobelServiceImpl implements NobelService {

    @Autowired
    NobelPrizeRepository nobelPrizeRepository;

    @Autowired
    ScientistRepository scientistRepository;

    public List<NobelPrize> getNobelPrizes(final int year) {
        return nobelPrizeRepository.findByYear(year);
    }

    public NobelPrize getNobelPrize(int year, NobelPrizeCategory category) {
        return nobelPrizeRepository.findByYearAndCategory(year, category);
    }

    @Transactional()
    public List<Scientist> getScientists() {
        List<Scientist> scientists = scientistRepository.findAll();
        scientists.forEach(scientist -> {
            scientist.getNationalities().forEach(nationality -> {});
            scientist.getNobelPrizes().forEach(nobelPrize -> {});
        });

        return scientists;
    }

    @Transactional
    public List<NobelPrize> getNobelPrizes() {
        List<NobelPrize> nobelPrizes = nobelPrizeRepository.findAll();
        nobelPrizes.forEach(nobelPrize -> nobelPrize.getScientists().forEach(scientist -> {}));

        return nobelPrizes;
    }

}
    
