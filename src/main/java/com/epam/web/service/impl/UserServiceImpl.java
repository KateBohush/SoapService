package com.epam.web.service.impl;

import com.epam.dao.UserDAO;
import com.epam.model.User;
import com.epam.web.model.UserActionWSResponse;
import com.epam.web.model.UserActionWSStatus;
import com.epam.web.service.UserService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.web.service.UserService")
public class UserServiceImpl implements UserService {

    private UserDAO userDao=new UserDAO();


    public UserActionWSResponse login(String login, String password) {
        boolean resultOfLogin=userDao.checkLoginAndPassword(login, password);
        User result=userDao.getByLogin(login);
        if(resultOfLogin)
            return UserActionWSResponse.success(UserActionWSStatus.LOGIN_SUCCESSFUL, result);
        return UserActionWSResponse.fault(UserActionWSStatus.NO_SUCH_USER_MSG);
    }

    public UserActionWSResponse getRole(Integer id) {
        String role=userDao.showRole(id);
        User result=userDao.getById(id);
        if(role!=null)
            return UserActionWSResponse.success(UserActionWSStatus.GET_ROLE_FOR_USER_MSG, result);
        return UserActionWSResponse.fault(UserActionWSStatus.NO_ROLE);
    }


    public UserActionWSResponse showAllUsers() {
        Object [] results =userDao.getAll().toArray();
        if(results.length!=0)
            return UserActionWSResponse.success(UserActionWSStatus.GET_ALL_USERS_MSG, results);
        return UserActionWSResponse.fault(UserActionWSStatus.NO_USERS_MSG);
    }

    public UserActionWSResponse ShowUsersByRole(String role) {
        Object [] results =userDao.getAllUsersByRole(role).toArray();
        if(results.length!=0)
            return UserActionWSResponse.success(UserActionWSStatus.GET_USERS_BY_ROLE_MSG, results);
        return UserActionWSResponse.fault(UserActionWSStatus.NO_USERS_BY_ROLE_MSG);
    }

    public UserActionWSResponse deleteUserById(Integer id) {
        boolean result = userDao.deleteById(id);
        Object [] results=userDao.getAll().toArray();
        if(result)
            return UserActionWSResponse.success(UserActionWSStatus.DELETE_USER_MSG, results);
        return UserActionWSResponse.fault(UserActionWSStatus.COULD_NOT_DELETE_USER_MSG);
    }


    public UserActionWSResponse deleteUserByLogin(String login) {
        boolean result = userDao.deleteByLogin(login);
        Object [] results=userDao.getAll().toArray();
        if(result)
            return UserActionWSResponse.success(UserActionWSStatus.DELETE_USER_MSG, results);
        return UserActionWSResponse.fault(UserActionWSStatus.COULD_NOT_DELETE_USER_MSG);
    }

    @Override
    public UserActionWSResponse addUser(User user) {
        Object [] results1=userDao.getAll().toArray();
        userDao.addUser(user);
        Object [] results2=userDao.getAll().toArray();
        if(results2.length-results1.length==1)
            return UserActionWSResponse.success(UserActionWSStatus.ADD_NEW_USER_MSG, results2);
        return UserActionWSResponse.fault(UserActionWSStatus.COULD_NOT_ADD_USER_MSG);
    }

}
