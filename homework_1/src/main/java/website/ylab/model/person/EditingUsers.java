package website.ylab.model.person;

import website.ylab.model.workout.basic.major.Workout;

import java.util.Date;
import java.util.List;

public interface EditingUsers {
    List<Workout> getAllUserWorkouts(User user);
    void addUserWorkout(User user, Workout workout);
    void deleteUserWorkout(User user, Date date, Workout workout);
    void editUserWorkout(User user, Date date, Workout workout);
    void changeUserPassword(String oldPassword, String newPassword);
}
