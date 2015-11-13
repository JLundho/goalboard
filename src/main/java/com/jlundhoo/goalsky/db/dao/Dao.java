/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author jlundhol 
 * @param <E> 
 * @param <PK> 
 */

@Stateless  
public class Dao<E, PK extends Serializable> 
    implements DaoBase<E, PK>  {
    
    private static final String PERSISTENCE_UNIT_NAME = "GoalPU";
    
    protected Class entityClass;
    
    @PersistenceUnit
    protected EntityManager entityManager;
    
    protected EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    @Override
    public E create(E entity) {
        entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }
    
    @Override
    public E read(PK id) {
        entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager = getEntityManager();
        entityManager.getTransaction().commit();
        return (E) this.entityManager.find(entityClass, id);
    }

    @Override
    public E update(E entity) {
        entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        return this.entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
       entityManager = getEntityManager();
       entityManager.getTransaction().begin();
       entity = this.entityManager.merge(entity);
       this.entityManager.remove(entity);
       entityManager.getTransaction().commit();
    }
     
    public EntityManager getEntityManager() {
          return factory.createEntityManager();
    }
}

