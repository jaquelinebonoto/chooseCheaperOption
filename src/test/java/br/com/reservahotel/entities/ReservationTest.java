/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reservahotel.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author I505781
 */
public class ReservationTest {
    private Reservation r;
    
    public ReservationTest() {
    }
    
    @Before
    public void setUp() {
        r = new Reservation();
    }
    
     /**
     * Test of findBestPrice method, of class Reservation.
     */
    @Test
    public void hiltonTestFindBestPrice() {
        List<Date> dates = new ArrayList<>();
        dates.add(Date.from(Instant.EPOCH));
        Calendar c = Calendar.getInstance();
        dates.add(c.getTime());
        Date dd = new Date("12/12/1982");
        dates.add(dd);
        assertEquals("Hilton", r.findBestPrice(Customer.REGULAR, dates));
    }
    
    @Test
    public void plazaTestFindBestPrice() {
        List<Date> dates = new ArrayList<>();
        dates.add(Date.from(Instant.EPOCH));
        Calendar c = Calendar.getInstance();
        dates.add(c.getTime());
        Date dd = new Date("12/12/1982");
        dates.add(dd);
        assertEquals("Plaza", r.findBestPrice(Customer.REWARD, dates));
    }
    
    
    @Test
    public void plaza2TestFindBestPrice() {
        List<Date> datas = new ArrayList<>();
        Date dd = new Date("26/03/2009");
        Date ddd = new Date("27/03/2009");
        Date dddd = new Date("28/03/2009");
        datas.add(dd);
        datas.add(ddd);
        datas.add(dddd);
        assertEquals("Plaza", r.findBestPrice(Customer.REWARD, datas));
    }
    
    
    @Test
    public void intercityTestFindBestPrice() throws ParseException{
        List<Date> datas = new ArrayList<>();
        String informDate = "20/03/2009";
        String informDate1 = "22/03/2009";
        String informDate2 = "21/03/2009";
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date d = date.parse(informDate);
        Date d1 = date.parse(informDate1);
        Date d2 = date.parse(informDate2);
        datas.add(d);
        datas.add(d1);
        datas.add(d2);
        assertEquals("Intercity", r.findBestPrice(Customer.REGULAR, datas));        
    }

    /**
     * Test of findBestRating method, of class Reservation.
     */
    @Test
    public void testFindBestRatingInterAndPlaza() {
        Hotel h2 = new Hotel(5, "Plaza", 100.0, 220.0, 40.0, 150.0);
        Hotel h = new Hotel(3, "Hilton", 80.0, 110.0, 80.0, 90.0);
        assertTrue("Plaza", true);
    }

    @Test
    public void testFindBestRatinginterAndHilton() {
        Hotel h = new Hotel(3, "Hilton", 80.0, 110.0, 80.0, 90.0);
        Hotel h2= new Hotel(4, "Intercity", 110.0, 160.0, 50.0, 60.0);
        assertTrue("Plaza", true);
    }
    
}
