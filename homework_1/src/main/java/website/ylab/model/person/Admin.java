package website.ylab.model.person;

import website.ylab.model.workout.basic.major.Workout;

import java.util.Date;
import java.util.List;

public class Admin extends Person implements EditingUsers{
    public Admin(String login, String password, String email) {
        super(login, password, email);
    }

    @Override
    public List<Workout> getAllUserWorkouts(User user) {
        return null;
    }

    @Override
    public void addUserWorkout(User user, Workout workout) {

    }

    @Override
    public void deleteUserWorkout(User user, Date date, Workout workout) {

    }

    @Override
    public void editUserWorkout(User user, Date date, Workout workout) {

    }

    @Override
    public void changeUserPassword(String oldPassword, String newPassword) {

    }

    @Override
    public int getInfoKcalSpent() {
        return 0;
    }

    @Override
    public int getMyRecords() {
        return 0;
    }

    @Override
    public int getMyStatistics() {
        return 0;
    }
}
