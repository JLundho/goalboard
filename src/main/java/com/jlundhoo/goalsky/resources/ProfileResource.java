/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.resources;
import com.jlundhoo.goalsky.models.Profile;
import com.jlundhoo.goalsky.services.ProfileService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jonas
 */

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
    
    ProfileService mProfileService = new ProfileService();
    
    @GET
    public List<Profile> getProfiles() throws Exception {
        return mProfileService.returnProfiles();
    }
    
    @POST
    public Profile postProfile(Profile profile) throws Exception {
        mProfileService.postProfile(profile);
        return profile;
    }
    
    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName")String name) throws Exception {
        return mProfileService.getProfile(name); 
    }
    
    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName")String name, Profile profile) throws Exception {
        profile.setName(name);
        mProfileService.updateProfile(profile, name);
        return profile; 
    }
    
    @DELETE
    @Path("/{profileName}")
    public Profile deleteProfile(@PathParam("profileName")String name) throws Exception {
        mProfileService.deleteProfile(name);
        return null;
    }
    
}
