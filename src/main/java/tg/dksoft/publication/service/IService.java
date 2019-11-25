/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.service;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Birkhoff
 * @param <U>
 * @param <T>
 */
public interface IService<U, T> {

    /**
     *
     * @param id
     * @return
     */
    public T find(U id);

    /**
     *
     * @return
     */
    public List<T> findAll();

    /**
     *
     * @param t
     * @return
     */
    public T save(T t);

    /**
     *
     * @param ts
     * @return
     */
    public List<T> saveAll(List<T> ts);

    /**
     *
     * @param t
     * @return
     */
    public T update(T t);

    /**
     *
     * @param t
     */
    public void delete(T t);

    /**
     *
     * @param ts
     */
    public void deleteAll(List<T> ts);

    /**
     *
     * @param criteria
     * @return
     */
    public Query createCriteriaQuery(CriteriaQuery criteria);

    /**
     *
     * @param query
     * @return
     */
    public Query createSqlQuery(String query);

    /**
     *
     * @param query
     * @return
     */
    public Query createHqlQuery(String query);

}
