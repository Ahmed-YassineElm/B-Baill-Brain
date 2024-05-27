package Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statsId;

    private int DistanceCrossed;
    private int TimeElapsed;
    private int Bounces;

    public void setDistanceCrossed(int distanceCrossed) {
        DistanceCrossed = distanceCrossed;
    }

    public void setTimeElapsed(int timeElapsed) {
        TimeElapsed = timeElapsed;
    }

    public void setBounces(int bounces) {
        Bounces = bounces;
    }
}
