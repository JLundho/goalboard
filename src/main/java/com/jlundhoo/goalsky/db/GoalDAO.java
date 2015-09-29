/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db;

import com.jlundhoo.goalsky.db.dao.Dao;
import com.jlundhoo.goalsky.models.GoalEO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */

public class GoalDAO extends Dao {

    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection connect = null;
    
    Logger logger = Logger.getLogger(GoalDAO.class.getName());

    public List<GoalEO> getAllGoals() {
        List<GoalEO> goalList = new ArrayList(readAll());
        logger.log(Level.INFO, "goalList successfully read");
        return goalList;
    }

    public GoalEO getGoal(int id) {
        connect();
        try{
            statement = connect.prepareStatement("SELECT * FROM GOALS WHERE GOAL_ID="+id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }
        return null;
    }
    
    public void postGoal(GoalEO goal) {
        connect();
        try{
            statement = connect.prepareStatement("INSERT INTO GOALS(USER_ID,TITLE,CREATION_DATE) VALUES("+goal.getUserID()+",'"+goal.getTitle()+"','2015-05-05')");
            statement.executeUpdate();
            //returns the goal that was just inserted into the DB
        } catch (SQLException e) {
            Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            close();
        }   
    }

    public GoalEO updateGoal(GoalEO goal, int id) {
        connect();
        try{
            statement = connect.prepareStatement("UPDATE GOALS "
                    + "SET USER_ID="+goal.getUserID()+","
                    + "TITLE='"+goal.getTitle()+"' "
                    + "WHERE GOAL_ID="+id);
            statement.executeUpdate();
            
            //returns the goal that was just inserted into the DB
            } catch (SQLException e) {
                Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
        return goal;
    }

    public void deleteGoal(int id) {
        connect();
        
        try {
            statement = connect.prepareStatement("DELETE FROM GOALS WHERE GOAL_ID="+id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
                close();
        }
           
    }
    
    private void connect() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/GoalDB");
            
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(GoalDAO.class.getName()).log(Level.SEVERE, null, ex);
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
