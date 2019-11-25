/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import tg.dksoft.publication.repository.IGenericRepository;

/**
 *
 * @author Birkhoff
 * @param <T>
 */
@Repository
@Transactional
public class GenericRepositoryImpl<T extends Serializable> implements IGenericRepository<T> {

    @PersistenceContext
    EntityManager em;

    @Override
    public T save(T t) {
        em.persist(t);
        em.flush();
        return t;
    }

    @Override
    public List<T> saveAll(List<T> ts) {
        ts.forEach(t -> {
            em.persist(t);
        });
        em.flush();
        return ts;
    }

    @Override
    public T update(T t) {
        return em.merge(t);
    }

    @Override
    public void delete(T t) {
        em.remove(em.merge(t));
    }

    @Override
    public void deleteAll(List<T> ts) {
        ts.forEach(t -> {
            em.remove(em.merge(t));
        });
    }

    @Override
    public Query createSqlQuery(String query) {
        return em.createNativeQuery(query);
    }

    @Override
    public Query createHqlQuery(String query) {
        return em.createQuery(query);
    }

    @Override
    public Query createCriteriaQuery(CriteriaQuery criteria) {
        return em.createQuery(criteria);
    }

    @Override
    public Query createSqlQuery(String query, Class c) {
        return em.createNativeQuery(query, c);
    }

    @Override
    public Query createHqlQuery(String query, Class c) {
        return em.createQuery(query, c);
    }

}
