package website.ylab.model.person;

import website.ylab.model.workout.basic.major.Workout;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public interface EditingUsers {
    void deleteUser(Scanner scanner);

    TreeMap<String, ArrayList<Workout>> showAllWorkoutsUser(Scanner scanner);
}
