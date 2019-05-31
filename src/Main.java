package InnowiseGroupTestTaskJava;

import InnowiseGroupTestTaskJava.action.ActionFactory;
import InnowiseGroupTestTaskJava.domain.User;
import InnowiseGroupTestTaskJava.helper.FileExecuter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> userList = new LinkedList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FileExecuter.getInstance().loadUsers();
        System.out.println(Settings.mainMessage);
        ActionFactory.getClass("main").execute();
    }
}
