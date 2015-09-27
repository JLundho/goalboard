/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.utils;

import com.jlundhoo.goalsky.models.Goal;
import com.jlundhoo.goalsky.models.Profile;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jonas
 */
public class DBUtils {
    
    public DBUtils(){
        
    }
    
    public static List<Goal> convertGoalResultsetToList(ResultSet queryResults) throws SQLException{
        List<Goal> goalList = new ArrayList<>();
        
        while (queryResults.next()) {
            Goal goal = new Goal();
            goal.setGoalID(queryResults.getInt("GOAL_ID"));
            goal.setUserID(queryResults.getInt("USER_ID"));
            goal.setTitle(queryResults.getString("TITLE"));
            goal.setCreationDate(queryResults.getDate("CREATION_DATE"));
            goalList.add(goal);
         }
        
        return goalList;
    }
    
    public static List<Profile> convertProfileResultsetToList(ResultSet queryResults) throws SQLException{
        List<Profile> profileList = new ArrayList<>();
        
        while (queryResults.next()) {
            Profile profile = new Profile();
            profile.setName(queryResults.getString("PROFILE_NAME"));
            profile.setFirstName(queryResults.getString("FIRSTNAME"));
            profile.setLastName(queryResults.getString("LASTNAME"));
            profile.setCreationDate(queryResults.getDate("CREATION_DATE"));
            profileList.add(profile);
         }
        
        return profileList;
    }
    
    public static Goal convertResultsetToGoal(ResultSet queryResults) throws SQLException{
        
        Goal goal = new Goal();
        
        while (queryResults.next()) {
            goal.setGoalID(queryResults.getInt("GOAL_ID"));
            goal.setUserID(queryResults.getInt("USER_ID"));
            goal.setTitle(queryResults.getString("TITLE"));
            goal.setCreationDate(queryResults.getDate("CREATION_DATE"));
        }
        return goal;
    }
    
    public static Profile convertResultsetToProfile(ResultSet queryResults) throws SQLException{
        
        Profile profile = new Profile();
        
        while (queryResults.next()) {
            profile.setName(queryResults.getString("PROFILE_NAME"));
            profile.setFirstName(queryResults.getString("FIRSTNAME"));
            profile.setLastName(queryResults.getString("LASTNAME"));
            profile.setCreationDate(queryResults.getDate("CREATION_DATE"));
        }
        return profile;
    }
}
