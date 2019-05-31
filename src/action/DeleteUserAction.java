package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.domain.User;

public class DeleteUserAction extends Action {
    @Override
    public void execute() throws NullPointerException {
        User user = EditUsersAction.selectUser();
        Main.userList.remove(user);
        System.out.println("> User successfully removed.");
        ActionFactory.getClass("save").execute();
    }
}
