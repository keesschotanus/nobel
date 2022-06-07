package com.schotanus.nobel.service;

import java.util.List;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.entity.NobelPrizeCategory;

public interface NobelService {
    List<NobelPrize> getNobelPrizes(int year);
    NobelPrize getNobelPrize(int year, NobelPrizeCategory category);
}
