/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db.dao;


import com.jlundhoo.goalsky.models.Profile;
import java.util.List;

/**
 *
 * @author jonas
 */
public interface ProfileDao {
    
    public List<Profile> getAllProfiles();
    
    public Profile getProfile(String name);
    
    public void postProfile(Profile goal);
    
    public Profile updateProfile(Profile goal, String name);
    
    public void deleteProfile(String name);  
}
