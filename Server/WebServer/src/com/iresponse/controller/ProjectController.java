package com.iresponse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iresponse.model.Project;
import com.iresponse.service.IProjectService;

//@RequestMapping("/next") //指定下级
@Controller
public class ProjectController {
	@Resource
    private IProjectService projectService;
 
    @RequestMapping("/getcount.do")
    public @ResponseBody Integer getProjectsCount() {
    	return projectService.getProjectsCount();
    }
    
    @RequestMapping("/getbyid.do")
    public @ResponseBody Project getProjectById(int id) {
        Project project = this.projectService.getProjectById(id);
        return project;
    }
    
    @RequestMapping("/getjson.do")
    public @ResponseBody List<Project> getProjectsJson(HttpServletRequest request) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("sort", request.getParameter("sort"));
    	map.put("order", request.getParameter("order"));
    	map.put("offset", request.getParameter("offset"));
    	map.put("limit", request.getParameter("limit"));
    	
    	List<Project> list = projectService.getProjectsJson(map);
        return list;
    }
    
    @RequestMapping("/getlist.do")
    public @ResponseBody List<Project> getProjectsList(@RequestParam(value="offset", required=true) int offset,@RequestParam(value="limit", required=true) int limit) {
    	List<Project> list = projectService.getProjectsList(offset,limit);
        return list;
    }
    
    @RequestMapping("/add.do")
    public @ResponseBody String addProject(@RequestBody Project obj) {
        projectService.addProject(obj);
        
        return "{\"code\":1,\"url\":\"index.html\"}"; 
    }
}
