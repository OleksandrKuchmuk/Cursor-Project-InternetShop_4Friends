package model;

import exception.UserAccessException;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private boolean isBlocked;
    private final UserRole userRole;

    public User(String username, String password, UserRole userRole) {
        setUsername(username);
        setPassword(password);
        this.userRole = userRole;
        this.isBlocked = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUsername(String username) {
        if (username.length() > 32 || username.length() < 4) {
            throw new IllegalArgumentException("Довжина імені користувача має бути від 4 до 32 символів.");
        }
        if (!username.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Ім'я користувача може містити лише літери(a-z), цифри(0-9), символ ( _ ).");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() > 32 || password.length() < 8) {
            throw new IllegalArgumentException("Довжина пароля має бути від 8 to 32 символів.");
        }
        if (!password.matches("([A-Za-z0-9_])\\w+")) {
            throw new IllegalArgumentException("Пароль може містити тільки літери(a-z), цифри(0-9), символ ( _ ).");
        }
        this.password = password;
    }

    public void block() {
        if (userRole == UserRole.ADMIN) {
            throw new UserAccessException("Администратора не можна заблокувати.");
        }
        isBlocked = true;
    }

    public void unblock() {
        isBlocked = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", userRole=" + userRole +
                '}';
    }
}