package Application;

import java.awt.*;
import java.util.ArrayList;

public class Hotel {
    private String adminPassword;
    private long totalMoney;
    private ArrayList<Room> roomList;
    private ArrayList<Room> reservation;
    private ArrayList<Member> memberList = new ArrayList<>();

    public void addNumberList(Member member){
        memberList.add(member);
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

    public ArrayList<Room> getReservation() {
        return reservation;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }


}
