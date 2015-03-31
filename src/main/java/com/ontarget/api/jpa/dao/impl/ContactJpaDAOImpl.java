package com.ontarget.api.jpa.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.repository.ContactRepository;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.User;

@Repository("contactJpaDAOImpl")
public class ContactJpaDAOImpl implements ContactDAO {
	@Resource
	private ContactRepository contactRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addContactInfo(Contact contactDTO) throws Exception {
		com.ontarget.entities.Contact contact = new com.ontarget.entities.Contact();
		contact.setUser(new User(contactDTO.getUser().getUserId()));
		contact.setCompanyInfo(new CompanyInfo(contactDTO.getCompany().getCompanyId()));
		contact.setFirstName(contactDTO.getFirstName());
		contact.setLastName(contactDTO.getLastName());
		contact.setTitle(contactDTO.getTitle());
		contact.setContactImage(contactDTO.getUserImagePath());
		contact.setCreatedDate(new Date());
		contact.setCreatedBy("0");
		contact.setModifiedBy("0");
		contact.setModifiedDate(new Date());
		contact.setContactStatus("ACTIVE");
		contactRepository.save(contact);

		return true;
	}

	@Override
	public Map<String, Object> getContactDetail(int userId) throws Exception {

		List<com.ontarget.entities.Contact> contacts = contactRepository.findByUserId(userId);

		if (contacts == null || contacts.isEmpty()) {
			throw new Exception("User does not exist");
		}

		Map<String, Object> contactMap = new HashMap<String, Object>();
		com.ontarget.entities.Contact contact = contacts.get(0);

		contactMap.put("contact_company_id", contact.getCompanyInfo().getCompanyId());

		return contactMap;
	}

	@Override
	public boolean updateContactInfo(Contact contactDTO) throws Exception {
		List<com.ontarget.entities.Contact> contactList = contactRepository.findByUserId(contactDTO.getUser().getUserId());
		if (contactList == null || contactList.isEmpty()) {
			throw new Exception("User " + contactDTO.getUser().getUserId() + " does not exist");
		}
		com.ontarget.entities.Contact contact = contactList.get(0);
		contact.setFirstName(contactDTO.getFirstName());
		contact.setLastName(contactDTO.getLastName());
		contact.setTitle(contactDTO.getTitle());
		contact.setContactImage(contactDTO.getUserImagePath());
		contactRepository.save(contact);
		return true;
	}

	@Override
	public Contact getContact(int userId) throws Exception {
		List<com.ontarget.entities.Contact> contactList = contactRepository.findByUserId(userId);
		if (contactList == null || contactList.isEmpty()) {
			throw new Exception("User " + userId + " does not exist");
		}

		com.ontarget.entities.Contact contactObj = contactList.get(0);
		Contact contact = new Contact();
		contact.setContactId(contactObj.getContactId());
		UserDTO user = new UserDTO();
		user.setUserId((int) userId);
		contact.setUser(user);
		contact.setFirstName(contactObj.getFirstName());
		contact.setLastName(contactObj.getLastName());
		contact.setTitle(contactObj.getTitle());
		contact.setUserImagePath(contactObj.getContactImage());
		if (!contactObj.getEmailList().isEmpty()) {
			contact.setEmail(contactObj.getEmailList().get(0).getEmailAddress());
		}
		return contact;
	}

	@Override
	public boolean saveUserImagePath(int userId, String path, long modifier) throws Exception {
		List<com.ontarget.entities.Contact> contact = contactRepository.findByUserId(userId);
		com.ontarget.entities.Contact contactObj = contact.get(0);
		contactObj.setModifiedBy(String.valueOf(modifier));
		contactObj.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		contactObj.setContactImage(path);
		contactRepository.save(contactObj);
		return true;
	}

}