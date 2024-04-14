package website.ylab.model.person;

import website.ylab.model.workout.basic.major.Workout;
import website.ylab.repository.PersonInfoRepository;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Admin extends Person implements EditingUsers {
    public Admin(String login, String password, String email) {
        super(login, password, email);
    }

    @Override
    public int getInfoKcalSpent() {
        return 0;
    }

    @Override
    public void deleteUser(Scanner scanner) {
        System.out.println("\nEnter login user for delete");
        String login = scanner.nextLine();

        PersonInfoRepository.getPersonLoginAndPersonMap().remove(login);
        PersonInfoRepository.getPersonLoginAndPasswordMap().remove(login);
    }

    @Override
    public TreeMap<String, ArrayList<Workout>> showAllWorkoutsUser(Scanner scanner) {
        System.out.println("\nEnter login user to show workouts");
        String login = scanner.nextLine();

        Person user = PersonInfoRepository.getPersonLoginAndPersonMap().get(login);
        return user.getUserWorkouts();
    }
}
