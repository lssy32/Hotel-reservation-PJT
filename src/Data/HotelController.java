package Data;

import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;


public class HotelController {

    private Hotel hoTel = new Hotel();
    private Reservation reserVation = new Reservation();
    private Room room = new Room();
    private Member member = new Member();

    public void checkMemberPhoneNum(String phoneNumber){
        hoTel.getMemberList();
//        if(hoTel.getMemberList(phoneNumber));



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
