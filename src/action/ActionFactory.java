package InnowiseGroupTestTaskJava.action;

import InnowiseGroupTestTaskJava.Settings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is like dispatcher. User types a command and get an Action
 */
public class ActionFactory {

    private static Map<String, Class<? extends Action>> actions = new LinkedHashMap<>();
    static {
        actions.put("main", MainAction.class);
        actions.put("addNewUser", AddNewUserAction.class);
        actions.put("showUsers", ShowUsersAction.class);
        actions.put("new", AddNewUserAction.class);
        actions.put("save", SaveUserAction.class);
        actions.put("edit", EditUsersAction.class);
        actions.put("delete", DeleteUserAction.class);
        actions.put("back", BackAction.class);
        actions.put("exit", SaveAndExitAction.class);
    }

    public static Action getClass(String message) {
        Class<? extends Action> actionClass = actions.get(message);
        if(actionClass != null) {
            try {return actionClass.getDeclaredConstructor().newInstance();}
            catch (Exception ignored){}
        } else {
            System.out.println("> ERROR. You have to start over");
            System.out.println(Settings.mainMessage);
            try {return MainAction.class.getDeclaredConstructor().newInstance();}
            catch (Exception ignored){}
        }
        return null;
    }
}
