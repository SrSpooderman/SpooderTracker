package spd.tracker;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class Project {
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration totalTime;

    public Project(String name) {
        this.name = name;
        this.totalTime = Duration.ZERO;
    }

    public void addTotalTime(Duration duration) {
        this.totalTime = totalTime.plus(duration);
    }

    public String getTotalTime() {
        long hours = totalTime.toHours();
        long minutes = totalTime.toMinutes();
        long seconds = totalTime.toSeconds();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
