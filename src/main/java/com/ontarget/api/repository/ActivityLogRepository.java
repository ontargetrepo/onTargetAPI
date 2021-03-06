package com.ontarget.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long>{
	
	@Query("select u from ActivityLog u where u.projectId = ?1 or  u.projectId in (select projectId from Project where projectParentId=?1) order by u.activityLogId desc")
	Page<ActivityLog> findActivityLogsByProjectId(Integer projectId, Pageable pageable);

}
