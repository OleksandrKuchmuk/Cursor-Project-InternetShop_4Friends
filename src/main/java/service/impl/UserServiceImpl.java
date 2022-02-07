package service.impl;


import dao.impl.UserDaoImpl;
import exception.UserAccessException;
import model.User;
import model.UserRole;
import service.Response;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    public Response login(String username, String password) {
        Optional<User> user = this.userDao.getByUsername(username);
        if (user.isPresent()) {
            User userObj = user.get();
            if (userObj.isBlocked()) {
                return new Response(null, false, "User is blocked");
            }

            if (userObj.getPassword().equals(password)) {
                return new Response<>(userObj, true, userObj.toString());
            }
        }

        return new Response(null, false, "Incorrect username or password");
    }

    public Response<User> register(String username, String password) {
        Optional<User> user = userDao.getByUsername(username);
        if (user.isEmpty()) {
            User newUser;
            try {
                newUser = new User(username, password, UserRole.USER);
            } catch (IllegalArgumentException var6) {
                return new Response<>(null, false, var6.getMessage());
            }

            userDao.add(newUser);
            return new Response<>(newUser, true, user.toString());
        } else {
            return new Response<>(null, false, "User already exist");
        }
    }

    public Response<User> blockUser(String username) {
        Optional<User> user = this.userDao.getByUsername(username);
        if (user.isPresent()) {
            User userToBlock = user.get();

            try {
                userToBlock.block();
            } catch (UserAccessException var5) {
                return new Response<>(null, false, var5.getMessage());
            }

            this.userDao.update(username, userToBlock);
            return new Response<>(userToBlock, true, "User '" + username + "' is blocked");
        } else {
            return new Response<>(null, false, "User '" + username + "' does not exist");
        }
    }

    public Response<User> unblockUser(String username) {
        Optional<User> user = this.userDao.getByUsername(username);
        if (user.isPresent()) {
            User userToBlock = user.get();
            userToBlock.unblock();
            this.userDao.update(username, userToBlock);
            return new Response<>(userToBlock, true, "User '" + username + "' is unblocked");
        } else {
            return new Response<>(null, false, "User '" + username + "' does not exist");
        }
    }
}



