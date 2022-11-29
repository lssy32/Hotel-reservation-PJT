package Application;

public class Room {

    private int roomNumber;
    private int size;
    private int price;
    private String reservationDate;

    private boolean isReservationCheck;

    public Room(){
    }

    public Room(int roomNumber,int size,int price){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = "2019.01.01";
        this.isReservationCheck = false;
    }
    public Room(int roomNumber,int size,int price,String reservationDate){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = reservationDate;
    }
    public Room(int roomNumber,int size,int price,String reservationDate,boolean isReservationCheck){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = reservationDate;
        this.isReservationCheck = isReservationCheck;
    }
    public int getSize() {
        return size;
    }

    public int getPrice() { return price; }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }
}