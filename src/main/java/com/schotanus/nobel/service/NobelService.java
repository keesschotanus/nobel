package com.schotanus.nobel.service;

import java.util.List;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.entity.NobelPrizeCategory;

public interface NobelService {
    /**
     * Fetches all Nobel prizes of the supplied year.
     * @param year The year to get the Nobel prizes for.
     * @return All Nobel prizes of the supplied year.
     */
    List<NobelPrize> getNobelPrizes(int year);

    /**
     * Fetches a single Nobel prize with the supplied year and category.
     * @param year The year of the nobel prize.
     * @param category The category of the nobel prize.
     * @return The nobel prize with the supplied year and category.
     */
    NobelPrize getNobelPrize(int year, NobelPrizeCategory category);

    /**
     * Fetches all Nobel prizes plus the Scientists that won them.
     * @return All Nobel prizes, including the prizes that have not yet been won by a Scientist.
     */
    List<NobelPrize> getNobelPrizes();

}
