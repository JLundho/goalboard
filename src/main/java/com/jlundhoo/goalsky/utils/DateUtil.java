package com.jlundhoo.goalsky.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonas
 */


public class DateUtil {
    
    public static Date formatDateForDB(Date date){
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
       dateFormat.format(date);
       return date;
    }
      
}
