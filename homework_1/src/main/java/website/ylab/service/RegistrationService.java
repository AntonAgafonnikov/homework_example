package website.ylab.service;

import website.ylab.model.person.User;
import website.ylab.repository.PersonInfoRepository;

import java.util.Scanner;

public class RegistrationService {
    public static void registerPerson(Scanner scanner) {
        while (true) {
            System.out.println("""
                    
                    ===================================Registration====================================
                        -> 0. Authorization, if you remember your personal data
                    """);
            System.out.println("Enter your desired login:");
            String login = scanner.nextLine();
            if ("0".equals(login)) break;


            if (PersonInfoRepository.getPersonLoginAndPasswordMap().containsKey(login) || login.isEmpty()) {
                System.out.println("Error! Incorrect login or this login is already taken!");
                continue;
            }

            while (true) {
                System.out.println("Enter your desired password (minimum 3 characters):");
                String password = scanner.nextLine();
                if (password.length() < 3) {
                    System.out.println("Error! Password must contain at least 3 characters!");
                } else {
                    System.out.println("Enter your e-mail:");
                    String email = scanner.nextLine();
                    PersonInfoRepository.getPersonLoginAndPasswordMap().put(login, password);
                    PersonInfoRepository.getPersonLoginAndPersonMap().put(login, new User(login, password, email));
                    break;
                }
            }
            System.out.println("Congratulations! You have successfully registered.");
            System.out.println("===================================================================================");
            break;
        }
    }
}
