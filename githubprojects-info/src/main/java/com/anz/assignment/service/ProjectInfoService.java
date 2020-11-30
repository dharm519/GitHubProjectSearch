package com.anz.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anz.assignment.exception.ServiceException;
import com.anz.assignment.model.ProjectInfo;
import com.anz.assignment.model.Response;
import com.anz.assignment.util.ProjectInfoUtil;

@Service
public class ProjectInfoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.url}")
	private String baseUrl;
	
	public List<ProjectInfo> getAllGithubProjects(String language) throws ServiceException {
		Response response = null;
		try {
			response = restTemplate.getForObject(baseUrl+"{language}",
	                 Response.class, language);	
		}catch (Exception ex) {
			  throw new ServiceException("Bad Reuqest");
		}	
		return ProjectInfoUtil.convertResponseToProjectInfo(response);
	}
	
	public List<ProjectInfo> getAllGithubProjects(String language, String pageNo) throws ServiceException {
		Response response = null;
		try {
			int page = Integer.parseInt(pageNo);
			response = restTemplate.getForObject(baseUrl+"{language}"+"&page="+"{pageNo}",
	                 Response.class, language, pageNo);
		}catch (NumberFormatException ex) {
			throw new ServiceException("Incorrect Page Number :"+pageNo);
		}catch (Exception ex) {
			throw new ServiceException("Bad Reuqest");
		}
		return ProjectInfoUtil.convertResponseToProjectInfo(response);
	}

}
