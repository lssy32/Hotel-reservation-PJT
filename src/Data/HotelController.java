package Data;

import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;
import Presentation.MainUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class HotelController {

    private Hotel hotel = new Hotel();

    boolean numcheck = false;

    HashMap<Integer, Boolean> datemap = new HashMap<>();
    HashMap<Integer,Integer> roomPrice = new HashMap<>();
    HashMap<Integer,Integer> roomSize = new HashMap<>();


    public String checkMemberPhoneNumRule(Hotel hotel, String phoneNumber, Scanner sc) {
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

    public String checkMemberPhoneNum(Hotel hotel, String phoneNumber, Scanner sc) {

        while (true) {

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
                this.checkMemberPhoneNum(hotel,phoneNumber,sc);
            } else {
                System.out.println("전화번호가 존재합니다.");
                break;
            }
        }
        return phoneNumber;
    }

    public void addMember() {
    }

    public String checkReserveDateRule(Hotel hotel, String date, Scanner sc) {
        ArrayList<Member> memberList = hotel.getMemberList();
        System.out.println(memberList);

        while (true) {
            boolean dateCheck = Pattern.matches("(19|20)\\d{2}(\\.)\\s?((11|12)|(0?(\\d)))((\\.)\\s?(30|31|((0|1|2)?\\d)))?", date);
            if (!dateCheck) {
                System.out.println("YYYY.MM.DD 형식에 맞게 바르게 작성해 주세요.");
                date = sc.nextLine();
            } else {
                System.out.println("날짜를 바르게 입력하였습니다.");
                break;
            }
        }
        return date;
    }

    public void checkDateRoomList(Hotel hotel, String date, Scanner sc) {
        //해쉬맵에 가격과 사이즈 넣어주기.
        for (int i = 1; i < 5; i++) {
            roomPrice.put((200+i),(i*10000));
            roomSize.put((200+i),i);
        }


        //해쉬맵에 true,false값 넣어주기
        for (int i = 0; i < hotel.getRoomList().size(); i++) {
            datemap.put(hotel.getRoomList().get(i).getRoomNumber(), false);
        }

        // 같은 날짜 출력 안되게 하기.
        for (int i = 0; i < hotel.getRoomList().size(); i++) {

            if (hotel.getRoomList().get(i).getReservationDate().equals(date)) {
                datemap.put(hotel.getRoomList().get(i).getRoomNumber(), true);
            }

        }
        for (Integer integer1 : datemap.keySet()) {

            if (datemap.get(201) && datemap.get(202) && datemap.get(203) && datemap.get(204) == true) {
                System.out.println("예약이 가득 찼습니다. 예약날짜를 다시 입력해주세요.");
                date = sc.nextLine();
                this.checkDateRoomList(hotel,date,sc);
                break;
            }else if (datemap.get(integer1)) {
                System.out.println(integer1 + "호 예약이 불가능합니다." );
            } else if (!datemap.get(integer1)) {
                System.out.println(integer1 + "호 예약이 가능합니다. 가격 : "+ roomPrice.get(integer1) + "원 , 방 사이즈 : "+ roomSize.get(integer1));
            }
        }

    }

    public void comparePriceWithMoney(Hotel hotel,Member member,int memberMoney){


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
