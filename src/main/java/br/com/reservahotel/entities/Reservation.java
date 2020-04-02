/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reservahotel.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jaqueline
 */
public class Reservation {
    private Customer typeCustomer;
    private List<Date> dates;

      
    public Reservation(Customer typeCustomer, List<Date> dates){
        typeCustomer = this.typeCustomer;
        dates = this.dates;
    }
    
    public Reservation() {}
    
    public String findBestPrice(Customer typeCustomer, List<Date> dates){
        List<Hotel> hotels = startListHotel();
        String result;
        int idx = 0;
        int idx2 = 0;

        double lower = hotels.get(0).calculateTotalFee(typeCustomer, dates);

        for(int i=1; i<hotels.size(); i++){
            double value = hotels.get(i).calculateTotalFee(typeCustomer, dates);
            if(value == lower){
                idx2 = i;
            }
            if (value < lower){
                lower = value;
                idx = i;
            }
        }
        if (idx2 != 0){
            result = findBestRating(hotels.get(idx), hotels.get(idx2));
        }else{
            result = hotels.get(idx).getName();
        }
        return result;
    }

    
    public String findBestRating(Hotel h1, Hotel h2){
        if(h1.getRating()>h2.getRating()){
            return h1.getName();
        }    
        return h2.getName();        
    }

    @Override
    public String toString() {
        return "Reservation{" + "typeCustomer=" + typeCustomer + ", dates=" + dates + '}';
    }
    
    public List<Hotel> startListHotel(){
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(3, "Hilton", 80.0, 110.0, 80.0, 90.0));
        hotels.add(new Hotel(4, "Intercity", 110.0, 160.0, 50.0, 60.0));
        hotels.add(new Hotel(5, "Plaza", 100.0, 220.0, 40.0, 150.0));
        return hotels;
    }
}
