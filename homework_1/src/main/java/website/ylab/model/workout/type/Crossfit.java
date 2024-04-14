package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.skills.*;

import java.util.Objects;
import java.util.Scanner;

public class Crossfit extends Workout implements Lifting, Running, Swimming, Stretching, Gymnastics {

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

    public double getEquipmentWeightKg() {
        return equipmentWeightKg;
    }

    public int getAmountApproaches() {
        return amountApproaches;
    }

    public int getAmountRepetitions() {
        return amountRepetitions;
    }

    public double getDistanceMeter() {
        return distanceMeter;
    }

    public void setEquipmentWeightKg(double equipmentWeightKg) {
        this.equipmentWeightKg = equipmentWeightKg;
    }

    public void setAmountApproaches(int amountApproaches) {
        this.amountApproaches = amountApproaches;
    }

    public void setAmountRepetitions(int amountRepetitions) {
        this.amountRepetitions = amountRepetitions;
    }

    public void setDistanceMeter(double distanceMeter) {
        this.distanceMeter = distanceMeter;
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
                break;
            default:
                System.out.println("Invalid command number");
                return;
        }

        addAdditionalInfo(workout, scanner);
        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public void editWorkout(Person person, Workout workout, Scanner scanner) {
        if (workout instanceof Crossfit crossfit) {
            System.out.println("\nWhich setting do you want to change?" +
                    "\n   -> 1. Duration: " + crossfit.getDurationMinutes() +
                    "\n   -> 2. Equipment Weight: " + crossfit.getEquipmentWeightKg() +
                    "\n   -> 3. Amount approaches: " + crossfit.getAmountApproaches() +
                    "\n   -> 4. Amount repetitions: " + crossfit.getAmountRepetitions() +
                    "\n   -> 5. Distance: " + crossfit.getDistanceMeter() +
                    "\n   -> 6. Additional information): " + crossfit.getAdditionalInfo() +
                    "\n   -> 0. Go back");
        }

        String line = scanner.nextLine();
        System.out.println("Enter value:");
        String value = scanner.nextLine();
        if (workout instanceof Crossfit crossfit) {
            switch (line) {
                case "1":
                    crossfit.setDurationMinutes(Integer.parseInt(value));
                    break;
                case "2":
                    crossfit.setEquipmentWeightKg(Double.parseDouble(value));
                    break;
                case "3":
                    crossfit.setAmountApproaches(Integer.parseInt(value));
                    break;
                case "4":
                    crossfit.setAmountRepetitions(Integer.parseInt(value));
                    break;
                case "5":
                    crossfit.setDistanceMeter(Integer.parseInt(value));
                    break;
                case "6":
                    crossfit.setAdditionalInfo(value);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid command number");
                    break;
            }
        }
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
