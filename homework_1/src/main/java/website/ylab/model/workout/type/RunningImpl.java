package website.ylab.model.workout.type;

import website.ylab.model.CustomFormat;
import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.skills.Running;
import website.ylab.model.workout.basic.minor.Cardio;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunningImpl extends Cardio implements Running {

    public RunningImpl(String dateString, int durationMinutes, double distanceMeter) {
        super(dateString, durationMinutes, distanceMeter);
        this.spendKcal();
    }

    @Override
    public void run() {
        System.out.println("Run!"); //TODO
    }

    @Override
    public String toString() {
        return "Running";
    }

    @Override
    public void addWorkout(Person person, String date, Scanner scanner) {
        System.out.println("Enter workout duration (min):");
        int durationMinutesInput = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter workout distanceMeter (meter):");
        int distanceMeterInput = Integer.parseInt(scanner.nextLine());


        RunningImpl workout = new RunningImpl(date, durationMinutesInput, distanceMeterInput);

        addWorkoutToUserList(person, date, workout);
    }


}
