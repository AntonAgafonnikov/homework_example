package website.ylab.model.workout.type;

import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.basic.minor.Yoga;
import website.ylab.model.workout.skills.SpiritualDevelopment;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
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

        addWorkoutToUserList(person, date, workout);
    }

    @Override
    public String toString() {
        return "Hatha Yoga";
    }


}
