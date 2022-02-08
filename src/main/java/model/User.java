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
        if (userName.length() > 32 || userName.length() < 4) {
            throw new IllegalArgumentException("Username length must be from 4 to 32.");
        }
        if (!userName.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Username can contain only letters(a-z, A-Z), numbers(0-9), symbol( _ ).");
        }
        this.userName = userName;
    }


    public void setPassword(String password) {
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException("Password length must be from 8 to 32.");
        }
        if (!password.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Password can contain only letters(a-z, A-Z), numbers(0-9), symbol( _ ).");
        }
        this.password = password;
    }


    public void block() {
        if (userRole == UserRole.ADMIN) {
            throw new UserAccessException("Admin can not be blocked.");
        } else {
            this.isBlocked = true;
        }
    }

    public void unblock() {
        this.isBlocked = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", userRole=" + userRole +
                '}';
    }
}



