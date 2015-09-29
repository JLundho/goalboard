/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;


import com.jlundhoo.goalsky.db.GoalDAO;
import com.jlundhoo.goalsky.models.GoalEO;
import java.util.List;

/**
 *
 * @author jonas
 */
public class GoalService {
    
    GoalDAO goalDAO;
    
    public GoalService(){
        goalDAO = new GoalDAO();
    }
    
    public List<GoalEO> getAllGoals() throws Exception{
        return goalDAO.getAllGoals();
    }
    
    public GoalEO getGoal(int id){
        return goalDAO.getGoal(id);
    }

    public void postGoal(GoalEO goal) {
        goalDAO.postGoal(goal);
    }
    
    public void updateGoal(GoalEO goal, int id) {
        goalDAO.updateGoal(goal, id);
    }
    
    public void deleteGoal(int id) {
        goalDAO.deleteGoal(id);
    }

    
}
