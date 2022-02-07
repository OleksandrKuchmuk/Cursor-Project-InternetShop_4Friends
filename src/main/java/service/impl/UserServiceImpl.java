package service.impl;


import dao.impl.UserDaoImpl;
import model.User;
import model.UserRole;
import service.Response;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao;
    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    public Response<User> login(String username, String password) {
        Optional<User> user = userDao.getByUsername(username);
        if (user.isPresent()) {
            User userObj = user.get();
            if (userObj.isBlocked()) {
                return new Response<>(null, false, "User is blocked");
            }
            if (userObj.getPassword().equals(password)) {
                return new Response<>(userObj, true, userObj.toString());
            }
        }
        return new Response<>(null, false, "Incorrect username or password");
    }

    @Override
    public Response<User> register(String username, String password) {
        Optional<User> user = this.userDao.getByUsername(username);
        if (user.isEmpty()) {
            User newUser;
            try {
                newUser = new User(username, password, UserRole.USER);
            } catch (IllegalArgumentException var6) {
                return new Response( null, false, var6.getMessage());
            }

            this.userDao.add(newUser);
            return new Response(newUser, true, user.toString());
        } else {
            return new Response(null, false, "User already exist");
        }
    }
}



