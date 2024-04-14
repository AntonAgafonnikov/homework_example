package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.Cardio;
import website.ylab.model.workout.skills.Swimming;

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

        addAdditionalInfo(workout, scanner);
        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public void editWorkout(Person person, Workout workout, Scanner scanner) {
        if (workout instanceof SwimmingImpl swimming) {
            System.out.println("\nWhich setting do you want to change?" +
                    "\n   -> 1. Duration: " + swimming.getDurationMinutes() +
                    "\n   -> 2. Distance: " + swimming.getDistanceMeter() +
                    "\n   -> 3. Additional information): " + swimming.getAdditionalInfo() +
                    "\n   -> 0. Go back");
        }

        String line = scanner.nextLine();
        System.out.println("Enter value:");
        String value = scanner.nextLine();
        if (workout instanceof SwimmingImpl swimming) {
            switch (line) {
                case "1":
                    swimming.setDurationMinutes(Integer.parseInt(value));
                    break;
                case "2":
                    swimming.setDistanceMeter(Double.parseDouble(value));
                    break;
                case "3":
                    swimming.setAdditionalInfo(value);
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
