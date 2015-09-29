/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.resources;

import com.jlundhoo.goalsky.models.GoalEO;
import com.jlundhoo.goalsky.services.GoalService;
import java.util.List;
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
    public List<GoalEO> getGoals() throws Exception {
        return mGoalService.getAllGoals();
    }   
    
    @POST
    public GoalEO postGoal(GoalEO goal){
        mGoalService.postGoal(goal);
        return goal;
    }
    
    @GET
    @Path("/{goalId}")
    public GoalEO getGoal(@PathParam("goalId") int id) throws Exception {
        return mGoalService.getGoal(id);
    }
    
    @PUT
    @Path("/{goalId}")
    public GoalEO updateGoal(@PathParam("goalId") int id, GoalEO goal) throws Exception {
        goal.setGoalID(id);
        mGoalService.updateGoal(goal, id);
        return goal;
    }
    
    @DELETE
    @Path("/{goalId}")
    public GoalEO deleteGoal(@PathParam("goalId") int id) throws Exception {
        //Return different response based on result
        mGoalService.deleteGoal(id);
        return null;
    }
}