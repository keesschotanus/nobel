package com.schotanus.nobel.service;

import java.util.List;

import com.schotanus.nobel.entity.NobelPrizeLaureate;
import com.schotanus.nobel.entity.Scientist;


public interface ScientistService {

    /**
     * Fetches all scientists plus the Nobel Prizes they won.
     * @return All scientists, including the nobel prizes they have won.
     */
    List<Scientist> getScientists();

    /**
     * Fetches a single scientist by its id.
     * @return Scientist with the supplied id.
     */
    Scientist getScientist(Long id);

    /**
     * Fetches a single combination of a Nobel prize and a scientist.
     * @param nobelPrizeId The id of the nobel prize.
     * @param scientistId The id of the scientist.
     * @return The combination of a Nobel prize and a scientist.
     */
    NobelPrizeLaureate getNobelPrizeLaureates(final Long nobelPrizeId, final Long scientistId);

}
