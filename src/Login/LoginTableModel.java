package Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.*;
import javax.persistence.*;

import PanelsInGUI.GUI;
import UserRegistration.UserRegistration;
import UserRegistration.UserRegistrationService;

import java.util.*;

/**
*
* @author amalla
*/
public class LoginTableModel extends AbstractTableModel {

	  List<UserRegistration> UserRegistrationResultList;   // stores the model data in a List collection of type UserRegistration
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private UserRegistration UserRegistration;			    // represents the entity courselist
	  private UserRegistrationService UserRegistrationService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns
	  
	 public LoginTableModel() {
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    UserRegistration = new UserRegistration();
		    UserRegistrationService = new UserRegistrationService(manager);
		    
		    // read all the records from courselist
		    UserRegistrationResultList = UserRegistrationService.readAll();
		    
		    // update the number of rows and columns in the model
		    numrows = UserRegistrationResultList.size();
		    numcols = UserRegistration.getNumberOfColumns();
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
		  return UserRegistrationResultList.get(row).getColumnData(col);
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
				return UserRegistration.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   UserRegistration element = UserRegistrationResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<UserRegistration> getList() {
		 return UserRegistrationResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public LoginTableModel(List<UserRegistration> list, EntityManager em)  {
	    UserRegistrationResultList = list;
	    numrows = UserRegistrationResultList.size();
	    UserRegistration = new UserRegistration();
	   	numcols = UserRegistration.getNumberOfColumns();     
		manager = em;  
		UserRegistrationService = new UserRegistrationService(manager);
	 }
	 

	 public boolean authorization(int id, String password){
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    UserRegistration = new UserRegistration();
		    UserRegistrationService = new UserRegistrationService(manager);
		    
		    // read all the records from courselist
		    UserRegistration user = UserRegistrationService.readUser(id);
		    if (password.equals(user.getPassword())){
	            if(user.gettypeOfUser().equals("Viewer"))
	                GUI.LoginedUserLevel = 1;
	            else if(user.gettypeOfUser().equals("Normal Administrator"))
	            	GUI.LoginedUserLevel = 2;
	            else 
	            	GUI.LoginedUserLevel = 3;
		    	return true;
		    }else{
		    	return false;
		    }
		    
	 }
}
