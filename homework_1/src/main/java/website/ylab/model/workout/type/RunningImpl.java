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

        addAdditionalInfo(workout, scanner);
        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public void editWorkout(Person person, Workout workout, Scanner scanner) {
        if (workout instanceof RunningImpl runningImpl) {
            System.out.println("\nWhich setting do you want to change?" +
                    "\n   -> 1. Duration: " + runningImpl.getDurationMinutes() +
                    "\n   -> 2. Distance: " + runningImpl.getDistanceMeter() +
                    "\n   -> 3. Additional information): " + runningImpl.getAdditionalInfo() +
                    "\n   -> 0. Go back");
        }

        String line = scanner.nextLine();
        System.out.println("Enter value:");
        String value = scanner.nextLine();
        if (workout instanceof RunningImpl runningImpl) {
            switch (line) {
                case "1":
                    runningImpl.setDurationMinutes(Integer.parseInt(value));
                    break;
                case "2":
                    runningImpl.setDistanceMeter(Double.parseDouble(value));
                    break;
                case "3":
                    runningImpl.setAdditionalInfo(value);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid command number");
                    break;
            }
        }
    }
}
