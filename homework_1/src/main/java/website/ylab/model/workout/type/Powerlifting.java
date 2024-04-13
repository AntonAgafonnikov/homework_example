package website.ylab.model.workout.type;

import website.ylab.model.CustomFormat;
import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.WeightTraining;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public String toString() {
        return "Powerlifting";
    }


}
