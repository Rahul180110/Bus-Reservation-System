package BusReservation;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    Bus(int busNo,boolean ac,int capacity)
    {
        this.busNo=busNo;
        this.ac=ac;
        this.capacity=capacity;
    }
    public int getcapasity(){
        return capacity;
    }
    public int getBusNo(){
        return busNo;
    }
    public void setCapacity(int cap){
        this.capacity=cap;
    }
    public boolean getAc()
    {
        return ac;
    }
    public void diplay(){
        if(ac){
            System.out.println("BusNo is "+busNo+" AC BUs Capasity is "+capacity);
        }
        else {
            System.out.println("BusNo is "+busNo+" NON AC BUs Capasity is "+capacity);
        }

    }
}
