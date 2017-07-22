package com.iresponse.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iresponse.dao.ProjectDao;
import com.iresponse.model.Project;

@Service("ProjectService")
public class ProjectService implements IProjectService {
	@Resource
	private ProjectDao myprojectdao;
	
	@Override
	public Integer getProjectsCount() {
		return myprojectdao.getProjectsCount();
	}

	@Override
	public Project getProjectById(int id) {
		return myprojectdao.getProjectById(id);
	}

	@Override
	public List<Project> getProjectsJson(Map<String, Object> param) {
		return myprojectdao.getProjectsJson(param);
	}

	@Override
	public List<Project> getProjectsList(int offset, int limit) {
		return myprojectdao.getProjectsList(offset, limit);
	}

	@Override
	public void addProject(Project obj) {
		myprojectdao.addProject(obj);
		
	}

}
