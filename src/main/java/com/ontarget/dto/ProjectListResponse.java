package com.ontarget.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ontarget.bean.ProjectDTO;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectListResponse extends OnTargetResponse {

	private static final long serialVersionUID = 1L;
	private ProjectDTO mainProject;
	private List<ProjectDTO> projects;

	public ProjectDTO getMainProject() {
		return mainProject;
	}

	public void setMainProject(ProjectDTO mainProject) {
		this.mainProject = mainProject;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

}
