package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.Yoga;
import website.ylab.model.workout.skills.SpiritualDevelopment;

import java.util.Scanner;

public class HathaYoga extends Yoga implements SpiritualDevelopment {
    public HathaYoga(String dateString, int durationMinutes, int durationMeditationMin) {
        super(dateString, durationMinutes, durationMeditationMin);
        this.spendKcal();
    }

    @Override
    public void meditation() {
        System.out.println("Close your eyes. Listen to my voice");
    }

    @Override
    public void addWorkout(Person person, String date, Scanner scanner) {

        System.out.println("Enter workout duration (min):");
        int durationMinutesInput = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter workout duration meditationMin (min):");
        int durationMeditationMinInput = Integer.parseInt(scanner.nextLine());

        HathaYoga workout = new HathaYoga(date, durationMinutesInput, durationMeditationMinInput);

        addAdditionalInfo(workout, scanner);
        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public void editWorkout(Person person, Workout workout, Scanner scanner) {
        if (workout instanceof HathaYoga hathaYoga) {
            System.out.println("\nWhich setting do you want to change?" +
                    "\n   -> 1. Duration: " + hathaYoga.getDurationMinutes() +
                    "\n   -> 2. Duration meditation: " + hathaYoga.getDurationMeditationMin() +
                    "\n   -> 3. Additional information): " + hathaYoga.getAdditionalInfo() +
                    "\n   -> 0. Go back");
        }

        String line = scanner.nextLine();
        System.out.println("Enter value:");
        String value = scanner.nextLine();
        if (workout instanceof HathaYoga hathaYoga) {
            switch (line) {
                case "1":
                    hathaYoga.setDurationMinutes(Integer.parseInt(value));
                    break;
                case "2":
                    hathaYoga.setDurationMeditationMin(Integer.parseInt(value));
                    break;
                case "3":
                    hathaYoga.setAdditionalInfo(value);
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
        return "Hatha Yoga";
    }


}
