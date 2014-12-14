package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserRegistration;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;

import java.util.Set;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

    public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception;

    public OnTargetResponse updateUserProfileAndContactInfo(UserProfileRequest request) throws Exception;

    public boolean changeUserPassword(long userId, String password) throws Exception;

    public boolean saveRegistration(long projectId, String firstName, String lastName, String email, String tokenId) throws Exception;

    public Contact getContact(long userId) throws Exception;

    public UserRegistration getRegistration(String token) throws Exception;

    public Company getCompanyInfoByUser(int userId) throws Exception;

    public String getRandomSafetyUserInfo(long userId) throws Exception;

    public Set<Long> getDisciplineByUser(long userId) throws Exception;
}
