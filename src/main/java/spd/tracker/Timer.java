package spd.tracker;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timer implements Runnable {
    private Project project;
    private boolean isRunning;
    private LocalDateTime startTime;
    private Thread thread;

    public Timer(Project project) {
        this.project = project;
        isRunning = false;
    }

    public void startTimer() {
        if (!isRunning){
            isRunning = true;
            this.startTime = LocalDateTime.now();
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    public void pauseTimer() {
        if (isRunning){
            isRunning = false;
            Duration duration = Duration.between(startTime, LocalDateTime.now());
            project.addTotalTime(duration);
        }
    }

    public void stopTimer(){
        pauseTimer();
        System.out.println("Timer stopped");
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted");
            }
        }
    }
}
