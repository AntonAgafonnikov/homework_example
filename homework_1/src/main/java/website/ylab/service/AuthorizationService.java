package website.ylab.service;

import website.ylab.model.person.Person;
import website.ylab.repository.PersonInfoRepository;

import java.util.Scanner;

public class AuthorizationService {
    public static Person authorizePerson(Scanner scanner) {
        Person person;
        while (true) {
            System.out.println("""
                    
                    ===================================Authorization===================================
                        -> 1. Registration
                    """);
            System.out.println("Enter your login:");
            String login = scanner.nextLine();
            if ("1".equals(login)) {
                RegistrationService.registerPerson(scanner);
                continue;
            }

            if ("2".equals(login)) {
                //TODO
                continue;
            }

            System.out.println("Enter your password:");
            String introducedPassword = scanner.nextLine();
            if (PersonInfoRepository.getPersonLoginAndPasswordMap().containsKey(login) &&
                    introducedPassword.equals(PersonInfoRepository.getPersonLoginAndPasswordMap().get(login))) {
                    person = PersonInfoRepository.getPersonLoginAndPersonMap().get(login);
                    System.out.println("Hello, " + person.getLogin() + "! Glad to see you again!");
                    System.out.println("===================================================================================");
                    break;
            } else {
                System.out.println("Error! Wrong login or password!");
            }
        }
        return person;
    }
}
