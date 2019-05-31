package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Settings;

public class BackAction extends Action {
    @Override
    public void execute() throws NullPointerException {
        System.out.println(Settings.mainMessage);
        ActionFactory.getClass("main").execute();
    }
}
