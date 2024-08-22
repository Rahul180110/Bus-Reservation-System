package BusReservation;
import java.util.*;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) {
        boolean desider = true;
        Scanner ob = new Scanner(System.in);
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        buses.add(new Bus(1, true, 45));
        buses.add(new Bus(2, true, 50));
        buses.add(new Bus(3, false, 56));
        boolean start=true;
        while (start) {
            System.out.println("1 ->Admin 2->User");
            int dis = ob.nextInt();
            if (dis == 1) {
                int pass = 17072002;
                System.out.println("enter the password");
                int inpass = ob.nextInt();
                if (pass == inpass) {
                    System.out.println("Enter 1->add bus 2->remove bus");
                    int desetion =ob.nextInt();
                    System.out.println("enter the bus Number");
                    int busno = ob.nextInt();
                    System.out.println("enter ac true or false");
                    boolean ac = ob.nextBoolean();
                    System.out.println("Enter the capasity");
                    int capacity = ob.nextInt();
                    if(desetion==1){
                        buses.add(new Bus(busno, ac, capacity));
                    } else if (desetion==2)
                    {
                        Iterator<Bus> iterator=buses.iterator();
                        while (iterator.hasNext()){
                            Bus b=iterator.next();
                            if(b.getAc()==ac&&b.getcapasity()==capacity&&b.getBusNo()==busno){
                                iterator.remove();
                                break;
                            }
                        }

                    }
                    else {
                        System.out.println("enter 1 or 2");
                    }

                } else {
                    System.out.println("invalid password");
                }
            } else if (dis == 2) {
                while (desider) {
                    try {
                        System.out.println("1->Booking 2->cancel 3->view 4->exit");
                        int Case = ob.nextInt();
                        switch (Case) {
                            case 1:
                                for (Bus b : buses) {
                                    b.diplay();
                                }
                                Booking booking = new Booking();
                                if (booking.book(buses, bookings)) {
                                    bookings.add(booking);
                                    System.out.println("booked sucessfully");
                                } else {
                                    System.out.println("seats not available in given date");
                                }
                                break;
                            case 2:
                                System.out.println("enter the pasanger name");
                                String name = ob.next();
                                System.out.println("enter the busno");
                                int busno = ob.nextInt();
                                ob.nextLine();
                                System.out.println("enter the date in this format dd-mm-yyyy");
                                String date1 = ob.nextLine();
                                Date date = new SimpleDateFormat("dd-mm-yyyy").parse(date1);
                                Cancel b = new Cancel();
                                if (b.cancelTicket(buses, bookings, name, busno, date)) {
                                    System.out.println("cancel success");
                                } else {
                                    System.out.println("cancel unsuccess !");
                                }
                                break;
                            case 3:
                                view v = new view(bookings);
                                break;
                            case 4:
                                desider = false;
                                start=false;
                        }
                        continue;
                    } catch (Exception e) {
                        System.out.println("enter the option 1 to 4");
                    }
                }
            }

        }
    }
}
