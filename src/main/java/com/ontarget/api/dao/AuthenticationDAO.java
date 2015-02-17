package com.ontarget.api.dao;

import com.ontarget.bean.UserDTO;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.request.bean.SignInRequestBean;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationDAO {

    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception;

    public boolean logout(String username) throws  Exception;

    public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception;

    public List<UserRegistrationRequest> getUserRegistrationPendingRequests() throws Exception;

    public boolean approvePendingRegistrationRequest(UserRegistrationRequest req) throws Exception;

    public boolean approveUserRequest(int userRequestId) throws Exception;

    public boolean createUser(UserRegistrationRequest request) throws Exception;
    
    public UserDTO getUserSignInInfo(SignInRequestBean signInRequest) throws Exception;

    public UserDTO getUserInfoByUsername(UserDTO user) throws Exception;

    public boolean changePassword(long userId, String password, String salt) throws Exception;

    public UserDTO getUserInfoById(long userId) throws Exception;
}
