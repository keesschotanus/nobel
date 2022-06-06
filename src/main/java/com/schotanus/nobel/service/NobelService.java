package com.schotanus.nobel.service;

import java.util.List;

import com.schotanus.nobel.entity.NobelPrize;

public interface NobelService {
    List<NobelPrize> getNobelPrizes(int year);  
}
