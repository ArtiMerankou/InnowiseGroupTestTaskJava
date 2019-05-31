package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.domain.User;

import java.util.Scanner;

import static InnowiseGroupTestTaskJava.helper.Checker.*;

public class AddNewUserAction extends Action {

    @Override
    public void execute() {
        Scanner scanner = Main.scanner;
        System.out.println("> Enter first name:");
        while (scanner.hasNext()) {
            User user = new User();
            String role;
            String phone;
            String email;
            user.setFirstName(scanner.next());
            System.out.println("> Enter Last Name:");
            user.setLastName(scanner.next());
            while (user.getRole() == null) {
                System.out.println("> Enter Role: (ADMIN or USER)");
                role = scanner.next();
                //see helper.Checker
                if (checkRole(role)) {
                    user.setRole(role);
                } else {
                    System.out.println("> Invalid input. Try again.");
                }
            }
            while (user.getPhone() == null) {
                System.out.println("> Enter Phone: (375*********)");
                phone = scanner.next();
                //see helper.Checker
                if (!checkPhone(phone)) {
                    System.out.println("> Invalid input. Try again.");
                    //see helper.Checker
                } else if(checkRepeat("phone", phone)) {
                    System.out.println("> User with this phone already exists");
                } else {
                    user.setPhone(phone);
                }
            }
            while (user.getEmail() == null) {
                System.out.println("> Enter E-mail:");
                email = scanner.next();
                //see helper.Checker
                if (!checkEmail(email)) {
                    System.out.println("> Invalid input. Try again");
                    //see helper.Checker
                } else if(checkRepeat("email", email)){
                    System.out.println("> User with this email already exists");
                } else {
                    user.setEmail(email);
                }
            }
            Main.userList.add(user);
            System.out.println(user.toString());
            System.out.println("> User created successfully");
            System.out.println("> Type \"save\" to save or type \"new\" to create new user.");
            ActionFactory.getClass("main").execute();
        }
    }
}
