/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jlundhol 
 * @param <E> 
 * @param <PK> 
 */

public class Dao<E, PK extends Serializable> 
    implements DaoBase<E, PK>  {
    
    protected Class entityClass;
    
    public EntityManager entityManager;
    
    private static final String PERSISTENCE_UNIT_NAME = "com.jlundhoo_goalsky_war_1.0-SNAPSHOTPU";
    public EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
   
    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }
    
    @Override
    public E read(PK id) {
        return (E) this.entityManager.find(entityClass, id);
    }


    public E update(E entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
       entity = this.entityManager.merge(entity);
       this.entityManager.remove(entity);
    }
     
    public EntityManager getEntityManager() {
          return factory.createEntityManager();
    }
}

