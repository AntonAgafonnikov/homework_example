package website.ylab.repository;

import website.ylab.model.CustomFormat;
import website.ylab.model.person.Person;
import website.ylab.model.person.User;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.type.Crossfit;
import website.ylab.model.workout.type.Powerlifting;
import website.ylab.model.workout.type.RunningImpl;
import website.ylab.model.workout.type.SwimmingImpl;

import java.time.LocalDateTime;
import java.util.*;

public class PersonInfoRepository {
    private static HashMap<String, String> personLoginAndPasswordMap;
    private static HashMap<String, Person> personLoginAndPersonMap;
    private final TreeMap<String, ArrayList<Workout>> personDateAndWorkoutsMap;
    private final ArrayList<String> auditActions = new ArrayList<>();

    //test value TODO
    static {
        User user = new User("user", "user", "user");
        getPersonLoginAndPasswordMap().put(user.getLogin(), user.getPassword());
        getPersonLoginAndPersonMap().put(user.getLogin(), user);

        user.getUserWorkouts().put(CustomFormat.dtf.format(LocalDateTime.now()), new ArrayList<>(List.of(
                        new SwimmingImpl(CustomFormat.dtf.format(LocalDateTime.now()), 60, 1000))));
        user.getUserWorkouts().put("24-03-10", new ArrayList<>(List.of(
                new Crossfit("24-03-10", 23,23,23,23))));
        user.getUserWorkouts().put("23-07-15", new ArrayList<>(List.of(
                new Powerlifting("23-07-15", 2, 33,3,2),
                new RunningImpl("23-07-15", 23,2000))));
        user.getUserWorkouts().put("22-03-10", new ArrayList<>(List.of(
                new Crossfit("22-03-10", 23,23,23,23))));
        user.getUserWorkouts().put("21-07-15", new ArrayList<>(List.of(
                new Powerlifting("21-07-15", 2, 33,3,2))));
        user.getUserWorkouts().put("20-07-15", new ArrayList<>(List.of(
                new RunningImpl("20-07-15", 28,3000))));
        user.getUserWorkouts().put("19-07-15", new ArrayList<>(List.of(
                new RunningImpl("19-07-15", 28,3000))));

        getPersonLoginAndPasswordMap().put("admin", "admin");
        getPersonLoginAndPersonMap().put("admin", new User("admin", "admin", "admin"));
    }

    public PersonInfoRepository() {
        personDateAndWorkoutsMap = new TreeMap<>();
    }

    public static HashMap<String, String> getPersonLoginAndPasswordMap() {
        if (personLoginAndPasswordMap == null) {
            personLoginAndPasswordMap = new HashMap<>();
        }
        return personLoginAndPasswordMap;
    }

    public static HashMap<String, Person> getPersonLoginAndPersonMap() {
        if (personLoginAndPersonMap == null) {
            personLoginAndPersonMap = new HashMap<>();
        }
        return personLoginAndPersonMap;
    }

    public TreeMap<String, ArrayList<Workout>> getPersonDateAndWorkoutsMap() {
        return personDateAndWorkoutsMap;
    }

    public ArrayList<String> getAuditActions() {
        return auditActions;
    }

}
