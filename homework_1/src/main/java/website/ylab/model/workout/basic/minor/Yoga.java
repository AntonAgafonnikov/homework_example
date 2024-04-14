package website.ylab.model.workout.basic.minor;

import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.skills.Gymnastics;
import website.ylab.model.workout.skills.SpiritualDevelopment;

import java.util.Objects;

public abstract class Yoga extends Workout implements SpiritualDevelopment, Gymnastics {
    private int durationMeditationMin;

    public Yoga(String date, int durationMinutes, int durationMeditationMin) {
        super(date, durationMinutes);
        this.durationMeditationMin = durationMeditationMin;
    }

    @Override
    public void warmUp() {
        System.out.println("Slowly stretch all joints");
    }

    @Override
    public void spendKcal() {
        this.setKcalSpent(this.getDurationMinutes() * 5); // примерно 5 ккал/минуту
    }

    public int getDurationMeditationMin() {
        return durationMeditationMin;
    }

    public void setDurationMeditationMin(int durationMeditationMin) {
        this.durationMeditationMin = durationMeditationMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Yoga yoga = (Yoga) o;
        return durationMeditationMin == yoga.durationMeditationMin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durationMeditationMin);
    }
}
