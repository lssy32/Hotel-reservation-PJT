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

    public String checkMemberPhoneNumRuleForSignUp(String phoneNumber, Scanner sc) {
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
        public boolean checkMemberPhoneNumForSignUp(String phoneNumber, Hotel hotel) {

            for (int i = 0; i < hotel.getMemberList().size(); i++) {
                if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) {
                    return true;
                }
            }
            return false;
        }

        public void addMember(Member member, Hotel hotel) {
        hotel.getMemberList().add(member);
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

    public void comparePriceWithMoney(Hotel hotel,int roomNum,String phoneNumber,String date,Scanner sc,Reservation reservation){
        for (int i = 0; i < hotel.getMemberList().size(); i++) {
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)) { // 이부분 예외처리 어떻게 하지..? 예약되어진 방번호 눌러도 예약이 되는데..
                if (hotel.getMemberList().get(i).getMemberMoney() > roomPrice.get(roomNum)){
                    System.out.println("예약이 가능합니다.");
                    this.addReservation(roomNum, date, hotel, reservation, phoneNumber);
                }else {
                    System.out.println((hotel.getMemberList().get(i).getMemberMoney()) - (roomPrice.get(roomNum))+"원 만큼의 잔액이 부족합니다.");
                    System.out.println("금액을 충전하시겠습니까?y/n");
                    String choiceRecharge = sc.nextLine();
                    if(choiceRecharge.equals("y")){
                        this.addReservation(roomNum, date, hotel,reservation,phoneNumber);
                        //충전 메서드 실행

                    }else if(choiceRecharge.equals("n")){
                        break; // 메인으로 이동
                    }else {
                        System.out.println("y 또는 n 으로만 입력해주세요.");
                        this.comparePriceWithMoney(hotel,roomNum,phoneNumber,date,sc,reservation);
                    }
                }
            }
        }


    }

    public void addReservation(int roomNum, String date,Hotel hotel,Reservation reservation,String phoneNumber) {
        //예약번호 부여
        int num = 0;
        String reservationNumber = "A"+date.replaceAll("[^\\w+]", "") + (num+= 1);
        reservation.setReservationNumber(reservationNumber);

        //호텔매출 추가
        long addTotalMoney = 0;
        addTotalMoney += roomPrice.get(roomNum);
        hotel.setTotalMoney(addTotalMoney);

        //소지금에서 빼기

        int minusMemberMoeny=0;
        minusMemberMoeny = roomPrice.get(roomNum);
        int idNum = 0; // 멤버 아이디 찾기
        for (int i = 0; i < hotel.getMemberList().size(); i++){
            if (hotel.getMemberList().get(i).getPhoneNumber().equals(phoneNumber)){
                hotel.getMemberList().get(i).setMemberMoney(hotel.getMemberList().get(i).getMemberMoney()-minusMemberMoeny);
                idNum = hotel.getMemberList().get(i).getMemberId();
            }
        }

        System.out.println("예약이 완료되었습니다.");
        System.out.println("addTotalMoney : " + addTotalMoney);
        System.out.println("현재 남은 돈 : " + minusMemberMoeny);


        //예약자 명단에 멤버아이디,방번호,예약날짜,예약번호 추가하기
        hotel.addReservation(new Reservation(idNum,roomNum,date,reservationNumber));




    }

    public void plusTotalMoney() {
    }

    public void minusMemberMoeny() {
    }

    public void rechargeMoney() {
    }

    public boolean getReservationList(String reservationNumber, Hotel hotel) {
        for (int i = 0; i < hotel.getReservation().size(); i++) {
            if (hotel.getReservation().get(i).getReservationNumber().equals(String.valueOf(reservationNumber))){
                return true;
            }
        }
        return false;
    }

    public void showMyReservation(String reservationNumber, Hotel hotel) {
        int reservationSize = hotel.getReservation().size();
        for (int i = 0; i < reservationSize; i++) {
            if (hotel.getReservation().get(i).getReservationNumber().equals(reservationNumber)) {
                System.out.println("예약하신 날짜: " + hotel.getReservation().get(i).getReservationDate());
                System.out.println("예약하신 객실: " + hotel.getReservation().get(i).getRoomNum());
            }
        }
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
