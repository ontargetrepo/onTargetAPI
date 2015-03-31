package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.ForgotPasswordRequestRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ForgotPasswordRequest;
import com.ontarget.entities.User;
import com.ontarget.util.DateFormater;

@Repository("userJpaDAOImpl")
public class UserJpaDAOImpl extends BaseGenericDAOImpl<UserDTO> implements UserDAO {
	@Resource
	private UserRepository userRepository;
	@Resource
	private ForgotPasswordRequestRepository forgotPasswordRequestRepository;

	@Override
	public UserDTO insert(UserDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserDTO read(long id) {
		User user = userRepository.findByUserId((int) id);

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUserName());
		return userDTO;
	}

	@Override
	public boolean update(UserDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserDTO getUser(Integer userId) throws Exception {
		User user = userRepository.findByUserId(userId);
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUserName());
		userDTO.setUserId((int) userId);
		userDTO.setAccountStatus(user.getAccountStatus());
		userDTO.setUserStatus(user.getUserStatus());
		userDTO.setUserTypeId(user.getUserType().getUserTypeId());
		userDTO.setDiscipline(user.getDiscipline());
		userDTO.setPassword(user.getPassword());
		userDTO.setSalt(user.getSalt());
		return userDTO;
	}

	@Override
	public int saveForgotPasswordRequest(int userId, String forgotPasswordToken) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
		forgotPasswordRequest.setUserId(userId);
		forgotPasswordRequest.setForgotPasswordToken(forgotPasswordToken);
		forgotPasswordRequest.setStatus(OnTargetConstant.FORGOT_PASSWORD.FORGOT_PASSWORD_ACTIVE);
		forgotPasswordRequest.setTsExpiry(DateFormater.addDays(new Date(), 1));
		forgotPasswordRequestRepository.save(forgotPasswordRequest);

		return forgotPasswordRequest.getId().intValue();
	}

	@Override
	public Map<String, Object> getForgotPasswordRequest(String forgotPasswordToken) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = forgotPasswordRequestRepository
				.findExpiredRequestByToken(forgotPasswordToken);
		if (forgotPasswordRequest != null) {
			Map<String, Object> forgotPwdMap = new HashMap<>();
			forgotPwdMap.put("user_id", forgotPasswordRequest.getUserId());
			return forgotPwdMap;
		}
		return null;
	}

	@Override
	public int getForgotPasswordRequestCount(String forgotPasswordToken) throws Exception {
		long count = forgotPasswordRequestRepository.countExpiredRequestByToken(forgotPasswordToken);
		return (int) count;
	}

	@Override
	public boolean expireForgotPasswordRequest(String token) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = forgotPasswordRequestRepository.findExpiredRequestByToken(token);
		forgotPasswordRequest.setStatus(OnTargetConstant.FORGOT_PASSWORD.FORGOT_PASSWORD_EXPIRED);
		forgotPasswordRequestRepository.save(forgotPasswordRequest);
		return true;
	}

}