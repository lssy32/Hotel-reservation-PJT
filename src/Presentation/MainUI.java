package Presentation;

import Data.HotelController;

import java.io.IOException;
import java.util.Scanner;

public class MainUI {

    private Scanner sc = new Scanner(System.in);
    private HotelController hc = new HotelController();

    public void welcomeUI(){
        System.out.println();
        System.out.println("<<<<<<<<<<<<<<< Welcome to 5racle Hotel >>>>>>>>>>>>>");
    }

    public void enterUI(){

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
                    adminMenuUI();
                    break;
                case "2":
                    memberMenuUI();
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
    public void memberMenuUI(){

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
                    memberSignUpUI();
                    break;
                case "2":
                    reservationUI();
                    break;
                case "3":
                    myReservationUI();
                    break;
                case "4":
                    myReservationCancleUI();
                    break;
                case "5":
                    enterUI();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>해당하는 메뉴가 존재하지 않습니다 다시 입력해주세요.");
            }
        }
    }

    public void memberSignUpUI(){
        while(true) {
            System.out.println();
            System.out.println("---------------<< 5racle Hotel 회원가입>>--------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 이름을 입력하세요 : ");
            String name = sc.nextLine();

            System.out.print(">> 휴대폰번호를 입력하세요 : ");
            String phoneNumber = sc.nextLine();

            System.out.print(">> 충전금을 입력하세요 : ");
            String memberMoney = sc.nextLine();

            System.out.println(">> 회원가입이 완료되었습니다.");
            System.out.println("-----------------------------------------------------");
            beforeMemberMenu();
        }
    }

    public void reservationUI(){
        while(true) {
            System.out.println();
            System.out.println("---------------<< 5racle Hotel 객실예약>>--------------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 휴대폰번호를 입력하세요 : ");
            String phoneNumber = sc.nextLine();

            System.out.print(">> 예약날짜를 입력하세요 : ");
            String name = sc.nextLine();

            System.out.print(">> 예약할 객실의 번호를 입력하세요 : ");
            String memberMoney = sc.nextLine();

            System.out.println(">> 예약이 완료되었습니다.");
            System.out.println("-----------------------------------------------------");
            beforeMemberMenu();
        }
    }


    public void myReservationUI(){
        while(true) {
            System.out.println();
            System.out.println("-----------<< 5racle Hotel 나의 예약내역조회>>----------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 예약번호를 입력하세요 : ");
            String reservationNumber = sc.nextLine();


            System.out.println("-----------------------------------------------------");
            beforeMemberMenu();
        }
    }

    public void myReservationCancleUI(){
        while(true) {
            System.out.println();
            System.out.println("-----------<< 5racle Hotel 나의 예약내역 취소>>----------");
            System.out.println("-----------------------------------------------------");
            System.out.print(">> 예약번호를 입력하세요 : ");
            String reservationNumber = sc.nextLine();


            System.out.println("-----------------------------------------------------");
            beforeMemberMenu();
        }
    }


    //////////////////////////////////////////////////////////////// 관리자 UI영역 /////////////////////////////////////////////////////////////////
    public void adminMenuUI(){

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
                    allReservationListUI();
                    break;
                case "2":
                    allMemberListUI();
                    break;
                case "3":
                    hotelTotalMoneyUI();
                    break;
                case "4":
                    enterUI();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>존재하지 않는 메뉴입니다 다시 입력해주세요.");
            }
        }
    }

    public void allReservationListUI(){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 예약 전체조회>>-----------");
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        beforeAdminMenu();
    }

    public void allMemberListUI(){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 회원 전체조회>>------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        beforeAdminMenu();
    }

    public void hotelTotalMoneyUI(){
        System.out.println();
        System.out.println("-------------<< 5racle Hotel 매출 조회>>---------------");
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        beforeAdminMenu();
    }

    //////////////////////////////////////////////////////////////// 중복 메소드 /////////////////////////////////////////////////////////////////

    public void beforeMemberMenu(){
        while(true){
            System.out.print(">> 메뉴화면으로 돌아가시겠습니까? (y/n) :");
            String answer = sc.nextLine();

            //equalsIgnoreCase -> 대소문자 구분 없이 문자 비교해주는 역할을 해줌
            if("y".equalsIgnoreCase(answer)){
                memberMenuUI();
            }else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시입력해주세요.");
            }
        }
    }
    public void beforeAdminMenu(){
        while(true) {
            System.out.print(">> 이전으로 돌아가시겠습니까? (y/n) :");
            String answer = sc.nextLine();

            //equalsIgnoreCase -> 대소문자 구분 없이 문자 비교해주는 역할을 해줌
            if ("y".equalsIgnoreCase(answer)) {
                adminMenuUI();
            } else if ("n".equalsIgnoreCase(answer)) {
                break;
            } else {
                System.out.println("잘못된 입력입니다 다시입력해주세요.");
            }
        }
    }

}
