package dao.impl;

import dao.UserDao;
import model.User;
import model.UserRole;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class UserDaoImpl implements UserDao {
    private final Map<String, User> userMap = new TreeMap();

    public UserDaoImpl() {
        this.userMap.put("admin", new User("admin", "masterpass", UserRole.ADMIN));
        this.userMap.put("user1", new User("user1", "12345678", UserRole.USER));
        this.userMap.put("user2", new User("user2", "12345678", UserRole.USER));
        this.userMap.put("User_3", new User("User_3", "User_3_12345678", UserRole.USER));
        User blockedUser = new User("user2", "12345678", UserRole.USER);
        blockedUser.block();
        this.userMap.put("user2", blockedUser);
    }

    public Optional<User> add(User user) {
        return Optional.ofNullable((User) this.userMap.put(user.getUserName(), user));
    }

    public Optional<User> getByUsername(String userName) {
        return Optional.ofNullable(userMap.get(userName));
    }

    public Optional<User> update(String userName, User newUser) {
        Optional<User> deletedUser = this.delete(userName);
        if (deletedUser.isPresent()) {
            this.add(newUser);
        }
        return deletedUser;
    }

    public Optional<User> delete(String userName) {
        return Optional.ofNullable((User) this.userMap.remove(userName));
    }
}