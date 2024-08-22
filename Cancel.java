package BusReservation;

import java.util.ArrayList;
import java.util.Date;

public class Cancel {
    public boolean cancelTicket(ArrayList<Bus> buses, ArrayList<Booking> bookings, String name, int busno, Date date)
    {
        for(Bus bus:buses)
        {
            if(bus.getBusNo()==busno)
            {
                for(Booking b:bookings){
                    if(b.pasangerName.equals(name)&&b.date.equals(date))
                    {
                        bus.setCapacity(bus.getcapasity()+b.Noofticits);
                        bookings.remove(b);
//                        cancelSucess = false;
                        return true;
                    }
                }
            }
//            else {
//                System.out.println("bus not exisit");
//            }
////            i++;
        }
        return false;
    }
}
