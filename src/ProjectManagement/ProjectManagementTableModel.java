package ProjectManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;

import java.util.*;

/**
*
* @author amalla
*/
public class ProjectManagementTableModel extends AbstractTableModel {

	  List<ProjectManagement> ProjectManagementResultList;   // stores the model data in a List collection of type ProjectManagement
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private ProjectManagement ProjectManagement;			    // represents the entity ProjectInformation
	  private ProjectManagementService ProjectManagementService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	 ProjectManagementTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    ProjectManagement = new ProjectManagement();
	    ProjectManagementService = new ProjectManagementService(manager);
	    
	    // read all the records from courselist
	    ProjectManagementResultList = ProjectManagementService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = ProjectManagementResultList.size();
	    numcols = ProjectManagement.getNumberOfColumns();
      }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return ProjectManagementResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return ProjectManagement.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   ProjectManagement element = ProjectManagementResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<ProjectManagement> getList() {
		 return ProjectManagementResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public ProjectManagementTableModel(List<ProjectManagement> list, EntityManager em)  {
	    ProjectManagementResultList = list;
	    numrows = ProjectManagementResultList.size();
	    ProjectManagement = new ProjectManagement();
	   	numcols = ProjectManagement.getNumberOfColumns();     
		manager = em;  
		ProjectManagementService = new ProjectManagementService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		ProjectManagement newRecord = ProjectManagementService.createProject(Integer.parseInt((String) array[0]), (String) array[1], (String) array[2], (String) array[3], (String) array[4]);
		userTransaction.commit();
		 
		// set the current row to rowIndex
        ProjectManagementResultList.add(newRecord);
        int row = ProjectManagementResultList.size();  
        int col = 0;

        // update the data in the model to the entries in array
         for (Object data : array) {
          	 setValueAt((String) data, row-1, col++);
         }
         
         numrows++;
	 }
	 
	 public void deleteRow(int projectID){
			//data[rowIndex][columnIndex] = (String) aValue;
			int index = ProjectManagementResultList.indexOf(manager.find(ProjectManagement.class, projectID));

		    // add row to database
		    System.out.println(index);
			EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			ProjectManagementService.deleteProject(projectID);
			userTransaction.commit();
			ProjectManagementResultList.remove(index);
			numrows--;

			
	 }
	 
	 public void updateRow(Object[] array){
			//data[rowIndex][columnIndex] = (String) aValue;
		 	int projectID = Integer.parseInt((String) array[0]); 
			int index = ProjectManagementResultList.indexOf(manager.find(ProjectManagement.class, projectID));
			int col = 0;
			
		    // add row to database
			EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			ProjectManagement updateRecord = ProjectManagementService.updateProject(Integer.parseInt((String) array[0]), (String) array[1], (String) array[2], (String) array[3], (String) array[4]);
			userTransaction.commit();
			
			// set the current row to rowIndex
	        //ProjectManagementResultList.add(updateRecord);
			for(Object data : array){
				setValueAt((String)data, index, col++);
			}	
	 }
}
