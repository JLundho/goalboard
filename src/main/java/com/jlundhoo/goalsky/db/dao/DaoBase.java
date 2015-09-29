/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import com.jlundhoo.goalsky.models.GoalEO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.hibernate.Session;

/**
 *
 * @author jlundhol 
 */
public class DaoBase implements Dao{
    
    @PersistenceUnit
    private EntityManagerFactory emf;
             
    EntityManager entityManager;
    private Session session;
    
    public DaoBase(){
        entityManager = null;
        
    }
       
    //The emf corresponding to 
    

    @Override
    public void create(GoalEO goalEO) {
        
       
    }
    
    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        
    }

    @Override
    public void delete() {
        
    }

    

    
}
