package service;


import model.User;

public interface UserService {

    /**
     * Used to login a user
     *
     * @param username user name
     * @param password user password
     * @return outcome of login - success or not
     */
    Response<User> login(String var1, String var2);

    Response<User> register(String var1, String var2);

    Response<User> blockUser(String var1);

    Response<User> unblockUser(String var1);
}
