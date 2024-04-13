package website.ylab;

import website.ylab.model.person.Person;
import website.ylab.service.AuthorizationService;
import website.ylab.service.PersonWorkoutService;
import website.ylab.service.RegistrationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!\nAre you registered?\n    -> 1. Yes\n    -> 2. No");

        try (Scanner scanner = new Scanner(System.in)) {
            String scannerString = scanner.nextLine();

            if ("2".equals(scannerString)) {
                RegistrationService.registerPerson(scanner);
            }

            Person currentPerson = AuthorizationService.authorizePerson(scanner);

            boolean isNotExit = true;
            while (isNotExit) {
                isNotExit = PersonWorkoutService.callMainMenu(currentPerson, scanner);
            }
        }
    }
}