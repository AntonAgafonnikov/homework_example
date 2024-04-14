package website.ylab.service;

import website.ylab.model.CustomFormat;
import website.ylab.model.person.Admin;
import website.ylab.model.person.Person;
import website.ylab.model.workout.basic.major.Workout;
import website.ylab.repository.WorkoutRepository;

import java.time.LocalDateTime;
import java.util.*;

public class PersonWorkoutService {

    public static boolean callMainMenu(Person person, Scanner scanner) {

        System.out.println("""    
                  
                What do you want to do?
                    -> 1. Add a workout
                    -> 2. Show/Edit workout
                    -> 3. Delete workout
                    -> 4. Show a list of all my workouts
                    -> 5. My Kcal statistic
                    -> 0. Exit the application""");

        boolean isAdmin = "Admin".equals(person.getClass().getName());
        if (isAdmin) {
            System.out.println("""    
                    ====ADMIN====
                    -> 11. Add user
                    -> 12. Delete user""");
        }

        String number = scanner.nextLine();
        switch (number) {
            case "1":
                addWorkout(person, scanner);
                break;
            case "2":
                editWorkout(person, scanner);
                break;
            case "3":
                deleteWorkout(person, scanner);
                break;
            case "4":
                printUserWorkouts(person.getUserWorkouts());
                break;
            case "5":
                showStatisticsKcal(person, scanner);
                break;
            case "0":
                return false;
            case "11":
                if (person instanceof Admin admin)
                    admin.deleteUser(scanner);
                break;
            case "12":
                if (person instanceof Admin admin)
                    printUserWorkouts(admin.showAllWorkoutsUser(scanner));
                break;
            default:
                System.out.println("Invalid command number");
                break;
        }
        return true;
    }

    private static void printUserWorkouts(TreeMap<String, ArrayList<Workout>> userWorkouts) {
        if (userWorkouts == null) {
            System.out.println("You don't have any training yet");
        } else {
            for (Map.Entry<String, ArrayList<Workout>> entry : userWorkouts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static void addWorkout(Person person, Scanner scanner) {
        System.out.println("Select workout type:");
        ArrayList<Workout> workoutsList = new ArrayList<>();
        String number = selectWorkoutTypeForAdd(scanner, workoutsList);

        if ("0".equals(number)) return;

        Workout workout = workoutsList.get(Integer.parseInt(number) - 1);
        String workoutName = workout.getClass().getName();

        String date = askDate(scanner);
        if (!isAvailabilityTraining(date, workoutName, person)) {
            workout.addWorkout(person, date, scanner);
        }
    }

    private static void deleteWorkout(Person person, Scanner scanner) {
        System.out.println("""
                                
                Do you want to delete today's workout?
                    -> 1. Yes
                    -> 2. No""");
        String line = scanner.nextLine();

        String dateString = "";
        switch (line) {
            case "1":
                dateString = CustomFormat.dtf.format(LocalDateTime.now());
                break;
            case "2":
                System.out.println("\nEnter the date in the format dd-mm-yy (for example: 29-01-24):");
                dateString = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid command number");
                return;
        }

        ArrayList<Workout> workoutList = person.getUserWorkouts().get(dateString);
        line = selectWorkoutType(scanner, workoutList);

        workoutList.remove(Integer.parseInt(line) - 1);
        if (workoutList.size() == 0)
            person.getUserWorkouts().remove(dateString);
        System.out.println("Training successfully deleted!");
    }

    private static void editWorkout(Person person, Scanner scanner) {
        System.out.println("""
                                
                Do you want to edit today's workout?
                    -> 1. Yes
                    -> 2. No""");
        String line = scanner.nextLine();

        String dateString = "";
        switch (line) {
            case "1":
                dateString = CustomFormat.dtf.format(LocalDateTime.now());
                break;
            case "2":
                System.out.println("\nEnter the date in the format dd-mm-yy (for example: 29-01-24):");
                dateString = scanner.nextLine();
                break;
            default:
                System.out.println("Invalid command number");
                return;
        }

        ArrayList<Workout> workoutList = person.getUserWorkouts().get(dateString);
        line = selectWorkoutType(scanner, workoutList);

        Workout workout = workoutList.get(Integer.parseInt(line) - 1);
        workout.editWorkout(person, workout, scanner);
        System.out.println("Training successfully changed!");
    }

    private static String selectWorkoutTypeForAdd(Scanner scanner, ArrayList<Workout> workoutsList) {
        int i = 1;
        for (Workout workoutType : WorkoutRepository.getWorkoutSet()) {
            workoutsList.add(workoutType);
            System.out.println("    -> " + i + ". " + workoutType);
            i++;
        }
        System.out.println("    -> 0. Go back");
        return scanner.nextLine();
    }

    private static String selectWorkoutType(Scanner scanner, ArrayList<Workout> workoutsList) {
        int i = 1;
        for (Workout workoutType : workoutsList) {
            System.out.println("    -> " + i + ". " + workoutType);
            i++;
        }
        System.out.println("    -> 0. Go back");
        return scanner.nextLine();
    }

    private static String askDate(Scanner scanner) {
        System.out.println("""
                                
                Do you want to add today's workout?
                    -> 1. Yes
                    -> 2. No""");
        String date = scanner.nextLine();
        return "1".equals(date) ? CustomFormat.dtf.format(LocalDateTime.now()) : date;
    }

    private static boolean isAvailabilityTraining(String date, String workout, Person person) {
        ArrayList<Workout> workoutsList = person.getUserWorkouts().getOrDefault(date, null);
        if (workoutsList != null) {
            List<String> workoutListString = workoutsList.stream()
                    .map(el -> el.getClass().getName())
                    .toList();

            if (workoutListString.contains(workout)) {
                System.out.println("You've already done this workout that day!");
                return true;
            }
        }
        return false;
    }

    private static void showStatisticsKcal(Person person, Scanner scanner) {
        System.out.println("\nEnter two dates in the format yy-mm-dd (for example: 22-01-29 24-04-12):");
        String[] lineDates = scanner.nextLine().split(" ");
        TreeMap<String, ArrayList<Workout>> treeMap = person.getUserWorkouts();

        int dateMin = Integer.parseInt(lineDates[0].replace("-", ""));
        int dateMax = Integer.parseInt(lineDates[1].replace("-", ""));
        int resultKcal = 0;
        for (Map.Entry<String, ArrayList<Workout>> entry : treeMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            int dateCur = Integer.parseInt(key.replace("-", ""));
            if (dateCur >= dateMin && dateCur <= dateMax) {
                System.out.println(key + ": " + value);
                for (Workout workout : value) {
                    resultKcal += workout.getKcalSpent();
                }
            }
        }
        System.out.println("Kcal: " + resultKcal);
    }
}
