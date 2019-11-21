/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IService;

/**
 *
 * @author Birkhoff
 * @param <T>
 */
public class ServiceImpl<T extends Serializable> implements IService<T> {

    IGenericRepository genericRepository;
    Class<T> classType;

    @Override
    public T save(T t) {
        return genericRepository.save(t);
    }

    @Override
    public List<T> saveAll(List<T> ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T update(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll(List<T> ts) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ServiceImpl(Class<T> classType, IGenericRepository genericRepository) {
        this.classType = classType;
        this.genericRepository = genericRepository;
    }

    @Override
    public Query createCriteriaQuery(CriteriaQuery criteria) {
        return genericRepository.createCriteriaQuery(criteria);
    }

    @Override
    public Query createSqlQuery(String query) {
        return genericRepository.createSqlQuery(query);
    }

    @Override
    public Query createHqlQuery(String query) {
        return genericRepository.createHqlQuery(query);
    }

}
