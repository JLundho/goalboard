/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;


import com.jlundhoo.goalsky.db.ProfileDAOImpl;
import com.jlundhoo.goalsky.db.dao.ProfileDAO;
import com.jlundhoo.goalsky.models.Profile;
import java.util.List;

/**
 *
 * @author jonas
 */
public class ProfileService {

    ProfileDAO profileDAO;
    
    public ProfileService(){
        profileDAO = new ProfileDAOImpl();
    }
    
    public List<Profile> returnProfiles() throws Exception{
        return profileDAO.getAllProfiles();
    }
    
    public Profile getProfile(String name){
        return profileDAO.getProfile(name);
    }

    public void postProfile(Profile profile) {
        profileDAO.postProfile(profile);
    }
    
    public void updateProfile(Profile profile, String name) {
        profileDAO.updateProfile(profile, name);
    }
    
    public void deleteProfile(String name) {
        profileDAO.deleteProfile(name);
    }
}
