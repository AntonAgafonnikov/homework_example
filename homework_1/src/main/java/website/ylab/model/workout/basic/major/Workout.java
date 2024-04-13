package website.ylab.model.workout.basic.major;

import website.ylab.model.CustomFormat;
import website.ylab.model.person.Person;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Workout {
    public String dateString;
    private int durationMinutes;
    private String typeOfWorkout;
    private int kcalSpent;

    public Workout(String dateString, int durationMinutes) {
        this.dateString = dateString;
        this.typeOfWorkout = this.getClass().getName();
        this.durationMinutes = durationMinutes;
    }

    public Workout(String dateString, int durationMinutes, String typeOfWorkout) {
        this(dateString, durationMinutes);
        this.typeOfWorkout = typeOfWorkout;
    }

    public String getTypeOfWorkout() {
        return typeOfWorkout;
    }

    public void setTypeOfWorkout(String typeOfWorkout) {
        this.typeOfWorkout = typeOfWorkout;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getKcalSpent() {
        return kcalSpent;
    }

    public void setKcalSpent(int kcalSpent) {
        this.kcalSpent = kcalSpent;
    }

    public abstract void warmUp();

    public abstract void spendKcal();

    public abstract void addWorkout(Person person, String date, Scanner scanner);

    public void addWorkoutToUserList(Person person, String date, Workout workout) {
        if (date.isEmpty()) {
            System.out.println("Invalid date!");
            return;
        }
        ArrayList<Workout> workoutsList = person.getUserWorkouts().getOrDefault(date, null);
        if (workoutsList != null) {
            workoutsList.add(workout);
            person.getUserWorkouts().put(date, workoutsList);

        } else {
            person.getUserWorkouts().put(date, new ArrayList<>(List.of(workout)));
        }
        System.out.println("Workout added successfully!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return durationMinutes == workout.durationMinutes && kcalSpent == workout.kcalSpent && Objects.equals(dateString, workout.dateString) && Objects.equals(typeOfWorkout, workout.typeOfWorkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateString, durationMinutes, typeOfWorkout, kcalSpent);
    }
}
