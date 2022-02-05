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
        User blockedUser = new User("user2", "12345678", UserRole.USER);
        blockedUser.block();
        this.userMap.put("user2", blockedUser);
    }

    public Optional<User> add(User user) {
        return Optional.ofNullable((User)this.userMap.put(user.getUserName(), user));
    }

    public Optional<User> getByUsername(String username) {
        return Optional.ofNullable((User)this.userMap.get(username));
    }

    public Optional<User> update(String username, User newUser) {
        Optional<User> deletedUser = this.delete(username);
        if (deletedUser.isPresent()) {
            this.add(newUser);
        }

        return deletedUser;
    }

    public Optional<User> delete(String username) {
        return Optional.ofNullable((User)this.userMap.remove(username));
    }
}
