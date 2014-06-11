package AssignUsersToProjects;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the UserRecord database table.
 * 
 */
@Entity(name = "userlist")
public class AssignUsersToProjects implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column
	private int user_ID;

	@Column(name="first_name")
	private String firstname;

	@Column(name="last_name")
	private String lastname;

	@Column(name="type_of_user")
	private String typeOfUser;
	
	//public AssignUsersToProjects() {
	//}

	public int getUser_ID() {
		return this.user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	
	public String getFirstName() {
		return this.firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String gettypeOfUser() {
		return this.typeOfUser;
	}
	
	public void settypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
	   // return number of columns in the table
	   public int getNumberOfColumns() {
		   return 4;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return Integer.toString(getUser_ID());
		   else if (i == 1)
			   return getFirstName();
		   else if (i == 2) 
			   return getLastName();
		   else if (i == 3)
			   return gettypeOfUser();
		   else
			   throw new Exception("Error: invalid column index in UserRecord table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "user_ID";
		   else if (i == 1)
			   colName = "first_name";
		   else if (i == 2)
			   colName = "last_name";
		   else if (i == 3)
			   colName = "type_of_user";
		   else 
			   throw new Exception("Access to invalid column number in UserRecord table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   this.user_ID = Integer.parseInt((String) value);
		   else if (i == 1) 
			   this.firstname = (String) value;
		   else if (i == 2) 
			   this.lastname =  (String) value;
		   else if (i == 3)
			   this.typeOfUser = (String) value;
		   else
			   throw new Exception("Error: invalid column index in UserRecord table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "CourseList [User ID =" + user_ID + ", "
	    	    + " First Name =" + firstname + ","
	    	    + " Last Name =" + lastname + ","
	    	    + " Type Of User =" + typeOfUser + ","
	        + "]";
	  }
}
