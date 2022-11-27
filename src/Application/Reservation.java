package Application;

import java.util.ArrayList;

public class Reservation {
    private String memberId;
    private int roomNum;
    private String reservationDate;
    private String reservationNumber;


    public Reservation(){

    }

    public Reservation(String memberId,int roomNum){
        this.memberId = memberId;
        this.roomNum = roomNum;
    }



    //게터
    public String getMemberId() {return memberId;}
    public int getRoomNum() {
        return roomNum;
    }
    public String getReservationDate() {
        return reservationDate;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    //세터
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }


}
