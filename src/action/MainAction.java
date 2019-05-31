package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Main;

import java.util.Scanner;

public class MainAction extends Action {
    @Override
    public void execute() {
        Scanner scanner = Main.scanner;
        while (scanner.hasNext()) {
            String input = scanner.next();
            Action action = ActionFactory.getClass(input);
            action.execute();
        }
    }
}
