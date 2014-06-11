package ProjectManagement;

import javax.persistence.*;
import java.util.*;

public class ProjectManagementService {
	 private EntityManager manager;
	 
	 public ProjectManagementService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public ProjectManagement createProject(int projectID, String projectName, String projectCategory, String projectStatus, String projectByUser) {
    	ProjectManagement project = new ProjectManagement();
 	    project.setProject_ID(projectID);
 	    project.setProjectName(projectName);
 	    project.setProjectCategory(projectCategory);
 	    project.setProjectStatus(projectStatus);
 	    project.setProjectByUser(projectByUser);
 	    manager.persist(project);
 	    return project;
     }
    
    // method to read a record
     public ProjectManagement readProject(String projectID) {
    	 ProjectManagement project = manager.find(ProjectManagement.class, projectID);
    	 return project;   	 
     }

     // method to read all records
     public List<ProjectManagement> readAll() {
    	 TypedQuery<ProjectManagement> query = manager.createQuery("SELECT e FROM ProjectInformation e", ProjectManagement.class);
    	 List<ProjectManagement> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public ProjectManagement updateProject(int projectID, String projectName, String projectCategory, String projectStatus, String projectByUser) {
    	 ProjectManagement project = manager.find(ProjectManagement.class, projectID);
    	 if (project != null) {
    		 project.setProject_ID(projectID);
    		 project.setProjectName(projectName);
    		 project.setProjectCategory(projectCategory);
    		 project.setProjectStatus(projectStatus);
    		 project.setProjectByUser(projectByUser);
    	 }
    	 return project;
     }

    // method to delete a record
    public void deleteProject(int projectID) {
    	 ProjectManagement project = manager.find(ProjectManagement.class, projectID);
    	 if (project != null) {
    		 manager.remove(project);
    	 }
    }
}

