package website.ylab.model.workout.basic.minor;

import website.ylab.model.workout.skills.Lifting;
import website.ylab.model.workout.basic.major.Workout;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class WeightTraining extends Workout implements Lifting {
    private double equipmentWeightKg;
    private int amountApproaches;
    private int amountRepetitions;

    public WeightTraining(String date, int durationMinutes, double equipmentWeightKg, int amountApproaches, int amountRepetitions) {
        super(date, durationMinutes);
        this.equipmentWeightKg = equipmentWeightKg;
        this.amountApproaches = amountApproaches;
        this.amountRepetitions = amountRepetitions;
    }

    public double getEquipmentWeightKg() {
        return equipmentWeightKg;
    }

    @Override
    public void warmUp() {
        System.out.println("It is necessary to do a quality warm-up of the whole body lasting at least 20 minutes.");
    }

    @Override
    public void spendKcal() {
        this.setKcalSpent((int) (equipmentWeightKg * amountApproaches * amountRepetitions * this.getDurationMinutes()));
    }

    public void setEquipmentWeightKg(double equipmentWeightKg) {
        this.equipmentWeightKg = equipmentWeightKg;
    }

    public int getAmountApproaches() {
        return amountApproaches;
    }

    public void setAmountApproaches(int amountApproaches) {
        this.amountApproaches = amountApproaches;
    }

    public int getAmountRepetitions() {
        return amountRepetitions;
    }

    public void setAmountRepetitions(int amountRepetitions) {
        this.amountRepetitions = amountRepetitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WeightTraining that = (WeightTraining) o;
        return Double.compare(equipmentWeightKg, that.equipmentWeightKg) == 0 && amountApproaches == that.amountApproaches && amountRepetitions == that.amountRepetitions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipmentWeightKg, amountApproaches, amountRepetitions);
    }
}
