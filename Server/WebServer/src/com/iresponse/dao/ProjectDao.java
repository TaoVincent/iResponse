package com.iresponse.dao;

import org.apache.ibatis.annotations.Param; 

import java.util.List;
import java.util.Map;

import com.iresponse.model.Project;

public interface ProjectDao {
	Integer getProjectsCount();
	Project getProjectById(int id);
	List<Project> getProjectsJson(Map<String,Object> param);
	List<Project> getProjectsList(@Param("offset") int offset,@Param("limit") int limit);
	void addProject(Project obj);
}
