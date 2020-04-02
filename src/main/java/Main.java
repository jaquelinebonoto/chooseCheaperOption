/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.reservahotel.entities.Customer;
import br.com.reservahotel.entities.Reservation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jaqueline
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        String keepGoing = "y";
        String oneMoreDate = "t";
        Scanner s = new Scanner(System.in);   
        List<Date> dates = new ArrayList<>();
        
        //user starts interacting with the program
        while(keepGoing.equalsIgnoreCase("y")){
            String result = null;
            boolean flag = true; 
            Customer typeCustomer = null;
            String customer = null;
                        
            System.out.println("Hello! We are so glad you are here today! \nAre you a REGULAR or a REWARD customer?");
            //user inform typeCustomer once
            while(flag==true){
                try{
                customer = s.nextLine();
                typeCustomer = Enum.valueOf(Customer.class, customer.toUpperCase());
                flag = false;
                }catch(IllegalArgumentException e){
                    System.out.println("Please, type REWARD or REGULAR. We don't mind if you don't use uppercase ;) ");  
                }      
            }
            System.out.println("You are a " + customer.toUpperCase() +" customer."); 
            System.out.println("Please insert dates to consult the best hotel. Use format 'dd/MM/yyyy'"); 
            
            oneMoreDate = "t";
            //user inform as many dates as they need for each consult
            while(oneMoreDate.equalsIgnoreCase("t")){
                try{
                    String informDate = s.nextLine();
                    DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                    Date da = date.parse(informDate); //esse parse esta fazendo ficar no formato ISO
                    dates.add(da);                       
                    System.out.println("Insert one more date? t/f");
                    oneMoreDate = s.nextLine();
                }catch(ParseException e){
                    System.out.println("Please, use the format 'dd/MM/yyyy'");  
                }     
            }
            
            //a reservation is created with user's data
            Reservation r = new Reservation();
            result = r.findBestPrice(typeCustomer, dates);
            
            System.out.println("The best option is "+ result);
            
            //reset the reservation and start over or just quit
            System.out.println("Would you like to create a new reservation? (y/n)");
            keepGoing = s.nextLine();
            dates.clear();
            result = null;
        }
    }
}
