package ProjectManagement;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserRecord database table.
 * 
 */
@Entity(name = "ProjectInformation")
public class ProjectManagement implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column
	private int project_ID;

	@Column(name="project_name")
	private String projectName;

	@Column(name="project_category")
	private String projectCategory;

	@Column(name="project_status")
	private String projectStatus;

	@Column(name="project_by_user")
	private String projectByUser;
	
	public ProjectManagement() {
	}
	
	public int getProject_ID() {
		return project_ID;
	}


	public void setProject_ID(int project_ID) {
		this.project_ID = project_ID;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectCategory() {
		return projectCategory;
	}


	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}


	public String getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}


	public String getProjectByUser() {
		return projectByUser;
	}


	public void setProjectByUser(String projectByUser) {
		this.projectByUser = projectByUser;
	}


	// return number of columns in the table
	   public int getNumberOfColumns() {
		   return 5;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return Integer.toString(getProject_ID());
		   else if (i == 1)
			   return getProjectName();
		   else if (i == 2) 
			   return getProjectCategory();
		   else if (i == 3)
			   return getProjectStatus();
		   else if (i == 4)
			   return getProjectByUser();
		   else
			   throw new Exception("Error: invalid column index in ProjectInformation table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "project_ID";
		   else if (i == 1)
			   colName = "project_name";
		   else if (i == 2)
			   colName = "project_category";
		   else if (i == 3)
			   colName = "project_status";
		   else if (i == 4)
			   colName = "project_by_user";
		   else 
			   throw new Exception("Access to invalid column number in ProjectInformation table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   project_ID = Integer.parseInt((String) value);
		   else if (i == 1) 
			   projectName = (String) value;
		   else if (i == 2) 
			   projectCategory =  (String) value;
		   else if (i == 3)
			   projectStatus = (String) value;
		   else if (i == 4)
			   projectByUser = (String) value;
		   else
			   throw new Exception("Error: invalid column index in ProjectInformation table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "CourseList [Project ID =" + project_ID + ", "
	    	    + " Project Name =" + projectName + ","
	    	    + " Project Category =" + projectCategory + ","
	    	    + " Project Status =" + projectStatus + ","
	    	    + " Project By User =" + projectByUser + ","
	        + "]";
	  }
}

