import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;
import Presentation.MainUI;


public class Main {

    static int count = 1;

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Reservation reservation = new Reservation();
        Room room = new Room();
        Member member = new Member();


        hotel.addMemberList(new Member(1, "홍승엽", "010-1111-3113", 10000));
        hotel.addMemberList(new Member(2, "이승윤", "010-2222-3113", 20000));
        hotel.addMemberList(new Member(3, "김민선", "010-3333-3113", 30000));
        hotel.addMemberList(new Member(4, "노예진", "010-4444-3113", 40000));
        hotel.addMemberList(new Member(5, "한세인", "010-5555-3113", 50000));


        //룸 리스트 추가 예시
        hotel.addRoomList(new Room(201,1,10000,"2022.12.12"));
        hotel.addRoomList(new Room(202,2,20000,"2022.12.12"));
        hotel.addRoomList(new Room(203,3,30000,"2022.12.12"));
        hotel.addRoomList(new Room(204,4,40000,"2022.12.12"));
        hotel.addRoomList(new Room(201,1,10000,"2022.12.13"));
        hotel.addRoomList(new Room(201,1,10000,"2022.12.14"));
        hotel.addRoomList(new Room(203,2,20000,"2022.12.14"));

        //예약 리스트 추가 예시
        hotel.addReservation(new Reservation("1", 201, "2022.12.31", "1"));
        hotel.addReservation(new Reservation("2", 202, "2022.12.31", "2"));
        hotel.addReservation(new Reservation("3", 203, "2022.12.31", "3"));
        hotel.addReservation(new Reservation("4", 201, "2023.01.01", "4"));
        hotel.addReservation(new Reservation("5", 202, "2022.01.01", "5"));


        MainUI main = new MainUI();
        main.enterUI(hotel,member,reservation,room);

    }
}

