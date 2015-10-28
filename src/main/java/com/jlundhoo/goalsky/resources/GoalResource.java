/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.resources;

import com.jlundhoo.goalsky.models.GoalEO;
import com.jlundhoo.goalsky.services.GoalService;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;

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
    
<<<<<<< HEAD
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
        if(year > 0 || size > 0){
            return mGoalService.returnGoalsWithinYear(year, offset, size);
        }
        return mGoalService.returnGoals(year, offset, size);
=======
    
    @GET
    public Collection<GoalEO> getGoals() throws Exception {
        return mGoalService.getAllGoals();
>>>>>>> ba5c57578cf227d9b2f1f85816044e41b7c04275
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
    public GoalEO updateGoal(GoalEO goal) throws Exception {
        mGoalService.updateGoal(goal);
        return goal;
    }
    
    @DELETE
    @Path("/{goalId}")
    public GoalEO deleteGoal(GoalEO goal) throws Exception {
        mGoalService.deleteGoal(goal);
        return null;
    }
}