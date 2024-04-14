package website.ylab.model.person;

import website.ylab.model.CustomFormat;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.repository.PersonInfoRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Person implements Statistic {
    private String login;
    private String password;
    private String email;
    private PersonInfoRepository personInfoRepository;

    public Person(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.personInfoRepository = new PersonInfoRepository();
    }

    public TreeMap<String, ArrayList<Workout>> getUserWorkouts() {
        return personInfoRepository.getPersonDateAndWorkoutsMap();
    }

    public ArrayList<Workout> getUserWorkoutsOnSpecificDay(String date) {
        return personInfoRepository.getPersonDateAndWorkoutsMap().get(date);
    }

    public ArrayList<Workout> getUserWorkoutsToday() {
        return personInfoRepository.getPersonDateAndWorkoutsMap().get(CustomFormat.dtf.format(LocalDateTime.now()));
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) this.password = newPassword;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
