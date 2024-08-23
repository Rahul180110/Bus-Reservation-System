package BusReservation;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    static int capacity=0;
    int Noofticits;
    String pasangerName;
    int busNo;
    Date date;
    Scanner ob=new Scanner(System.in);
    Booking() throws ParseException {
        System.out.println("enter the pasanger Name");
        pasangerName=ob.nextLine();
        System.out.println("enter the bus no");
        busNo=ob.nextInt();
        ob.nextLine();
        System.out.println("enter the date in this format DD-MM-YYYY");
        String date1=ob.nextLine();
        System.out.println("enter the No of tickts you want");
        Noofticits=ob.nextInt();
        date=new SimpleDateFormat("dd-mm-yyyy").parse(date1);
    }
    public String getPasangerName(){
        return pasangerName;
    }

    public boolean book(ArrayList<Bus> buses,ArrayList<Booking> bookings ){
        for(Bus b:buses){
           if(b.getBusNo()==busNo){
               capacity=b.getcapasity();
           }
        }
       int ticket=capacity;
        int count;
        for(Booking b:bookings){
            if(b.date.equals(date) && b.busNo==busNo)
            {
                count=b.Noofticits;
                ticket = ticket- count;
//                System.out.println("Capacity & count : " +capacity + " "+count);
            }
        }

//        System.out.println(ticket);
        for(Bus b:buses) {
            if(b.getBusNo()==busNo) {
                if(b.getcapasity()>Noofticits)
                {
                    b.setCapacity(b.getcapasity() - Noofticits);
                    return true;
                }
            }
        }
        return false;
    }

}
