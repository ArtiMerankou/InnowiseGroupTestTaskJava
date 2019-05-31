package InnowiseGroupTestTaskJava.domain;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private Role role;
    private String phone;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleString() {
        return role.toString();
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(String role) {
        if(role.equals("ADMIN")){
            this.role = Role.ADMIN;
        } else {
            this.role = Role.USER;
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
            return "firstName=" + firstName +
                    "\tlastName=" + lastName +
                    "\trole=" + role.toString() +
                    "\tphone=" + phone +
                    "\temail=" + email;
    }
}
