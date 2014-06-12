package ProjectManagement;

import javax.persistence.EntityTransaction;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;

import PanelsInGUI.ProjectManagementPanel;


/**
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
* @author rgrover
*/
public class ProjectManagementController implements ListSelectionListener, TableModelListener{
	private ProjectManagementTableModel tableModel;
	private ProjectManagementPanel gui;
	
	public ProjectManagementController(ProjectManagementPanel gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new ProjectManagementTableModel(); 
		tableModel.addTableModelListener(this);
	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		//int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		//gui.setSearchTextField( (String) tableModel.getValueAt(firstIndex, 0));
		//gui.setUserNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
		
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new ProjectManagementTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();

			
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
		}
	}

	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}
	public void deleteRow(int userID) {
		tableModel.deleteRow(userID);			
	}
	public void updateRow(String[] array) {
		tableModel.updateRow(array);			
	}
}

