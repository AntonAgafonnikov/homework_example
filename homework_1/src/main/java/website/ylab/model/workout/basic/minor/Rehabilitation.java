package website.ylab.model.workout.basic.minor;

import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.skills.Gymnastics;
import website.ylab.model.workout.skills.Stretching;

import java.util.Objects;

public abstract class Rehabilitation extends Workout implements Gymnastics, Stretching {
    private int amountRecoveryDays;

    public Rehabilitation(String date, int durationMinutes, int amountRecoveryDays) {
        super(date, durationMinutes);
        this.amountRecoveryDays = amountRecoveryDays;
    }

    @Override
    public void warmUp() {
        System.out.println("Use a massage motion to knead the injured area.");
    }

    @Override
    public void spendKcal() {
        this.setKcalSpent(this.getDurationMinutes() * 3); // примерно 3 ккал/минуту
    }

    public int getAmountRecoveryDays() {
        return amountRecoveryDays;
    }

    public void setAmountRecoveryDays(int amountRecoveryDays) {
        this.amountRecoveryDays = amountRecoveryDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rehabilitation that = (Rehabilitation) o;
        return amountRecoveryDays == that.amountRecoveryDays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), amountRecoveryDays);
    }
}
