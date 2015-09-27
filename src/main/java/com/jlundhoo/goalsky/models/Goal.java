package com.jlundhoo.goalsky.models;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonas
 */

@XmlRootElement
public class Goal {
    
    private int goalID;
    private int userID;
    private String title;
    private Date creationDate;
    
    //Empty argument constructor for converting to XML/JSON
    public Goal(){
    }

    public Goal(int userID, String title){
        this.userID = userID;
        this.title = title;
        this.creationDate = new Date();
    }
    

    public int getUserID() {
        return userID;
    }
    
    public int getGoalID() {
        return goalID;
    }
    
    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public String toString(){
        return "userId: "+this.getUserID()+"goalId: "+this.goalID+"Title: "+this.getTitle()+"Creation date: "+this.getCreationDate();
    }

    
}
