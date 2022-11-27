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

    public void checkAvailableRoomList(Hotel hotel, String date, Scanner sc) {
        boolean resurvationDateCheck = false;
        boolean unreserved = false;

        // 이용가능 객실 보여주는 기능.
        for (int i = 0; i < hotel.getRoomList().size(); i++) {
            resurvationDateCheck = hotel.getRoomList().get(i).getReservationDate().equals(date);//사용자가 입력한 값과 같으면 true (예약안됨..)
            unreserved = hotel.getRoomList().get(i).getReservationDate().equals("2019.01.01");//예약자가 아예 없으면 true

            //사용자가 선택한 날짜에 비어있는 방이 있는지 확인
            if (resurvationDateCheck || unreserved) {
                if (!resurvationDateCheck) {
                    System.out.println(hotel.getRoomList().get(i).getRoomNumber() + "호 예약이 가능합니다.");

                } else if (unreserved) {
                    System.out.println(hotel.getRoomList().get(i).getRoomNumber() + "호 예약이 가능합니다.");
                } else {
                    System.out.println(hotel.getRoomList().get(i).getRoomNumber() + "호 예약이 불가능합니다.");
                }
            } else if (!resurvationDateCheck) {
                System.out.println(hotel.getRoomList().get(i).getRoomNumber() + "호 예약이 가능합니다.");
            }
        }

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
