package BusReservation;

import java.util.ArrayList;

public class view {
    view(ArrayList<Booking> book){
        for(Booking b:book){
            System.out.println("Name is "+b.pasangerName+" Bus no is "+b.busNo+" date of traval "+b.date+" No of tickets = "+b.Noofticits);
        }
    }
}
