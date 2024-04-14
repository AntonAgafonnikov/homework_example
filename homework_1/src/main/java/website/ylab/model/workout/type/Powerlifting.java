package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.WeightTraining;

import java.util.Scanner;

public class Powerlifting extends WeightTraining {

    public Powerlifting(String dateString, int durationMinutes, double equipmentWeightKg, int amountApproaches, int amountRepetitions) {
        super(dateString, durationMinutes, equipmentWeightKg, amountApproaches, amountRepetitions);
        this.spendKcal();
    }

    @Override
    public void pull() {
        System.out.println("Pull!");//TODO
    }

    @Override
    public void push() {
        System.out.println("Push!");//TODO
    }

    @Override
    public void addWorkout(Person person, String date, Scanner scanner) {

        System.out.println("Enter workout duration (min):");
        int durationMinutesInput = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter equipment weight (kg):");
        double equipmentWeightKgInput = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter amount approaches weight:");
        int amountApproaches = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter amount repetitions weight:");
        int amountRepetitions = Integer.parseInt(scanner.nextLine());

        Powerlifting workout = new Powerlifting(date, durationMinutesInput, equipmentWeightKgInput, amountApproaches, amountRepetitions);

        addAdditionalInfo(workout, scanner);
        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public void editWorkout(Person person, Workout workout, Scanner scanner) {
        if (workout instanceof Powerlifting powerlifting) {
            System.out.println("\nWhich setting do you want to change?" +
                    "\n   -> 1. Duration: " + powerlifting.getDurationMinutes() +
                    "\n   -> 2. Equipment Weight: " + powerlifting.getEquipmentWeightKg() +
                    "\n   -> 3. Amount approaches: " + powerlifting.getAmountApproaches() +
                    "\n   -> 4. Amount repetitions: " + powerlifting.getAmountRepetitions() +
                    "\n   -> 5. Additional information): " + powerlifting.getAdditionalInfo() +
                    "\n   -> 0. Go back");
        }

        String line = scanner.nextLine();
        System.out.println("Enter value:");
        String value = scanner.nextLine();
        if (workout instanceof Powerlifting powerlifting) {
            switch (line) {
                case "1":
                    powerlifting.setDurationMinutes(Integer.parseInt(value));
                    break;
                case "2":
                    powerlifting.setEquipmentWeightKg(Double.parseDouble(value));
                    break;
                case "3":
                    powerlifting.setAmountApproaches(Integer.parseInt(value));
                    break;
                case "4":
                    powerlifting.setAmountRepetitions(Integer.parseInt(value));
                    break;
                case "5":
                    powerlifting.setAdditionalInfo(value);
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
    public String toString() {
        return "Powerlifting";
    }


}
