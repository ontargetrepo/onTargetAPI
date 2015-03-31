package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.repository.CompanyInfoRepository;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.CompanyInfo;

@Repository("companyJpaDAOImpl")
public class CompanyJpaDAOImpl implements CompanyDAO {
	@Resource
	private CompanyInfoRepository companyInfoRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addCompanyInfo(Company company) throws Exception {
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCompanyId(company.getCompanyId());
		companyInfo.setCompanyName(company.getCompanyName());
		AddressDTO addressDTO = company.getAddress();
		companyInfo.setAddress1(addressDTO.getAddress1());
		companyInfo.setAddress2(addressDTO.getAddress2());
		companyInfo.setCity(addressDTO.getCity());
		companyInfo.setState(addressDTO.getState());
		companyInfo.setZipcode(addressDTO.getZip());
		companyInfo.setCountry(addressDTO.getCountry());
		companyInfo.setWebsite(company.getWebsite());
		companyInfo.setStatus(OnTargetConstant.CompanyStatus.STATUS);
		companyInfoRepository.save(companyInfo);
		return companyInfo.getCompanyId();
	}

	@Override
	public Company getCompany(int companyId) throws Exception {
		CompanyInfo companyInfo = companyInfoRepository.findByCompanyId(companyId);
		Company company = new Company();
		company.setCompanyName(companyInfo.getCompanyName());
		return company;
	}

	@Override
	public Map<String, Object> getCompanyByUser(int userId) throws Exception {
		return jdbcTemplate.queryForMap(OnTargetQuery.GET_CONTACT_BY_USER, new Object[] { userId });
	}

	@Override
	public List<Company> getCompanyList() throws Exception {
		List<CompanyInfo> companyList = companyInfoRepository.findAll();

		List<Company> companies = new ArrayList<>();

		if (companyList != null && !companyList.isEmpty()) {
			for (CompanyInfo companyInfo : companyList) {
				Company company = new Company();
				company.setCompanyId(companyInfo.getCompanyId());
				company.setCompanyName(companyInfo.getCompanyName());
				company.setWebsite(companyInfo.getWebsite());
				company.setCompanyTypeId(companyInfo.getCompanyType().getCompanyTypeId());

				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setAddress1(companyInfo.getAddress1());
				addressDTO.setAddress2(companyInfo.getAddress2());
				addressDTO.setCity(companyInfo.getCity());
				addressDTO.setCountry(companyInfo.getCountry());
				addressDTO.setState(companyInfo.getState());
				addressDTO.setZip(companyInfo.getZipcode());

				company.setAddress(addressDTO);

				companies.add(company);
			}
		}

		return companies;
	}

}
