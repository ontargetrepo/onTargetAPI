package com.ontarget.api.jpa.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.repository.RegistrationRequestRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entities.User;
import com.ontarget.entities.UserType;
import com.ontarget.request.bean.UserRegistrationInfo;
import com.ontarget.util.Security;

@Repository("userRegistrationJpaDAOImpl")
public class UserRegistrationJpaDAOImpl implements com.ontarget.api.dao.UserRegistrationDAO {

	@Resource
	private RegistrationRequestRepository registrationRequestRepository;
	@Resource
	private UserRepository userRepository;

	@Override
	public int saveRegistrationInvitation(int projectId, String firstName, String lastName, String email, String tokenId,
			String accountStatus) throws Exception {

		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setRegistrationToken(tokenId);
		registrationRequest.setFirstName(firstName);
		registrationRequest.setLastName(lastName);
		registrationRequest.setEmail(email);
		registrationRequest.setProjectId(projectId);
		registrationRequest.setStatus(accountStatus);
		registrationRequestRepository.save(registrationRequest);
		return 1;
	}

	@Override
	public UserRegistration getInvitationRegistration(String tokenId) throws Exception {

		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(tokenId);

		UserRegistration userRegistration = new UserRegistration();
		Object d = null;
		userRegistration.setFirstName(registrationRequest.getFirstName());
		userRegistration.setLastName(registrationRequest.getLastName());
		userRegistration.setEmail(registrationRequest.getEmail());
		userRegistration.setStatus(registrationRequest.getStatus());
		userRegistration.setRegistrationToken(tokenId);
		d = registrationRequest.getProjectId();
		if (d != null) {
			if (d instanceof Long)
				userRegistration.setProjectId((Long) d);
			else if (d instanceof Integer) {
				userRegistration.setProjectId((Integer) d);
			} else
				userRegistration.setProjectId(Long.parseLong((String) d));
		}
		d = registrationRequest.getTsCreate();
		if (d != null) {
			userRegistration.setTsCreate(((Timestamp) d).getTime());
		}
		return userRegistration;
	}

	@Override
	public void createNewuser(UserRegistrationInfo registration, String status, int userId) throws Exception {

		String password = registration.getPassword();
		String salt = Security.generateSecureSalt();
		String hashedPassword = Security.encodePassword(password, salt);

		User user = new User();
		user.setUserName(registration.getEmail());
		user.setUserType(new UserType(1));
		user.setPassword(hashedPassword);
		user.setSalt(salt);
		user.setDiscipline(registration.getDiscipline());
		user.setUserStatus(OnTargetConstant.USER_STATUS.ACTIVE);
		user.setNumberOfLogin(1);
		user.setModifiedDate(new Date());
		user.setAccountStatus(status);
		user.setUserId(userId);

		userRepository.save(user);

	}

	@Override
	public int updateRegistrationRequestUserId(int userId, String tokenId) throws Exception {

		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(tokenId);
		registrationRequest.setUserId(userId);
		registrationRequestRepository.save(registrationRequest);
		return 1;
	}

	@Override
	public int activateAccount(int userId) throws Exception {
		registrationRequestRepository.activeUserAccount("ACTIVE", userId);
		return 1;
	}

	@Override
	public UserRegistration getInvitationRegistrationByUser(int userId) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findByUserId(userId);

		UserRegistration userRegistration = new UserRegistration();
		Object d = null;
		userRegistration.setFirstName(registrationRequest.getFirstName());
		userRegistration.setLastName(registrationRequest.getLastName());
		userRegistration.setEmail(registrationRequest.getEmail());
		userRegistration.setStatus(registrationRequest.getStatus());
		d = registrationRequest.getProjectId();
		if (d != null) {
			if (d instanceof Long)
				userRegistration.setProjectId((Long) d);
			else if (d instanceof Integer) {
				userRegistration.setProjectId((Integer) d);
			} else
				userRegistration.setProjectId(Long.parseLong((String) d));
		}
		d = registrationRequest.getTsCreate();
		if (d != null) {
			userRegistration.setTsCreate(((Timestamp) d).getTime());
		}

		return userRegistration;

	}

}