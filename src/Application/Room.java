package Application;

public class Room {

    private int roomNumber;
    private int size;   //size값을 String으로 변경해야할 것 같음
    private int price;
    private String reservationDate;

    private boolean isReservationCheck; // true 면 예약이 되어있는 상태, false면 예약이 되어있지않은 상태

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

    public boolean isReservationCheck() {
        return isReservationCheck;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationCheck(boolean reservationCheck) {
        this.isReservationCheck = reservationCheck;
    }
}