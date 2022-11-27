package Data;

import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class HotelController {

    private Hotel hotel = new Hotel();

    boolean numcheck = false;


    public String checkMemberPhoneNumRule(Hotel hotel, Member member, String phoneNumber,Scanner sc) {
        ArrayList<Member> memberList = hotel.getMemberList();
        System.out.println(memberList);



        while (true) {
            boolean telCheck = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phoneNumber);
            if (!telCheck) {
                System.out.println("010-xxxx-xxxx 형식에 맞게 바르게 작성해 주세요.");
                phoneNumber = sc.nextLine();
            } else {
                break;
            }
        }
        return phoneNumber;
    }
    public String checkMemberPhoneNum(Hotel hotel, Member member, String phoneNumber,Scanner sc) {
        ArrayList<Member> memberList = hotel.getMemberList();

        while (true){

            for (int i = 0; i < hotel.getMemberList().size(); i++) {
                if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                    numcheck = true;
                    break;
                }
            }

            if (!numcheck) {
                System.out.println("전화번호가 존재하지 않습니다.");
                System.out.println("전화번호를 다시 입력해주세요.");
                phoneNumber = sc.nextLine();
            }else {
                System.out.println("전화번호가 존재합니다.");
                break;
            }
        }
        return phoneNumber;
    }

    public void addMember() {
    }

    public void checkAvailableRoomList() {
    }

    public void comparePriceWithMoney() {
    }

    public void addReservation() {
    }

    public void plusTotalMoney() {
    }

    public void minusMemberMoeny() {
    }

    public void rechargeMoney() {
    }

    public void getReservationList() {
    }

    public void showMyReservation() {
    }

    public void cancelReservation() {
    }

    public void checkAdminPassword() {
    }

    public void getMemberList() {
    }

    public void getHotelTotalMoney() {
    }


}
