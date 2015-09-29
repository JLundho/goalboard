/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db;

import com.jlundhoo.goalsky.db.dao.ProfileDAO;
import com.jlundhoo.goalsky.models.Profile;
import com.jlundhoo.goalsky.utils.DBUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonas
 */
public class ProfileDAOImpl implements ProfileDAO{
    
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection connect = null;
    
    @Override
    public List<Profile> getAllProfiles() {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("SELECT * FROM PROFILES");
            resultSet = statement.executeQuery();
            return DBUtils.convertProfileResultsetToList(resultSet);
            
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
        return null;
    }
    
    @Override
    public void postProfile(Profile profile) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            statement = connect.prepareStatement("INSERT INTO PROFILES(PROFILE_NAME,FIRSTNAME,LASTNAME,CREATION_DATE) VALUES('"+
                    profile.getName()+"','"+
                    profile.getFirstName()+"','"+
                    profile.getLastName()+"','"+
                    "2015-05-05')");
            statement.executeUpdate();
            
            //returns the goal that was just inserted into the DB
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }   
    }
    
    @Override
    public Profile getProfile(String name) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("SELECT * FROM PROFILES WHERE PROFILE_NAME='"+name+"'");
            resultSet = statement.executeQuery();
            return DBUtils.convertResultsetToProfile(resultSet);
            
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
        return null;
    }

    
    @Override
    public Profile updateProfile(Profile profile, String name) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("UPDATE PROFILES "
                    + "SET FIRSTNAME='"+profile.getFirstName()+"',"
                    + "LASTNAME='"+profile.getLastName()+"' "
                    + "WHERE PROFILE_NAME='"+name+"'");
            statement.executeUpdate();
            
            //returns the goal that was just inserted into the DB
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
        }
        return profile;
    }

    @Override
    public void deleteProfile(String name) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("DELETE FROM PROFILES WHERE PROFILE_NAME='"+name+"'");
            statement.executeUpdate();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
    }

    
    private void close() {
        try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (statement != null) {
              statement.close();
            }
            if (connect != null) {
              connect.close();
            }
      } catch (Exception e) {

      }
    }


    
    
}
