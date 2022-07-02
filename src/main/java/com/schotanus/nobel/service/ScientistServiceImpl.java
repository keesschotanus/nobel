package com.schotanus.nobel.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.schotanus.nobel.entity.NobelPrizeLaureate;
import com.schotanus.nobel.entity.Scientist;

@Service
public class ScientistServiceImpl implements ScientistService{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional()
    @Override
    public List<Scientist> getScientists() {
        final String sql = "SELECT s FROM Scientist s LEFT JOIN FETCH s.nobelPrizes";
        TypedQuery<Scientist> query = this.entityManager.createQuery(sql, Scientist.class);
        
        return query.getResultList();
    }

    @Transactional()
    @Override
    public Scientist getScientist(final Long id) {
        final String sql = "SELECT s FROM Scientist s LEFT JOIN FETCH s.nobelPrizes WHERE s.id = " + id;
        TypedQuery<Scientist> query = this.entityManager.createQuery(sql, Scientist.class);
        
        return query.getSingleResult();
    }

    @Transactional()
    @Override
    public NobelPrizeLaureate getNobelPrizeLaureates(final Long nobelPrizeId, final Long scientistId) {
        final String sql = "SELECT npl FROM NobelPrizeLaureate npl" + " WHERE npl.nobelPrizeId = " + nobelPrizeId + " AND npl.scientistId = " + scientistId;
        TypedQuery<NobelPrizeLaureate> query = this.entityManager.createQuery(sql, NobelPrizeLaureate.class);
        
        return query.getSingleResult();
    }
}
