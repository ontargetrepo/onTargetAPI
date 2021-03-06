package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.ProjectBIMFileDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.service.ProjectBIMFileService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ProjectBimFileDTO;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileComment;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.ProjectBIMFileCommentRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;
import com.ontarget.response.bean.ProjectFileCommentResponse;
import com.ontarget.util.ProjectBimFileUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Service("projectBIMFileServiceImpl")
public class ProjectBIMFileServiceImpl implements ProjectBIMFileService {

	private Logger logger = Logger.getLogger(ProjectBIMFileServiceImpl.class);

	@Autowired
	@Qualifier("projectBIMFileJPADAOImpl")
	private ProjectBIMFileDAO projectBIMFileDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Override
	public GetBIMResponse getBIMPoids(Long projectId) throws Exception {
		logger.debug("Getting BIM poids :" + projectId);
		List<ProjectBimFile> poids = projectBIMFileDAO.getBIMPoids(projectId);
		GetBIMResponse response = new GetBIMResponse();
		response.setProjectId(projectId);
		List<ProjectBimFileDTO> poidDtos = new LinkedList<>();
		if (poids != null && poids.size() > 0) {
			for (ProjectBimFile projectBimFile : poids) {
				ProjectBimFileDTO dto = new ProjectBimFileDTO();
				dto.setProjectBimFileId(projectBimFile.getProjectBimFileId());
				dto.setCreatedDate(projectBimFile.getCreatedDate());
				dto.setPoid(projectBimFile.getBimPoid().longValue());
                dto.setBimThumbnailPath(projectBimFile.getBimThumbnailFileLocation());
				Contact c = contactDAO.getContact(projectBimFile.getCreatedBy().getUserId());
				dto.setCreatedByContact(c);
				poidDtos.add(dto);
			}
		}
		response.setPoids(poidDtos);
		return response;
	}

	@Override
	@Transactional
	public boolean saveProjectBIMFile(SaveBIMRequest request) throws Exception {
		logger.debug("Saving project bim file with poid: " + request.getPoid());
		return projectBIMFileDAO.saveBIMPoid(ProjectBimFileUtil.getProjectBimEnitityFromBIMRequest(request));
	}

	@Override
	@Transactional
	public boolean deleteProjectBIMFile(DeleteBIMRequest request) throws Exception {
		logger.debug("deleting project bim file with id: " + request.getProjectBimFileId());
		return projectBIMFileDAO.deleteBIMPoid(request.getProjectBimFileId(), request.getBaseRequest().getLoggedInUserId());
	}

	@Override
	@Transactional
	public boolean updateBimThumbnailPath(UpdateBIMThumbnailPathRequest request) throws Exception {
		logger.debug("updating project bim thumbnail path with id: " + request.getProjectBimFileId());
		return projectBIMFileDAO.updateThumbnailPath(request.getProjectBimFileId(), request.getBimThumbnailPath(), request.getBaseRequest()
				.getLoggedInUserId());
	}

	@Override
	@Transactional
	public boolean addUpdateComment(ProjectBIMFileCommentRequest request) throws Exception {
		logger.debug("Saving comment to bim file: " + request.getProjectBIMFileId());
		return projectBIMFileDAO.saveComment(ProjectBimFileUtil.getProjectBimFileCommentEntityFromCommentRequest(request));
	}

	@Override
	@Transactional
	public boolean deleteComment(Integer commentId) throws Exception {
		logger.debug("Deleting comment id: " + commentId);
		return projectBIMFileDAO.deleteComment(commentId);
	}

	@Override
	public List<ProjectBIMFileCommentDTO> getCommentList(Integer projectBIMFileId) throws Exception {
		logger.debug("Get comment list for file id: " + projectBIMFileId);
		List<ProjectBimFileComment> commentList = projectBIMFileDAO.getCommentsByFileId(projectBIMFileId);
		return ProjectBimFileUtil.getBIMFileCommentDTOListFromEntity(commentList, taskDAO);
	}
}
