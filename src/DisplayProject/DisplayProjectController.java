package DisplayProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;

import PanelsInGUI.DisplayProjectPanel;
import PanelsInGUI.GUI;
import ProjectManagement.ProjectManagement;
import UserRegistration.UserRegistration;


/**
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
* @author rgrover
*/
public class DisplayProjectController implements ListSelectionListener, TableModelListener{
	private static DisplayProjectTableModel tableModel;
	private DisplayProjectPanel gui;
	 private EntityManager manager;

	public DisplayProjectController(DisplayProjectPanel gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new DisplayProjectTableModel(); 
		tableModel.addTableModelListener(this);
		//System.out.println(GUI.selectedProject);
		//GUI.selectedProject = 2;
		//int primarykey = GUI.selectedProject;
   	 	//ProjectManagement project = manager.find(ProjectManagement.class, primarykey);
		//System.out.println(GUI.projectname);
		//gui.setProjectNameTextField(GUI.projectname);
		//gui.setStatusTextField(project.getProjectStatus());
		//gui.setCategoryTextField(project.getProjectCategory());
	}
	
	
	// new code
	public static TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		//int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		//gui.setProjectNameTextField( (String) tableModel.getValueAt(firstIndex, 0));
		//gui.setCategoryTextField( (String) tableModel.getValueAt(firstIndex, 1));
		//gui.setStatusTextField( (String) tableModel.getValueAt(firstIndex, 2));
		//gui.setTypeOfUserTextField( (String) tableModel.getValueAt(firstIndex, 3));
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	//int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new DisplayProjectTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
	    	//gui.setProjectNameTextField( (String) tableModel.getValueAt(firstIndex, 0));
			//gui.setCategoryTextField( (String) tableModel.getValueAt(firstIndex, 1));
			//gui.setStatusTextField( (String) tableModel.getValueAt(firstIndex, 2));
			//gui.setTypeOfUserTextField( (String) tableModel.getValueAt(firstIndex, 3));
			
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

