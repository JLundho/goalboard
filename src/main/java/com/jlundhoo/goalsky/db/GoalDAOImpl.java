/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlundhoo.goalsky.db;

import com.jlundhoo.goalsky.db.dao.GoalDAO;
import com.jlundhoo.goalsky.models.Goal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.jlundhoo.goalsky.utils.DBUtils;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jonas
 */

public class GoalDAOImpl implements GoalDAO {
    
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    Connection connect = null;

    @Override
    public List<Goal> getAllGoals() {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("SELECT * FROM GOALS");
            resultSet = statement.executeQuery();
            return DBUtils.convertGoalResultsetToList(resultSet);
            
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
        return null;
    }

    @Override
    public Goal getGoal(int id) {
         try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("SELECT * FROM GOALS WHERE GOAL_ID="+id);
            resultSet = statement.executeQuery();
            return DBUtils.convertResultsetToGoal(resultSet);
            
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }
        return null;
    }
    
    @Override
    public void postGoal(Goal goal) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            statement = connect.prepareStatement("INSERT INTO GOALS(USER_ID,TITLE,CREATION_DATE) VALUES("+goal.getUserID()+",'"+goal.getTitle()+"','2015-05-05')");
            statement.executeUpdate();
            
            //returns the goal that was just inserted into the DB
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
            }   
    }

    @Override
    public Goal updateGoal(Goal goal, int id) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            Date now = new Date();
            statement = connect.prepareStatement("UPDATE GOALS "
                    + "SET USER_ID="+goal.getUserID()+","
                    + "TITLE='"+goal.getTitle()+"' "
                    + "WHERE GOAL_ID="+id);
            statement.executeUpdate();
            
            //returns the goal that was just inserted into the DB
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                close();
        }
        return goal;
    }

    @Override
    public void deleteGoal(int id) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/goalDB");
            
            statement = connect.prepareStatement("DELETE FROM GOALS WHERE GOAL_ID="+id);
            statement.executeUpdate();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                Logger.getLogger(GoalDAOImpl.class.getName()).log(Level.SEVERE, null, e);
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
