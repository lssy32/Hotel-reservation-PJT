package Data;

import Application.Hotel;
import Application.Member;

import java.util.ArrayList;


public class HotelController {

    private Hotel hotel = new Hotel();

    public boolean checkMemberPhoneNum(String phoneNumber){

        for (int i = 0; i < hotel.getMemberList().size(); i++){
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void addMember(Member member){
        hotel.getMemberList().add(member);
    }
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
