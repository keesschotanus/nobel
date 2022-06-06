package com.schotanus.nobel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.repository.NobelPrizeRepository;

@Service
public class NobelServiceImpl implements NobelService {

    @Autowired
    NobelPrizeRepository nobelPrizeRepository;

    @Override
    public List<NobelPrize> getNobelPrizes(final int year) {
        return nobelPrizeRepository.findByYear(year);
    }

}
    
