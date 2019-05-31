package InnowiseGroupTestTaskJava.helper;

import InnowiseGroupTestTaskJava.Main;
import InnowiseGroupTestTaskJava.domain.Role;
import InnowiseGroupTestTaskJava.domain.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All checking is in here.
 */
public class Checker {

    /**
     * Check the user's input.
     * @return true if domain.Role has this value (input is correct). @return false if not.
     */
    public static boolean checkRole(String role) {
        Set<Role> roles = new HashSet<>(Arrays.asList(Role.values()));
        for( Role role1 : roles){
            if (role1.toString().equals(role)){
                return true;
            }
        }
        return false;
    }

    /**
     * Check the user's input.
     * @return true if input matcher the phone regex (input is correct). @return false if not.
     */
    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("375\\d{9}$");
        Matcher matcher = pattern.matcher(phone);
        while(matcher.find()){
            return true;
        }
        return false;
    }

    /**
     * Check the user's input.
     * @return true if input matcher the email regex (input is correct). @return false if not.
     */
    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile("(\\w)+\\p{Punct}?(\\w)+@(\\w){2,}+\\.(\\w{2,4})$");
        Matcher matcher = pattern.matcher(email);
        while(matcher.find()){
            return true;
        }
        return false;
    }

    /**
     * Check the user's input when selecting user from List.
     * @return true if input matcher the regex (not 0). @return false if not.
     */
    public static boolean checkUserNumber(String userNumber) {
        Pattern pattern = Pattern.compile("[1-9]\\d*$");
        Matcher matcher = pattern.matcher(userNumber);
        while(matcher.find()){
            return true;
        }
        return false;
    }

    /**
     * This method checks if there are users in List with same parameter's values
     * @param lookingParameter what user's parameter we are checking.
     * @param value what value we are checking
     * @return true if value already exists. @return false if not.
     */
    public static boolean checkRepeat(String lookingParameter, String value) {
        for (User user : Main.userList){
            switch (lookingParameter){
                case "phone" :  if(user.getPhone().equals(value)){
                    return true;
                }
                case "email" :if (user.getEmail().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

}