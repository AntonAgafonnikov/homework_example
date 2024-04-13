package website.ylab.model.person;

import website.ylab.model.workout.basic.major.Workout;

import java.util.Date;
import java.util.List;

public class User extends Person {
    public User(String login, String password, String email) {
        super(login, password, email);
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
