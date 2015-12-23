package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.RegistrationRequest;

public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {

	RegistrationRequest findById(Long id);

	RegistrationRequest findByEmail(String email);

    List<RegistrationRequest> findTopByEmailOrderByIdDesc(String email, Pageable pageable);

	List<RegistrationRequest> findTopByEmailAndProjectIdOrderByIdDesc(String email, Integer projectId, Pageable pageable);

	RegistrationRequest findByRegistrationToken(String token);

	RegistrationRequest findByUserId(Integer userId);

	List<RegistrationRequest> findByStatus(String status);

	@Query("select r from RegistrationRequest r where r.status = 'PENDING' and (r.projectId is null or r.projectId=0)")
	List<RegistrationRequest> getPendingRegistrationRequests();

}
