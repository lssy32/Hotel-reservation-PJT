package Data;

import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;

import java.util.ArrayList;


public class HotelController {

    private Hotel hotel = new Hotel();

    public void checkMemberPhoneNum(Hotel hotel,Member member,String phoneNumber){
        ArrayList<Member> memberList = hotel.getMemberList();
        System.out.println(memberList);
        for (Member member1 : memberList) {
            boolean equals = member1.getPhoneNumber().equals(phoneNumber);
            System.out.println(equals);

        }


    }

    public void addMember(){}
    public void checkAvailableRoomList(){}

    public void comparePriceWithMoney(){}

    public void addReservation(){}

    public void plusTotalMoney(){}

    public void minusMemberMoeny(){}

    public void rechargeMoney(){}

    public void getReservationList(){}

    public void showMyReservation(){}

    public void cancelReservation(){}

    public void checkAdminPassword(){}

    public void getMemberList(){}

    public void getHotelTotalMoney(){}


}
