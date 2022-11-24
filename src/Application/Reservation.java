package Application;

import java.util.ArrayList;

public class Reservation {
    private int roomNum;
    private String memberName;
    private int memberPhoneNumber;
    private String reservationDate;
    private int reservationNumber;

    public Reservation(){
    }


    public int getRoomNum() {
        return roomNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMemberPhoneNumber() {
        return memberPhoneNumber;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }
}
