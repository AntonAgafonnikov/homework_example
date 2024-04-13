package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.skills.*;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Scanner;

public class Crossfit extends Workout implements Lifting, Running, Swimming, Stretching, Gymnastics{

    private double equipmentWeightKg;
    private int amountApproaches;
    private int amountRepetitions;
    private double distanceMeter;

    public Crossfit(String dateString, int durationMinutes, double equipmentWeightKg, int amountApproaches, int amountRepetitions) {
        super(dateString, durationMinutes);
        this.equipmentWeightKg = equipmentWeightKg;
        this.amountApproaches = amountApproaches;
        this.amountRepetitions = amountRepetitions;
        this.spendKcal();
    }

    public Crossfit(String dateString, int durationMinutes, double distanceMeter) {
        super(dateString, durationMinutes);
        this.distanceMeter = distanceMeter;
        this.spendKcal();
    }

    public Crossfit(String dateString, int durationMinutes, double equipmentWeightKg, int amountApproaches, int amountRepetitions, double distanceMeter) {
        this(dateString, durationMinutes, equipmentWeightKg, amountApproaches, amountRepetitions);
        this.distanceMeter = distanceMeter;
        this.spendKcal();
    }


    @Override
    public void run() {
        //TODO
    }

    @Override
    public void pull() {
        //TODO
    }

    @Override
    public void push() {
        //TODO
    }

    @Override
    public void stretch() {
        //TODO
    }

    @Override
    public void swim() {
        //TODO
    }

    @Override
    public void warmUp() {
        //TODO
    }

    @Override
    public void spendKcal() {
        //TODO
    }

    @Override
    public void addWorkout(Person person, String date, Scanner scanner) {
        System.out.println("Enter workout duration (min):");
        int durationMinutesInput = Integer.parseInt(scanner.nextLine());

        Crossfit workout = null;
        int distanceMeterInput = 0;
        double equipmentWeightKgInput = 0;
        int amountApproaches = 0;
        int amountRepetitions = 0;

        System.out.println("""
                Select the type of CrossFit complex:
                    -> 1. Cardio
                    -> 2. Power
                    -> 3. Mixed""");
        switch (scanner.nextLine()) {
            case "1":
                System.out.println("Enter workout distanceMeter (meter):");
                distanceMeterInput = Integer.parseInt(scanner.nextLine());
                workout = new Crossfit(date, durationMinutesInput, distanceMeterInput);
                break;
            case "2":
                System.out.println("Enter equipment weight (kg):");
                equipmentWeightKgInput = Double.parseDouble(scanner.nextLine());

                System.out.println("Enter amount approaches weight:");
                amountApproaches = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter amount repetitions weight:");
                amountRepetitions = Integer.parseInt(scanner.nextLine());
                workout = new Crossfit(date, durationMinutesInput, equipmentWeightKgInput, amountApproaches, amountRepetitions);
                break;
            case "3":
                workout = new Crossfit(date, durationMinutesInput, equipmentWeightKgInput, amountApproaches, amountRepetitions, distanceMeterInput);
            default:
                System.out.println("Invalid command number");
                break;
        }

        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public String toString() {
        return "Crossfit";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crossfit crossfit = (Crossfit) o;
        return Double.compare(equipmentWeightKg, crossfit.equipmentWeightKg) == 0
                && amountApproaches == crossfit.amountApproaches
                && amountRepetitions == crossfit.amountRepetitions
                && Double.compare(distanceMeter, crossfit.distanceMeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentWeightKg, amountApproaches, amountRepetitions, distanceMeter);
    }
}
