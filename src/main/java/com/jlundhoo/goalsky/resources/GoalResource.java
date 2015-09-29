/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.resources;

import com.jlundhoo.goalsky.models.Goal;
import com.jlundhoo.goalsky.services.GoalService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    
    @DefaultValue("") @QueryParam("year")
    private int year;
    
    @DefaultValue("0") @QueryParam("offset")
    private int offset;
    
    @DefaultValue("10") @QueryParam("size")
    private int size;
    
    @DefaultValue("desc") @QueryParam("orderby")
    private String orderby;
    
    @DefaultValue("CREATION_DATE") @QueryParam("sortby")
    private String sortby;
    
    @GET
    public List<Goal> getGoals() throws Exception {
        return mGoalService.returnGoals(year, offset, size);
    }   
    
    @POST
    public Goal postGoal(Goal goal){
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
    public Goal updateGoal(@PathParam("goalId") int id, Goal goal) throws Exception {
        goal.setGoalID(id);
        mGoalService.updateGoal(goal, id);
        return goal;
    }
    
    @DELETE
    @Path("/{goalId}")
    public Goal deleteGoal(@PathParam("goalId") int id) throws Exception {
        //Return different response based on result
        mGoalService.deleteGoal(id);
        return null;
    }
}