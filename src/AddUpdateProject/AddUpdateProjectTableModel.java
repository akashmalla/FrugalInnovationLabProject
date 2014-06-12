package AddUpdateProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;

import UserRegistration.*;
import DisplayProject.*;

import java.util.*;

/**
*
* @author amalla
*/
public class AddUpdateProjectTableModel extends AbstractTableModel {

	  List<DisplayProject> AddUpdateProjectResultList;   // stores the model data in a List collection of type DisplayProject
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private DisplayProject DisplayProject;			    // represents the entity courselist
	  private DisplayProjectService DisplayProjectService;
	  private UserRegistrationService UserRegistrationService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	 AddUpdateProjectTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    DisplayProject = new DisplayProject();
	    DisplayProjectService = new DisplayProjectService(manager);
	    UserRegistrationService = new UserRegistrationService(manager);
	    
	    // read all the records from courselist
	    AddUpdateProjectResultList = DisplayProjectService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = AddUpdateProjectResultList.size();
	    numcols = DisplayProject.getNumberOfColumns();
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
		  return AddUpdateProjectResultList.get(row).getColumnData(col);
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
				return DisplayProject.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   DisplayProject element = AddUpdateProjectResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<DisplayProject> getList() {
		 return AddUpdateProjectResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public AddUpdateProjectTableModel(List<DisplayProject> list, EntityManager em)  {
	    AddUpdateProjectResultList = list;
	    numrows = AddUpdateProjectResultList.size();
	    DisplayProject = new DisplayProject();
	   	numcols = DisplayProject.getNumberOfColumns();     
		manager = em;  
		DisplayProjectService = new DisplayProjectService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		DisplayProject newRecord = DisplayProjectService.createFile(Integer.parseInt((String) array[0]), (String) array[1], Integer.parseInt((String) array[2]), (String) array[3]);
		userTransaction.commit();
		 
		// set the current row to rowIndex
        AddUpdateProjectResultList.add(newRecord);
        int row = AddUpdateProjectResultList.size();  
        int col = 0;

        // update the data in the model to the entries in array
         for (Object data : array) {
          	 setValueAt((String) data, row-1, col++);
         }
         
         numrows++;
	 }
	 
	 public void deleteRow(int fileID){
			//data[rowIndex][columnIndex] = (String) aValue;
			int index = AddUpdateProjectResultList.indexOf(manager.find(DisplayProject.class, fileID));

		    // add row to database
		    System.out.println(index);
			EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			DisplayProjectService.deleteFile(fileID);
			userTransaction.commit();
			AddUpdateProjectResultList.remove(index);
			numrows--;

			
	 }
	 
	 public void updateRow(Object[] array){
			//data[rowIndex][columnIndex] = (String) aValue;
		 	int userID = Integer.parseInt((String) array[0]); 
			int index = AddUpdateProjectResultList.indexOf(manager.find(DisplayProject.class, userID));
			int col = 0;
			
		    // add row to database
			EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			UserRegistration updateRecord = UserRegistrationService.updateUser(Integer.parseInt((String) array[0]), (String) array[1], (String) array[2], (String) array[3]);
			userTransaction.commit();
			
			// set the current row to rowIndex
	        //AddUpdateProjectResultList.add(updateRecord);
			for(Object data : array){
				setValueAt((String)data, index, col++);
			}	

	 }
}
