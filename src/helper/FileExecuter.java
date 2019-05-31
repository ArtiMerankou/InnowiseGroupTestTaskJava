package InnowiseGroupTestTaskJava.helper;

import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.Settings;
import InnowiseGroupTestTaskJava.action.ActionFactory;
import InnowiseGroupTestTaskJava.domain.User;
import java.io.*;

public class FileExecuter {

    private static FileExecuter fileExecuter;

    public static FileExecuter getInstance(){
        if (fileExecuter == null){
            fileExecuter = new FileExecuter();
        }
        return fileExecuter;
    }

    /**
     * This method saves users from Main.userList to file
     */
    public void saveUsers (){
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try {
            //see class Settings
            fos = new FileOutputStream(Settings.fileName);
            oos = new ObjectOutputStream(fos);
            for (User user : Main.userList){
                oos.writeObject(user);
            }
            System.out.println("> Users successfully saved.");
        } catch (IOException e) {
            System.out.println("ERROR. File wasn't saved. Let's try to start over");
            System.out.println(Settings.mainMessage);
            ActionFactory.getClass("main").execute();
        } finally {
            try {oos.close();}
            catch (IOException e){}
        }
    }

    /**
     * This method loads users from file to Main.userList
     */
    public void loadUsers(){
        Main.userList.clear();
        try {
            //see class Settings
            FileInputStream fis = new FileInputStream(Settings.fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            for(int i =0; i<Double.POSITIVE_INFINITY; i++){
                User user = (User) ois.readObject();
                Main.userList.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("> File not found. A new one will be created");
        } catch (ClassNotFoundException e) {
            System.out.println("Something went wrong. Let's try to start over");
            System.out.println(Settings.mainMessage);
            ActionFactory.getClass("main").execute();
        } catch (IOException e) {
            // end of stream
            System.out.println("> Users successfully loaded.");
        } catch (Exception ignored){}
    }
}
