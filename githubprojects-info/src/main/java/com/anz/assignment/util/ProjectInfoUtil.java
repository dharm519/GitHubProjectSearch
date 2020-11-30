package com.anz.assignment.util;

import java.util.ArrayList;
import java.util.List;

import com.anz.assignment.model.Items;
import com.anz.assignment.model.ProjectInfo;
import com.anz.assignment.model.Response;

public class ProjectInfoUtil {
	
	public static List<ProjectInfo> convertResponseToProjectInfo(Response response){
		 List<ProjectInfo> projectInfoList = new ArrayList<ProjectInfo>();
		 for (Items item : response.getItems()) {
			 ProjectInfo projectInfo = new ProjectInfo();
			 projectInfo.setProjectId(item.getId());
			 projectInfo.setName(item.getName());
			 projectInfo.setOwnerLogin(item.getOwner().getLogin());
			 projectInfo.setUrl(item.getHtml_url());
			 projectInfoList.add(projectInfo);
		 }
		 return projectInfoList;
	}

}
