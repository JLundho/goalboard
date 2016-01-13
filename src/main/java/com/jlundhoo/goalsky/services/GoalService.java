/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;


import com.jlundhoo.goalsky.db.dao.GoalDao;
import com.jlundhoo.goalsky.models.Goal;
import java.util.Collection;

/**
 *
 * @author jonas
 */
public class GoalService {
    
    GoalDao goalDao = new GoalDao();

    public Collection<Goal> getAllGoals() throws Exception{
        return goalDao.getAllGoals();
    }
    
    public void postGoal(Goal goal) {
        goalDao.postGoal(goal);
    }
    
    public Goal getGoal(int id){
        return goalDao.getGoal(id);
    }

    public void updateGoal(Goal goal) {
        goalDao.updateGoal(goal);
    }
    
    public void deleteGoal(Goal goal) {
        goalDao.deleteGoal(goal);
    }

    
}