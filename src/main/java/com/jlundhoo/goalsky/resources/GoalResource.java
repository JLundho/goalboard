/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.resources;

import com.jlundhoo.goalsky.models.Goal;
import com.jlundhoo.goalsky.services.GoalService;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jonas
 */
@Path("/goals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GoalResource {
    GoalService mGoalService = new GoalService();

    @GET
    public Collection<Goal> getGoals() throws Exception {
        return mGoalService.getAllGoals();
    }   
    
    @POST
    public Goal postGoal(Goal goal){
        goal.setCreationDate();
        mGoalService.postGoal(goal);
        return goal;
    }
    
    @GET
    @Path("/{goalId}")
    public Goal getGoal(@PathParam("goalId") int id) throws Exception {
        return mGoalService.getGoal(id);
    }
    
    @PUT
    @Path("/{goalId}")
    public Goal updateGoal(Goal goal) throws Exception {
        mGoalService.updateGoal(goal);
        return goal;
    }
    
    @DELETE
    @Path("/{goalId}")
    public Goal deleteGoal(Goal goal) throws Exception {
        mGoalService.deleteGoal(goal);
        return null;
    }
}