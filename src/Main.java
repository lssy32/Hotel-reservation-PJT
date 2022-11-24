import Presentation.MainUI;
import java.util.Timer;
import java.util.TimerTask;


public class Main {

    static int count = 1;

    public static void main(String[] args) {

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

