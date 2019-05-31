package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.helper.FileExecuter;

public class SaveAndExitAction extends Action {
    @Override
    public void execute() throws NullPointerException {
        FileExecuter.getInstance().saveUsers();
        System.out.println("Good bye!");
        System.exit(0);
    }

}
