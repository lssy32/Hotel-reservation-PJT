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

        hotel.addNumberList(new Member("1", "홍승엽", "01011113113", 100000));
        hotel.addNumberList(new Member("2", "이승윤", "01022223113", 200000));
        hotel.addNumberList(new Member("3", "김민선", "01033333113", 300000));
        hotel.addNumberList(new Member("4", "노예진", "01044443113", 400000));
        hotel.addNumberList(new Member("5", "한세인", "01055553113", 500000));
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
                    main.enterUI();
                    count++;
                } else {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task2, 4000, 100000);



    }
}

