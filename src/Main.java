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

