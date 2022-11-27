package Application;

public class Room {

    private int roomNumber;
    private int size;   //size값을 String으로 변경해야할 것 같음
    private int price;
    private String reservationDate;

    private boolean reservationCheck = false;

    public Room(){
//        this.roomNumber = roomNumber;
//        this.size = size;
//        this.price = price;
//        this.reservationDate = reservationDate;
    }

    public Room(int roomNumber,int size,int price){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = "2019.01.01";
    }
    public Room(int roomNumber,int size,int price,String reservationDate){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = reservationDate;
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

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationCheck(boolean reservationCheck) {
        this.reservationCheck = reservationCheck;
    }
}