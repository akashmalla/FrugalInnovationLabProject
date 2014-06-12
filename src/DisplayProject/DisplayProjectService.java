package DisplayProject;

import javax.persistence.*;

import ProjectManagement.ProjectManagement;
import UserRegistration.UserRegistration;

import java.util.*;

public class DisplayProjectService {
	 private EntityManager manager;
	 
	 public DisplayProjectService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public DisplayProject createFile(int fileID, String fileName, int level, String path) {
    	 DisplayProject project = new DisplayProject();
 	    project.setFileID(fileID);
 	    project.setfileName(fileName);
 	    project.setfileLevel(level);
 	    project.setfilePath(path);
 	    manager.persist(project);
 	    return project;
     }
    
    // method to read a record
     public DisplayProject readFile(String fileID) {
    	 DisplayProject project = manager.find(DisplayProject.class, fileID);
    	 return project;   	 
     }

     // method to read all records
     public List<DisplayProject> readAll() {
    	 TypedQuery<DisplayProject> query = manager.createQuery("SELECT e FROM files e", DisplayProject.class);
    	 List<DisplayProject> result =  query.getResultList();

    	 return result;   	 
     }
     
    // method to update a record
     public UserRegistration updateUser(int userID, String userName, String password, String typeOfUser) {
    	 UserRegistration user = manager.find(UserRegistration.class, userID);
    	 if (user != null) {
    		 user.setUser_ID(userID);
    		 user.setUserName(userName);
    		 user.setPassword(password);
    		 user.setTypeOfUser(typeOfUser);
    	 }
    	 //manager.merge(user);
    	 return user;
     }

    // method to delete a record
    public void deleteFile(int fileID) {
    	 UserRegistration file = manager.find(UserRegistration.class, fileID);
    	 if (file != null) {
    		 manager.remove(file);
    	 }
    }
}


