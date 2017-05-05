package com.epam.web.service;

import com.epam.model.User;
import com.epam.web.model.UserActionWSResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

    @WebMethod
    public UserActionWSResponse login(@WebParam(partName = "login") String login,
                                      @WebParam(partName = "password") String password);

    @WebMethod
    public UserActionWSResponse getRole(@WebParam(partName = "id") Integer id);

    @WebMethod
    public UserActionWSResponse showAllUsers();

    @WebMethod
    public UserActionWSResponse ShowUsersByRole(@WebParam(partName = "role") String role);

    @WebMethod
    public UserActionWSResponse deleteUserById(@WebParam(partName = "userId") Integer id);

    @WebMethod
    public UserActionWSResponse deleteUserByLogin(@WebParam(partName = "login") String login);
    @WebMethod
    public UserActionWSResponse addUser(@WebParam(partName = "user") User user);

}
