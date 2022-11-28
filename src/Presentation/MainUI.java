package Presentation;

import Application.*;
import Data.HotelController;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainUI {

    private Scanner sc = new Scanner(System.in);
    private HotelController hc = new HotelController();

    public void welcomeUI(){
        System.out.println();
        System.out.println("<<<<<<<<<<<<<<< Welcome to 5racle Hotel >>>>>>>>>>>>>");
    }

    public void enterUI(Hotel hotel, Member member, Reservation reservation,Room room){

        while(true) {
            System.out.println();
            System.out.println("------------------<< 5racle Hotel >>-----------------");
            System.out.println("-----------------------------------------------------");
            System.out.println("----------------1. 관리자 모드 접속---------------------");
            System.out.println("----------------2. 회원 호텔 예약 접속------------------");
            System.out.println("----------------3. 프로그램 종료-----------------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">>원하는 메뉴를 입력하세요 : ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    System.out.println("관리자 비밀번호를 입력해주세요.");
                    String password = sc.nextLine();
                    if(hc.checkAdminPassword(password)) {
                        adminMenuUI(hotel, member, reservation, room);
                    }
                    else {
                    System.out.println("관리자 비밀번호가 일치하지 않습니다.");
                    }
                    break;
                case "2":
                    memberMenuUI(hotel, member, reservation, room);
                    break;
                case "3" :
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>해당하는 메뉴가 존재하지 않습니다 다시 입력해주세요.");
            }
        }
    }

    /////////////////////////////////////////////////////////////// 회원 UI영역 /////////////////////////////////////////////////////////////////
    public void memberMenuUI(Hotel hotel, Member member, Reservation reservation,Room room){

        while(true) {
            System.out.println();
            System.out.println("-------------<< 5racle Hotel MemberMenu>>-------------");
            System.out.println("-----------------------------------------------------");
            System.out.println("-------------------1. 회원 가입------------------------");
            System.out.println("-------------------2. 객실 예약------------------------");
            System.out.println("-------------------3. My 예약내역 조회------------------");
            System.out.println("-------------------4. My 예약 취소---------------------");
            System.out.println("-------------------5. 메인화면 돌아가기------------------");
            System.out.println("-------------------6. 프로그램 종료--------------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">>원하는 메뉴를 입력하세요 : ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    memberSignUpUI(hotel, member, reservation, room);
                    break;
                case "2":
                    reservationUI(hotel, member, reservation, room);
                    break;
                case "3":
                    myReservationUI(hotel, member, reservation, room);
                    break;
                case "4":
                    myReservationCancleUI(hotel, member, reservation, room);
                    break;
                case "5":
                    enterUI(hotel, member, reservation, room);
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>해당하는 메뉴가 존재하지 않습니다 다시 입력해주세요.");
            }
        }
    }

    public void memberSignUpUI(Hotel hotel, Member member, Reservation reservation,Room room){
        int memberId = 1;
        while (true) {
            System.out.println();
            System.out.println("---------------<< 5racle Hotel 회원가입>>--------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 이름을 입력하세요 : ");
            String name = sc.nextLine();

            System.out.print(">> 휴대폰번호를 입력하세요 : ");
            String phoneNumber = sc.nextLine();

            if (hc.checkMemberPhoneNumForSignUp(hc.checkMemberPhoneNumRuleForSignUp(phoneNumber, sc), hotel)) {
                System.out.println("이미 가입되어 있는 회원입니다.");
                System.out.println();
                System.out.println("-----------------------------------------------------");
                beforeMemberMenu(hotel, member, reservation, room);
                break;
            } else {
                System.out.print(">> 충전금을 입력하세요 : ");
                int memberMoney = sc.nextInt();
//                hc.addMember(new Member(memberId, name, phoneNumber, memberMoney), hotel);
                hotel.addMemberList(new Member(memberId, name, phoneNumber, memberMoney));
                System.out.println(">> 회원가입이 완료되었습니다.");
                for (int i = 0; i < hotel.getMemberList().size(); i++){
                System.out.println(hotel.getMemberList().get(i).getMemberId());}
                System.out.println(" ");
                System.out.println("-----------------------------------------------------");
                System.out.println(" ");
                beforeMemberMenu(hotel, member, reservation, room);
            }
            memberId += 1;
        }
    }

    //객실 예약하기
    public void reservationUI(Hotel hotel, Member member, Reservation reservation,Room room){
        while(true) {
            System.out.println();
            System.out.println("---------------<< 5racle Hotel 객실예약>>--------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 휴대폰번호를 입력하세요 : ");
            String phoneNumber = sc.nextLine();
            hc.checkMemberPhoneNumRule(hotel,phoneNumber,sc);
            hc.checkMemberPhoneNum(hotel,phoneNumber,sc);

            System.out.print(">> 예약날짜를 입력하세요 : ");
            String date = sc.nextLine();
            date = hc.checkReserveDateRule(hotel,date,sc);
//            hc.checkDateRoomList(hotel,chekdate,sc);

            System.out.print(">> 예약할 객실의 번호를 입력하세요 : ");
            int roomNum = Integer.parseInt(sc.nextLine());
            hc.comparePriceWithMoney(hotel,roomNum,phoneNumber,date,sc,reservation);


            System.out.println("-----------------------------------------------------");
            beforeMemberMenu(hotel, member, reservation, room);
        }
    }


    public void myReservationUI(Hotel hotel, Member member, Reservation reservation,Room room){
        while(true) {
            System.out.println();
            System.out.println("-----------<< 5racle Hotel 나의 예약내역조회>>----------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 예약번호를 입력하세요 : ");
            String reservationNumber = sc.nextLine();
            if (hc.getReservationList(reservationNumber, hotel)){
                hc.showMyReservation(reservationNumber, hotel);
                beforeMemberMenu(hotel, member, reservation, room);
                break;
            }else {
                System.out.println("예약 정보가 존재하지 않습니다.");
                beforeMemberMenu(hotel, member, reservation, room);
                break;
            }
        }
    }


    public void myReservationCancleUI(Hotel hotel, Member member, Reservation reservation,Room room){
        while(true) {
            System.out.println();
            System.out.println("-----------<< 5racle Hotel 나의 예약내역 취소>>----------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 예약번호를 입력하세요 : ");
            String reservationNumber = sc.nextLine();


            System.out.println("-----------------------------------------------------");
            beforeMemberMenu(hotel, member, reservation, room);
        }
    }


    //////////////////////////////////////////////////////////////// 관리자 UI영역 /////////////////////////////////////////////////////////////////
    public void adminMenuUI(Hotel hotel, Member member, Reservation reservation,Room room){

        while(true) {
            System.out.println();
            System.out.println("-------------<< 5racle Hotel AdminMenu>>-------------");
            System.out.println("-----------------------------------------------------");
            System.out.println("------------------1. 전체 예약 내역 조회----------------");
            System.out.println("------------------2. 회원목록 조회---------------------");
            System.out.println("------------------3. 호텔 매출 조회--------------------");
            System.out.println("------------------4. 메인화면 돌아가기------------------");
            System.out.println("------------------5. 프로그램 종료---------------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">>원하는 메뉴를 입력하세요 : ");
            String menu = sc.nextLine();

            switch (menu) {
                case "1":
                    allReservationListUI(hotel, member, reservation, room);
                    break;
                case "2":
                    allMemberListUI(hotel, member, reservation, room);
                    break;
                case "3":
                    hotelTotalMoneyUI(hotel, member, reservation, room);
                    break;
                case "4":
                    enterUI(hotel, member, reservation, room);
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>존재하지 않는 메뉴입니다 다시 입력해주세요.");
            }
        }
    }

    public void allReservationListUI(Hotel hotel, Member member, Reservation reservation,Room room){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 예약 전체조회>>-----------");
        System.out.println("-----------------------------------------------------");

        hc.showReservationList(hotel);  // 전체 예약내역 보여주기

        System.out.println("-----------------------------------------------------");
        beforeAdminMenu(hotel, member, reservation, room);
    }

    public void allMemberListUI(Hotel hotel, Member member, Reservation reservation,Room room){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 회원 전체조회>>------------");
        System.out.println("-----------------------------------------------------");

        hc.showMemberList(hotel);   // 현재 등록 멤버 보여주기

        System.out.println("-----------------------------------------------------");
        beforeAdminMenu(hotel, member, reservation, room);
    }

    public void hotelTotalMoneyUI(Hotel hotel, Member member, Reservation reservation,Room room){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 매출 조회>>---------------");
        System.out.println("-----------------------------------------------------");

        hc.showHotelTotalMoney(hotel);   // 현재 매출액 보여주기

        System.out.println("-----------------------------------------------------");
        beforeAdminMenu(hotel, member, reservation, room);
    }

    //////////////////////////////////////////////////////////////// 중복 메소드 /////////////////////////////////////////////////////////////////

    public void beforeMemberMenu(Hotel hotel, Member member, Reservation reservation,Room room){
        while(true){
            System.out.print(">> 메뉴화면으로 돌아가시겠습니까? (y/n) :");
            String answer = sc.nextLine();

            //equalsIgnoreCase -> 대소문자 구분 없이 문자 비교해주는 역할을 해줌
            if("y".equalsIgnoreCase(answer)){
                memberMenuUI(hotel, member, reservation, room);
            }else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시입력해주세요.");
            }
        }
    }
    public void beforeAdminMenu(Hotel hotel, Member member, Reservation reservation,Room room){
        while(true) {
            System.out.print(">> 이전으로 돌아가시겠습니까? (y/n) :");
            String answer = sc.nextLine();

            //equalsIgnoreCase -> 대소문자 구분 없이 문자 비교해주는 역할을 해줌
            if ("y".equalsIgnoreCase(answer)) {
                adminMenuUI(hotel, member, reservation, room);
            } else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시입력해주세요.");
            }
        }
    }

}
