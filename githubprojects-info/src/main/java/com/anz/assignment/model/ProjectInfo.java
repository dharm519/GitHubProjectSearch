package com.anz.assignment.model;

public class ProjectInfo {
	private String projectId;
	private String name;
	private String url;
	private String ownerLogin;
	
	public ProjectInfo() {
		
	}
	
	public ProjectInfo(String projectId, String name, String url, String ownerLogin) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.url = url;
		this.ownerLogin = ownerLogin;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOwnerLogin() {
		return ownerLogin;
	}

	public void setOwnerLogin(String ownerLogin) {
		this.ownerLogin = ownerLogin;
	}
	
	

}
