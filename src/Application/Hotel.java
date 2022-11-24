package Application;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> roomList;
    private long totalMoney;
    private ArrayList<Room> reservation;
    private ArrayList<Member> memberList;
    private String adminPassword;


    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public ArrayList<Room> getReservation() {
        return reservation;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}
