package com.dvortsov.cdstore.dao;

import com.dvortsov.cdstore.dao.entities.CD;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CDDao {

    @PersistenceContext
    private EntityManager em;

    public List<CD> list(Integer offset, Integer maxResults) {
        Query query = em.createQuery("From CD");
        query.setFirstResult(offset != null ? offset : 0);
        query.setMaxResults(maxResults != null ? maxResults : 10);
        List<CD> cdList = query.getResultList();

        return cdList;
    }

    public long count() {
        Query queryTotal = em.createQuery
                ("Select count(cd.id) from CD cd");
        long countResult = (long) queryTotal.getSingleResult();
        return countResult;
    }

    public void merge(CD cd) {
        em.merge(cd);
    }

    public List<CD> getAll() {
        Query query = em.createQuery("from CD");
        List<CD> all = query.getResultList();
        return all;
    }
}


