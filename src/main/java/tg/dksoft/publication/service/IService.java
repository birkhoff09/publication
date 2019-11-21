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
 * @param <T>
 */
public interface IService<T> {

    public T save(T t);

    public List<T> saveAll(List<T> ts);

    public T update(T t);

    public void delete(T t);

    public void deleteAll(List<T> ts);

    public Query createCriteriaQuery(CriteriaQuery criteria);

    public Query createSqlQuery(String query);

    public Query createHqlQuery(String query);

}
