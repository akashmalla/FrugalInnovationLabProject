package DisplayProject;

import javax.persistence.*;

import ProjectManagement.ProjectManagement;

import java.util.*;

public class DisplayProjectService {
	 private EntityManager manager;
	 
	 public DisplayProjectService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public ProjectManagement createUser(int userID, String userName, String password, String typeOfUser) {
    	 ProjectManagement user = new ProjectManagement();
 	    user.setUser_ID(userID);
 	    user.setUserName(userName);
 	    user.setPassword(password);
 	    user.setTypeOfUser(typeOfUser);
 	    manager.persist(user);
 	    return user;
     }
    
    // method to read a record
     public UserRegistration readUser(String userID) {
    	 UserRegistration user = manager.find(UserRegistration.class, userID);
    	 return user;   	 
     }

     // method to read all records
     public List<ProjectManagement> readAll() {
    	 TypedQuery<UserRegistration> query = manager.createQuery("SELECT e FROM UserRecord e", UserRegistration.class);
    	 List<UserRegistration> result =  query.getResultList();

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
    public void deleteUser(int userID) {
    	 UserRegistration user = manager.find(UserRegistration.class, userID);
    	 if (user != null) {
    		 manager.remove(user);
    	 }
    }
}


