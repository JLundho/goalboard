/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jlundhol 
 * @param <E> 
 * @param <PK> 
 */
public class Dao<E, PK extends Serializable> 
    implements DaoBase<E, PK>  {
    
    protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;
    
    public Dao() {
    	ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public E read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public E update(E entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
       entity = this.entityManager.merge(entity);
       this.entityManager.remove(entity);
    }
        
}

