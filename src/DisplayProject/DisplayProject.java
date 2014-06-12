package DisplayProject;

import java.io.Serializable;

import javax.persistence.*;

import ProjectManagement.ProjectManagement;


/**
 * The persistent class for the UserRecord database table.
 * 
 */
//@Entity(name = "UserRecord")
public class DisplayProject implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column
	private int file_id;

	@Column(name="file_name")
	private String fileName;

	@Column(name="file_level")
	private int fileLevel;

	@Column(name="file_path")
	private String filePath;
	
	@Column(name="project_id")
	private String projectID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="project_id")
	private ProjectManagement project_ID;

	public DisplayProject() {
	}
	
	public int getFileID() {
		return this.file_id;
	}
	
	public void setFileID(int file_id){
		this.file_id = file_id;
	}

	public String getfileName() {
		return this.fileName;
	}
	
	public void setfileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getfileLevel() {
		return this.fileLevel;
	}

	public void setfileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public String getfilePath() {
		return this.filePath;
	}

	public void setfilePath(String filePath) {
		this.filePath = filePath;
	}


	
	   // return number of columns in the table
	   public int getNumberOfColumns() {
		   return 4;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return Integer.toString(getFileID());
		   else if (i == 1)
			   return getfileName();
		   else if (i == 2) 
			   return Integer.toString(getfileLevel());
		   else if (i == 3)
			   return getfilePath();
		   else
			   throw new Exception("Error: invalid column index in UserRecord table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "File_ID";
		   else if (i == 1)
			   colName = "File_Name";
		   else if (i == 2)
			   colName = "File_level";
		   else if (i == 3)
			   colName = "File_Path";
		   else 
			   throw new Exception("Access to invalid column number in UserRecord table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   file_id = Integer.parseInt((String) value);
		   else if (i == 1) 
			   fileName = (String) value;
		   else if (i == 2) 
			   fileLevel =  Integer.parseInt((String) value);
		   else if (i == 3)
			   filePath = (String) value;
		   else
			   throw new Exception("Error: invalid column index in UserRecord table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "FileList [Fiel ID =" + file_id + ", "
	    	    + " File Name =" + fileName + ","
	    	    + " File Level =" + fileLevel + ","
	    	    + " File Path =" + filePath + ","
	        + "]";
	  }
}
