package com.anz.assignment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anz.assignment.exception.AuthenticationException;
import com.anz.assignment.exception.ServiceException;
import com.anz.assignment.model.AuthenticationRequest;
import com.anz.assignment.model.AuthenticationResponse;
import com.anz.assignment.model.ProjectInfo;
import com.anz.assignment.service.CustomUserDetailsService;
import com.anz.assignment.service.ProjectInfoService;
import com.anz.assignment.util.JwtUtil;


@RestController
@RequestMapping("/api")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoService projectInfoSvc;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@RequestMapping(method = RequestMethod.GET, value = "/allProjectInfo/{language}")
	public List<ProjectInfo> getAllProjects(@PathVariable String language) throws ServiceException{
		return projectInfoSvc.getAllGithubProjects(language);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allProjectInfo/{language}/{pageNo}")
	public List<ProjectInfo> getAllProjects(@PathVariable String language, @PathVariable String pageNo) throws ServiceException{
		return projectInfoSvc.getAllGithubProjects(language, pageNo);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException{
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
							);
		}catch (BadCredentialsException ex) {
			throw new AuthenticationException("Incorrect username or password...");
		}
		final UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
