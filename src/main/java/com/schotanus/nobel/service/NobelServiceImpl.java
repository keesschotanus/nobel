package com.schotanus.nobel.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.entity.NobelPrizeCategory;
import com.schotanus.nobel.repository.NobelPrizeRepository;

@Service 
public class NobelServiceImpl implements NobelService {

    @Autowired
    private NobelPrizeRepository nobelPrizeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NobelPrize> getNobelPrizes(final int year) {
        return nobelPrizeRepository.findByYear(year);
    }

    @Override
    public NobelPrize getNobelPrize(int year, NobelPrizeCategory category) {
        return nobelPrizeRepository.findByYearAndCategory(year, category);
    }

    @Transactional()
    @Override
    public List<NobelPrize> getNobelPrizes() {
        final String sql = "SELECT np FROM NobelPrize np LEFT JOIN FETCH np.scientists";
        TypedQuery<NobelPrize> query = this.entityManager.createQuery(sql, NobelPrize.class);
        
        return query.getResultList();
    }
}
    
