package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.domain.User;

import java.util.List;

public class ShowUsersAction extends Action {
    @Override
    public void execute() {
        if(Main.userList.isEmpty()){
            System.out.println("> No users created yet. Let's add one.");
            ActionFactory.getClass("addNewUser").execute();
        } else {
            List<User> userList = Main.userList;
            for (int i = 0; i < userList.size(); i++) {
                int number = i + 1;
                System.out.println(number + "\t" + userList.get(i).toString());
            }
            System.out.println("> Do you want to \"edit\" or \"delete\" a user?\n> Or go \"back\"?");
            ActionFactory.getClass("main").execute();
        }
    }
}
