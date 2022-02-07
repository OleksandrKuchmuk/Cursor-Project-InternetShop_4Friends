package model;

import exception.UserAccessException;

import java.util.Objects;

public class User {
 private String userName;
 private String password;
    private boolean isBlocked;
    private final UserRole userRole;


    public User(String userName, String password, UserRole userRole) {
        setUserName(userName);
        setPassword(password);
        this.userRole = userRole;
        this.isBlocked = false;
    }
 
      public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }

    public void setUserName(String userName) {
        if (userName.length() <= 20 && userName.length() >= 6) {
            if (!userName.matches("([A-Za-z0-9])\\w+")) {
                System.out.println("Username can contain only letters(a-z), numbers(0-9), symbol( _ ).");
            } else {
                this.userName = userName;
            }
        } else {
            System.out.println("User name cannot be less than 6 and more than 20");
        }
    }

    public void setPassword(String password) {
        if (password.length() <= 20 && password.length() >= 6) {
            if (!password.matches("([A-Za-z0-9])\\w+")) {
                System.out.println("Password can contain only letters(a-z), numbers(0-9), symbol( _ ).");
            } else {
                this.password = password;
            }
        } else {
            System.out.println("Password cannot be less than 6 and more than 20");
        }
    }


    public void block() {
        if (userRole == UserRole.ADMIN) {
            throw new UserAccessException("Администратора не можна заблокувати.");
        } else {
            this.isBlocked = true;

        }
    }

            public void unblock () {
                this.isBlocked = false;
            }




            @Override
            public boolean equals (Object o){
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return userName.equals(user.userName);
            }

            @Override
            public int hashCode () {
                return Objects.hash(userName);
            }

            @Override
            public String toString () {
                return "User{" +
                        "username='" + userName + '\'' +
                        ", password='" + password + '\'' +
                        ", isBlocked=" + isBlocked +
                        ", userRole=" + userRole +
                        '}';
            }
        }

