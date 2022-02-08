package dao;

import model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> add(User var1);

    Optional<User> getByUsername(String var1);

    Optional<User> update(String var1, User var2);

    Optional<User> delete(String var1);
}
