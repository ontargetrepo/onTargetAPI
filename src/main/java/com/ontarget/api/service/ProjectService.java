package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.dto.*;
import com.ontarget.request.bean.ProjectRequest;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectService {

    public OnTargetResponse addProject(ProjectRequest request) throws Exception;

    public OnTargetResponse updateProject(ProjectRequest request) throws Exception;

    public ProjectResponse getProjectDetail(int projectId) throws Exception;

    public ProjectListResponse getProjectsByCompany(int companyId, int userId) throws Exception;

    public List<Company> getCompanyByProject(int projectId) throws Exception;

    public ProjectListResponse getProjectsByUser(int userId) throws Exception;

    public ProjectMemberListResponse getProjectMembers(int projectId) throws Exception;

    public ProjectInfo getProject(int projectId) throws Exception;

    public ProjectInfo getProjectTree(int projectId) throws Exception;
    
    public ProjectListResponse getUserProjectDetails(int userId) throws Exception;
    
    public boolean deleteProject(int projectId,int userId);
}
