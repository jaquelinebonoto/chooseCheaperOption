/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reservahotel.entities;

import static br.com.reservahotel.entities.Customer.REGULAR;
import static br.com.reservahotel.entities.Customer.REWARD;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jaqueline
 */
public class Hotel {
    
    private int rating;
    private String name;
    private double weekDayReward;
    private double weekDayRegular;
    private double weekendReward;
    private double weekendRegular;

    public Hotel(int rating, String name, double weekDayReward, double weekDayRegular, double weekendReward, double weekendRegular) {
        this.rating = rating;
        this.name = name;
        this.weekDayReward = weekDayReward;
        this.weekDayRegular = weekDayRegular;
        this.weekendReward = weekendReward;
        this.weekendRegular = weekendRegular;
    }

    public double getWeekDayReward() {
        return weekDayReward;
    }

    public void setWeekDayReward(double weekDayReward) {
        this.weekDayReward = weekDayReward;
    }

    public double getWeekDayRegular() {
        return weekDayRegular;
    }

    public void setWeekDayRegular(double weekDayRegular) {
        this.weekDayRegular = weekDayRegular;
    }

    public double getWeekendReward() {
        return weekendReward;
    }

    public void setWeekendReward(double weekendReward) {
        this.weekendReward = weekendReward;
    }

    public double getWeekendRegular() {
        return weekendRegular;
    }

    public void setWeekendRegular(double weekendRegular) {
        this.weekendRegular = weekendRegular;
    }
    
    
    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public double calculateDailyFee(Customer c, Date d) {
        double dailyFee =0.0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if(c==REGULAR){
            if(day==7 || day==1){
                dailyFee = this.weekendRegular;
            }else{
                dailyFee = this.weekDayRegular;
            }
        }else if(c==REWARD){
            if(day==7 || day==1){
                dailyFee = this.weekendReward;
            }else{
                dailyFee = this.weekDayReward;
            }
        }
        return dailyFee;
    }
      
      
    public double calculateTotalFee(Customer c, List<Date> dates) {
        double sum = 0.0;
        
        for(Date d: dates){
            sum = sum + calculateDailyFee(c, d);
        }
        return sum;
    }
}
