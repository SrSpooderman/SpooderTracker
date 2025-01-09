package spd.tracker;

public class Main {
    public static void main(String[] args) {
        Project p = new Project("Spooder Tracker");
        Timer timer = new Timer(p);

        timer.startTimer();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timer.pauseTimer();

        System.out.println(p.getTotalTime());
    }
}