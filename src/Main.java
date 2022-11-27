import Application.Hotel;
import Application.Member;
import Application.Reservation;
import Application.Room;
import Presentation.MainUI;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    static int count = 1;

    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Reservation reservation = new Reservation();
        Room room = new Room();
        Member member = new Member();

        hotel.addNumberList(new Member("1", "홍승엽", "010-1111-3113", 100000));
        hotel.addNumberList(new Member("2", "이승윤", "010-2222-3113", 200000));
        hotel.addNumberList(new Member("3", "김민선", "010-3333-3113", 300000));
        hotel.addNumberList(new Member("4", "노예진", "010-4444-3113", 400000));
        hotel.addNumberList(new Member("5", "한세인", "010-5555-3113", 500000));

            //룸 리스트 추가 예시
        hotel.addRoomList(new Room(201,1,10000,"2022.12.12"));
        hotel.addRoomList(new Room(202,2,20000,"2022.12.12"));
        hotel.addRoomList(new Room(203,3,30000,"2022.12.12"));
        hotel.addRoomList(new Room(204,4,40000,"2022.12.12"));
        hotel.addRoomList(new Room(201,1,10000,"2022.12.13"));
        hotel.addRoomList(new Room(201,1,10000,"2022.12.14"));
        hotel.addRoomList(new Room(203,2,10000,"2022.12.14"));

        System.out.println(hotel.getRoomList().get(1).getReservationDate());

        System.out.println(hotel.getMemberList().get(0));
        System.out.println(hotel.getMemberList().get(0).getMemberId());
        MainUI main = new MainUI();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (count < 2) {
                    main.welcomeUI();
                    count++;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task, 1000, 4000);

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                if (count < 3) {
                    main.enterUI(hotel,member,reservation,room);
                    count++;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task2, 4000, 100000);



    }
}

