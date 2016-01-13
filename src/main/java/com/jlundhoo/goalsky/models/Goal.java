package com.jlundhoo.goalsky.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.SourceType;

/**
 *
 * @author jonas
 */

@XmlRootElement
@Entity
public class Goal implements Serializable {
    
    @Id
    private int goalID;
    private int userID;
    private String title;
    
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    
    public int getGoalID() {
        return goalID;
    }
    
    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }
    
    public int getUserID() {
        return userID;
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

    public void setCreationDate() {
        Date date = new Date();
        this.creationDate = date;
    }
    
    public String toString(){
        return "userId: "+this.getUserID()+"goalId: "+this.goalID+"Title: "+this.getTitle()+"Creation date: "+this.getCreationDate();
    }

    
}