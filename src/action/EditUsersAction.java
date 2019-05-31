package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.helper.FileExecuter;
import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.domain.User;
import java.util.Scanner;

import static InnowiseGroupTestTaskJava.helper.Checker.*;

public class EditUsersAction extends Action {
    private Scanner scanner = Main.scanner;

    @Override
    public void execute() throws NullPointerException {
        User user = selectUser();
        System.out.println("> What parameter do you want to edit?");
        while (!scanner.hasNext("firstName|lastName|role|phone|email")){
            System.out.println("> Input not valid. Try again!!!!!!");
            scanner.next();
        }
        String parameter = scanner.next();
        System.out.println("> Enter new value");
        String value = scanner.next();
        switch (parameter){
            case "firstName" :
                user.setFirstName(value);
                break;
            case "lastName" :
                user.setLastName(value);
                break;
            case "role" :
                while (!value.equals(user.getRoleString())) {
                    if (checkRole(value)) {
                        user.setRole(value);
                    } else {
                        System.out.println("> Invalid input. Try again. Enter Role: (ADMIN or USER)");
                        value = scanner.next();
                    }
                }
                break;
            case "phone" :
                if (checkPhone(value)) {
                    user.setPhone(value);
                } else {
                    System.out.println("> Invalid input. Try again. Enter Phone: (375*********)");
                }
                break;
            case "email" :
                if (checkEmail(value)) {
                    user.setEmail(value);
                } else {
                    System.out.println("> Invalid input. Try again. Enter E-mail");
                }
                break;
        }
        System.out.println("> User updated\n"+user.toString());
        FileExecuter.getInstance().saveUsers();
        System.out.println("> Do you want to \"edit\" or \"delete\" a user? Or go \"back\"?\"");
        ActionFactory.getClass("main").execute();
    }

    static User selectUser() {
        User user;
        if(Main.userList.size() == 1){
            user = Main.userList.get(0);
        } else {
            Scanner scanner = Main.scanner;
            System.out.println("> Select user (1,2,3..n)");
            int size = Main.userList.size();
            String input = scanner.next();
            int index = Integer.parseInt(input);
            while (!checkUserNumber(input) || index > size || index<1) {
                System.out.println("> Input not valid. Try again");
                input = scanner.next();
                try {
                    index = Integer.parseInt(input);
                } catch (NumberFormatException ignored){}
            }
            user = Main.userList.get(index - 1);
        }
        return user;
    }

}
