package Application;

import java.util.ArrayList;

public class Hotel {
    private String adminPassword;
    private long totalMoney;
    private ArrayList<Room> roomList;
    private ArrayList<Room> reservation;
    private ArrayList<Member> memberList;

    public Hotel() {
        memberList.add(new Member("1", "홍승엽", "01011113113", 100000));
        memberList.add(new Member("2", "이승윤", "01022223113", 200000));
        memberList.add(new Member("3", "김민선", "01033333113", 300000));
        memberList.add(new Member("4", "노예진", "01044443113", 400000));
        memberList.add(new Member("5", "한세인", "01055553113", 500000));
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
