/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import com.jlundhoo.goalsky.models.Goal;

import java.util.logging.Logger;
import java.util.Collection;
import java.util.logging.Level;
import javax.persistence.Query;

/**
 *
 * @author jonas
 */



public class GoalDao extends Dao {
    private static final Logger logger = Logger.getLogger(GoalDao.class.getName());

    public Collection<Goal> getAllGoals() {
        entityManager = getEntityManager();
        Query query;
        query = entityManager.createQuery("SELECT goalID FROM Goal");
        Collection<Goal> goalList = query.getResultList();
        entityManager.close();
        return goalList;
    }
    
    public void postGoal(Goal goal) {
        create(goal);
        entityManager.close();
    }
    
    public Goal getGoal(int id) {
        Goal goal = (Goal) read(id);
        entityManager.close();
        return goal;
    }
    
    public Goal updateGoal(Goal goal) {
        update(goal);
        logger.log(Level.INFO, "Created item with title {0}", goal.getTitle());
        entityManager.close();
        return goal;
    }

    public void deleteGoal(Goal goal) {
        delete(goal);
        entityManager.close();
    }
    
}
