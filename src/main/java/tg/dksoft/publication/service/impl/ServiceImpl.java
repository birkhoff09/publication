/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import tg.dksoft.publication.exceptions.DocumentNotFoundException;
import tg.dksoft.publication.repository.IGenericRepository;
import tg.dksoft.publication.service.IService;

/**
 *
 * @author Birkhoff
 * @param <U>
 * @param <T>
 */
public abstract class ServiceImpl<U extends Serializable, T extends Serializable> implements IService<U, T> {
    
    protected IGenericRepository<U, T> genericRepository;
    Class<T> clazz;
    
    public ServiceImpl(Class<T> clazz, IGenericRepository<U, T> genericRepository) {
        this.clazz = clazz;
        this.genericRepository = genericRepository;
    }
    
    @Override
    public T find(U id) {
        return genericRepository.find(id, clazz).orElseThrow(() -> new DocumentNotFoundException());
    }
    
    @Override
    public List<T> findAll() {
        return genericRepository.findAll(clazz).orElseThrow(() -> new DocumentNotFoundException());
    }
    
    @Override
    public T save(T t) {
        return (T) genericRepository.save(t);
    }
    
    @Override
    public List<T> saveAll(List<T> ts) {
        return genericRepository.saveAll(ts);
    }
    
    @Override
    public T update(T t) {
        return (T) genericRepository.update(t);
    }
    
    @Override
    public void delete(T t) {
        genericRepository.delete(t);
    }
    
    @Override
    public void deleteAll(List<T> ts) {
        genericRepository.deleteAll(ts);
    }
    
    @Override
    public void createCriteriaQuery(CriteriaQuery criteria) {
        genericRepository.createCriteriaQuery(criteria).executeUpdate();
    }
    
    @Override
    public void createSqlQuery(String query) {
        genericRepository.createSqlQuery(query).executeUpdate();
    }
    
    @Override
    public void createHqlQuery(String query) {
        genericRepository.createHqlQuery(query).executeUpdate();
    }
    
}
