package Application;

import java.awt.*;
import java.util.ArrayList;

public class Hotel {
    private String adminPassword;
    private long totalMoney;
    private ArrayList<Room> roomList = new ArrayList<>();
    private ArrayList<Reservation> reservation = new ArrayList<>();
    private ArrayList<Member> memberList = new ArrayList<>();

    public void addNumberList(Member member){
        memberList.add(member);
    }
    public void addRoomList(Room room){
        roomList.add(room);
    }


    public String getAdminPassword() {
        return adminPassword;
    }
    public long getTotalMoney() {
        return totalMoney;
    }
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public ArrayList<Reservation> getReservation() {
        return reservation;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        this.reservation = reservation;
    }
}
