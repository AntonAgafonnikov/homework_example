package website.ylab.model.workout.basic.minor;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public abstract class Cardio extends Workout {
    private double distanceMeter;

    public Cardio(String dateString,  int durationMinutes, double distanceMeter) {
        super(dateString, durationMinutes);
        this.distanceMeter = distanceMeter;
    }

    public double getDistanceMeter() {
        return distanceMeter;
    }

    public void setDistanceMeter(double distanceMeter) {
        this.distanceMeter = distanceMeter;
    }

    @Override
    public void warmUp() {
        System.out.println("Do a short general warm-up. Pay special attention to the ankle");
    }

    @Override
    public void spendKcal() {
        this.setKcalSpent((int) (this.getDurationMinutes() * this.distanceMeter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cardio cardio = (Cardio) o;
        return Double.compare(distanceMeter, cardio.distanceMeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), distanceMeter);
    }
}
