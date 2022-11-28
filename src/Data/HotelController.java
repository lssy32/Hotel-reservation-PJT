package Data;

import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;
import Presentation.MainUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;


public class HotelController {

    boolean numcheck = false;

    HashMap<Integer, Boolean> datemap = new HashMap<>();
    HashMap<Integer, Integer> roomPrice = new HashMap<>();
    HashMap<Integer, Integer> roomSize = new HashMap<>();


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
                this.checkMemberPhoneNum(hotel, phoneNumber, sc);
            } else {
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
                this.checkReserveDateRule(hotel,date,sc);
            } else {
                //날짜가 2022.12.2 이런식으로 잘못 입력되었을때의 예외처리가 필요하다..
                System.out.println("날짜를 바르게 입력하였습니다.");
                this.checkDateRoomList(hotel,date,sc);
                break;
            }
        }
        return date;
    }

    public void checkDateRoomList(Hotel hotel, String date, Scanner sc) {
        //해쉬맵에 가격과 사이즈 넣어주기.
        for (int i = 1; i < 5; i++) {
            roomPrice.put((200 + i), (i * 10000));
            roomSize.put((200 + i), i);
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
                this.checkReserveDateRule(hotel, date, sc);
                break;
            } else if (datemap.get(integer1)) {
                System.out.println(integer1 + "호 예약이 불가능합니다.");
            } else if (!datemap.get(integer1)) {
                System.out.println(integer1 + "호 예약이 가능합니다. 가격 : " + roomPrice.get(integer1) + "원 , 방 사이즈 : " + roomSize.get(integer1));
            }
        }

    }

    public void comparePriceWithMoney(Hotel hotel, int roomNum, String phoneNumber, String date, Scanner sc, Reservation reservation) {

        for (int i = 0; i < hotel.getMemberList().size(); i++) {
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) { //12.12.2 이런식으로 날짜 입력했을때 널포인트입셉션 에러처리 해야됨.
                if (hotel.getMemberList().get(i).getMemberMoney() > roomPrice.get(roomNum) && datemap.get(roomNum)==false){
                    System.out.println("예약이 가능합니다.");
                    this.addReservation(roomNum, date, hotel, reservation, phoneNumber);
                }else if(hotel.getMemberList().get(i).getMemberMoney() > roomPrice.get(roomNum) && datemap.get(roomNum) == true){
                    System.out.println("이미 예약된 방 입니다.");
                    break;
                } else {
                    System.out.println((hotel.getMemberList().get(i).getMemberMoney()) - (roomPrice.get(roomNum)) + "원 만큼의 잔액이 부족합니다.");
                    System.out.println("금액을 충전하시겠습니까?y/n");
                    String choiceRecharge = sc.nextLine();
                    if (choiceRecharge.equals("y")) {
                        rechargeMoney(hotel, sc, phoneNumber);

                    } else if (choiceRecharge.equals("n")) {
                        break; // 메인으로 이동
                    } else {
                        System.out.println("y 또는 n 으로만 입력해주세요.");
                        this.comparePriceWithMoney(hotel, roomNum, phoneNumber, date, sc, reservation);
                    }
                }
            }




        }


    }

    public void addReservation(int roomNum, String date, Hotel hotel, Reservation reservation, String phoneNumber) {
        //예약번호 부여
        int num = 0;
        String reservationNumber = "A" + date.replaceAll("[^\\w+]", "") + (num += 1);
        reservation.setReservationNumber(reservationNumber);

        //호텔매출 추가
        long addTotalMoney = 0;
        addTotalMoney += roomPrice.get(roomNum);
        hotel.setTotalMoney(addTotalMoney);

        //소지금에서 빼기

        int minusMemberMoeny = 0;
        minusMemberMoeny = roomPrice.get(roomNum);
        int idNum = 0; // 멤버 아이디 찾기
        for (int i = 0; i < hotel.getMemberList().size(); i++) {
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                hotel.getMemberList().get(i).setMemberMoney(hotel.getMemberList().get(i).getMemberMoney() - minusMemberMoeny);
                idNum = hotel.getMemberList().get(i).getMemberId();
            }
        }

        System.out.println("예약이 완료되었습니다.");
        System.out.println("addTotalMoney : " + addTotalMoney);
        System.out.println("현재 남은 돈 : " + minusMemberMoeny);


        //예약자 명단에 멤버아이디,방번호,예약날짜,예약번호 추가하기
        hotel.addreservation(new Reservation(idNum, roomNum, date, reservationNumber));


    }

    public void plusTotalMoney() {
    }

    public void minusMemberMoeny() {
    }

    public void rechargeMoney(Hotel hotel, Scanner sc, String phoneNumber) {
        System.out.println("충전할 금액을 입력해주세요.");
        int moneyRecharge = Integer.parseInt(sc.nextLine());


        //멤버 찾고 충전금 더하기
        for (int i = 0; i < hotel.getMemberList().size(); i++) {
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                hotel.getMemberList().get(i).setMemberMoney(hotel.getMemberList().get(i).getMemberMoney() + moneyRecharge);
                System.out.println("내가 가진 총 금액 : " + hotel.getMemberList().get(i).getMemberMoney());
            }
        }


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
