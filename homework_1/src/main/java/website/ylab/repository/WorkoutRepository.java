package website.ylab.repository;

import website.ylab.model.workout.basic.major.Workout;
import website.ylab.model.workout.type.*;

import java.util.HashSet;

public class WorkoutRepository {

    private static final HashSet<Workout> workoutSet = new HashSet<>();

    //TODO for initialization
    static {
        workoutSet.add(new Crossfit("22-03-10", 30,80,10,5));
        workoutSet.add(new HathaYoga("22-03-10", 60, 30));
        workoutSet.add(new Powerlifting("22-03-10", 120,150,5,10));
        workoutSet.add(new RunningImpl("22-03-10", 60,10000));
        workoutSet.add(new SwimmingImpl("22-03-10", 45,3000));
    }
    public static HashSet<Workout> getWorkoutSet() {
        return workoutSet;
    }
}
