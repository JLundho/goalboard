/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;


import com.jlundhoo.goalsky.db.dao.GoalDAO;
import com.jlundhoo.goalsky.models.GoalEO;
import java.util.Collection;

/**
 *
 * @author jonas
 */
public class GoalService {
    
    GoalDAO goalDAO;
    
    public GoalService(){
        goalDAO = new GoalDAO();
    }
    
<<<<<<< HEAD
    public List<Goal> returnGoals(int year, int start, int size) throws Exception{
        return goalDAO.getAllGoals(year, start, size);
    }
    
    public List<Goal> returnGoalsWithinYear(int year, int start, int size) {
        return goalDAO.returnGoalsWithinYear(year);
=======
    public Collection<GoalEO> getAllGoals() throws Exception{
        return goalDAO.getAllGoals();
>>>>>>> ba5c57578cf227d9b2f1f85816044e41b7c04275
    }
    
    public void postGoal(GoalEO goal) {
        goalDAO.postGoal(goal);
    }
    
    public GoalEO getGoal(int id){
        return goalDAO.getGoal(id);
    }

    public void updateGoal(GoalEO goal) {
        goalDAO.updateGoal(goal);
    }
    
    public void deleteGoal(GoalEO goal) {
        goalDAO.deleteGoal(goal);
    }

    
}
