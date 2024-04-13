package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.Cardio;
import website.ylab.model.workout.skills.Swimming;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SwimmingImpl extends Cardio implements Swimming {

    public SwimmingImpl(String dateString, int durationMinutes, double distanceMeter) {
        super(dateString, durationMinutes, distanceMeter);
        this.spendKcal();
    }

    @Override
    public void swim() {
        System.out.println("Swim!"); //TODO
    }

    @Override
    public String toString() {
        return "Swimming";
    }

    @Override
    public void addWorkout(Person person, String date, Scanner scanner) {
        System.out.println("Enter workout duration (min):");
        int durationMinutesInput = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter workout distanceMeter (meter):");
        int distanceMeterInput = Integer.parseInt(scanner.nextLine());

        SwimmingImpl workout = new SwimmingImpl(date, durationMinutesInput, distanceMeterInput);

        addWorkoutToUserList(person, date, workout);
    }


}
