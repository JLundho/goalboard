/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.services;


import com.jlundhoo.goalsky.db.ProfileDaoImpl;
import com.jlundhoo.goalsky.db.dao.ProfileDao;
import com.jlundhoo.goalsky.models.Profile;
import java.util.List;

/**
 *
 * @author jonas
 */
public class ProfileService {

    ProfileDao profileDao;
    
    public ProfileService(){
        profileDao = new ProfileDaoImpl();
    }
    
    public List<Profile> returnProfiles() throws Exception{
        return profileDao.getAllProfiles();
    }
    
    public Profile getProfile(String name){
        return profileDao.getProfile(name);
    }

    public void postProfile(Profile profile) {
        profileDao.postProfile(profile);
    }
    
    public void updateProfile(Profile profile, String name) {
        profileDao.updateProfile(profile, name);
    }
    
    public void deleteProfile(String name) {
        profileDao.deleteProfile(name);
    }
}
