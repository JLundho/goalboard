/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;

import com.jlundhoo.goalsky.models.Goal;
import java.util.List;

/**
 *
 * @author jonas
 */

public interface GoalDAO{
    
    public List<Goal> getAllGoals();
    
    public Goal getGoal(int id);
    
    public void postGoal(Goal goal);
    
    public Goal updateGoal(Goal goal, int id);
    
    public void deleteGoal(int id);  
}
