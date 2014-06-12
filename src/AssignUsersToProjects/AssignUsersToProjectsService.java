package AssignUsersToProjects;

import javax.persistence.*;

import UserRegistration.UserRegistration;

import java.util.*;

public class AssignUsersToProjectsService {
	 private EntityManager manager;
	 
	 public AssignUsersToProjectsService(EntityManager manager) {
		 this.manager = manager;
	 }
    
    // method to read a record
     public AssignUsersToProjects readUserByUserID(String userID) {
    	 AssignUsersToProjects user = manager.find(AssignUsersToProjects.class, new Integer(userID));
    	 System.out.println(user);
    	 return user;   	 
     }

     // method to read all records
     public List<AssignUsersToProjects> readAll() {
    	 TypedQuery<AssignUsersToProjects> query = manager.createQuery("SELECT e FROM UserRecord e", AssignUsersToProjects.class);
    	 List<AssignUsersToProjects> result =  query.getResultList();
    	 return result;   	 
     }
     
     // method to create a new record
     /*public AssignUsersToProjects createUserInstance(int userID, String firstName, String lastName, String typeOfUser) {
    	AssignUsersToProjects user = new AssignUsersToProjects();
 	    user.setUser_ID(userID);
 	    user.setFirstName(firstName);
 	    user.setLastName(lastName);
 	    user.settypeOfUser(typeOfUser);
 	    return user;
     }*/
     
     public int size(){
    	 return 4;
     }
}

