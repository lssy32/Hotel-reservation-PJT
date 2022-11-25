package Application;

public class Room {

    private int roomNumber;
    private String size;   //size값을 String으로 변경해야할 것 같음
    private int price;
    private String reservationDate;

    public Room(){
        this.roomNumber = roomNumber;
        this.size = size;
        this.price = price;
        this.reservationDate = reservationDate;
    }
    public String getSize() {
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