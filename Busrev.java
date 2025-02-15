import java.util.*;

class Busrev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userOption = 1;
        ArrayList<Bus> buses = new ArrayList<>();
		ArrayList<Book> booking = new ArrayList<>();
        buses.add(new Bus(1, true, 1));
        buses.add(new Bus(2, true, 10));
        buses.add(new Bus(3, false, 10));
        while (userOption == 1) {
            System.out.print("Enter 1 to continue and enter 2 to exit: ");
            userOption = sc.nextInt();
			if(userOption==1){
				Book bo=new Book();
				if(bo.isAvaliable(buses,booking)){
					booking.add(bo);
					System.out.print("Booking conform\n");
				}
				else{
					System.out.print("The bus is full, choose another date\n");
				}
			}	
        }
        for (Bus b : buses) {
            b.display();
        }
        sc.close();
    }
}
class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    Bus(int no, boolean ac, int capacity) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int no) {
        this.busNo = no;
    }

    public boolean isAc() {  // Renamed getter for clarity
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }
    public void display() {
        System.out.printf("Bus no: %d | AC: %b | Capacity: %d%n", busNo, ac, capacity);
    }
}
class Book{
	String name;
	int busno;
	String date;
	Book(){
		Scanner sc=new Scanner(System.in);
		System.out.print("enter your name:");
		this.name=sc.next();
		System.out.print("enter busno:");
		this.busno=sc.nextInt();
		System.out.print("enter date dd-mm-yyyy:");
		this.date=sc.next();
	}  
	public boolean isAvaliable(ArrayList<Bus> buses,ArrayList<Book> booking ){
		int totalcapacity=0;
		for (Bus b:buses){
			if(b.getBusNo()==busno){
				totalcapacity=b.getCapacity();
			}
		}
		int booked=0;
		for(Book a:booking){
			if(a.busno==busno && a.date.equals(date)){
				booked++;
			}
		}
		return booked<totalcapacity ? true : false;
	
}
}