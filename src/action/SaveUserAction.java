package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.helper.FileExecuter;
import InnowiseGroupTestTaskJava.Settings;


public class SaveUserAction extends Action {

    @Override
    public void execute() {
        FileExecuter.getInstance().saveUsers();
        System.out.println(Settings.mainMessage);
        ActionFactory.getClass("main").execute();
    }
}
