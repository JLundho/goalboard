/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;

import com.jlundhoo.goalsky.db.dao.GoalDAO;
import com.jlundhoo.goalsky.db.GoalDAOImpl;
import com.jlundhoo.goalsky.models.Goal;
import java.util.List;

/**
 *
 * @author jonas
 */
public class GoalService {
    
    GoalDAO goalDAO;
    
    public GoalService(){
        goalDAO = new GoalDAOImpl();
    }
    
    public List<Goal> returnGoals(int year, int start, int size) throws Exception{
        return goalDAO.getAllGoals(year, start, size);
    }
    
    public List<Goal> returnGoalsWithinYear(int year, int start, int size) {
        return goalDAO.returnGoalsWithinYear(year);
    }
    
    public Goal getGoal(int id){
        return goalDAO.getGoal(id);
    }

    public void postGoal(Goal goal) {
        goalDAO.postGoal(goal);
    }
    
    public void updateGoal(Goal goal, int id) {
        goalDAO.updateGoal(goal, id);
    }
    
    public void deleteGoal(int id) {
        goalDAO.deleteGoal(id);
    }

    
}
