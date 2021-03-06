package AddUpdateProject;

import javax.persistence.EntityTransaction;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;

import PanelsInGUI.AddUpdateProjectPanel;
import PanelsInGUI.GUI;


/**
* Glue between the view (CourseListGUI) and the model (CourseListTableModel). 
* No database specific code here. Contains a reference to both the TableModel and the graphical user interface.
* @author rgrover
*/
public class AddUpdateProjectController implements ListSelectionListener, TableModelListener{
	private AddUpdateProjectTableModel tableModel;
	private AddUpdateProjectPanel gui;
	
	public AddUpdateProjectController(AddUpdateProjectPanel gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
		tableModel = new AddUpdateProjectTableModel(); 
		tableModel.addTableModelListener(this);
	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		GUI.selectedProject = Integer.parseInt((String)tableModel.getValueAt(firstIndex, 0));
		System.out.println(GUI.selectedProject);
		GUI.projectname = (String) tableModel.getValueAt(firstIndex, 1);
		System.out.println(GUI.projectname);
		GUI.projectcat = (String) tableModel.getValueAt(firstIndex, 2);
		GUI.projectstatus = (String) tableModel.getValueAt(firstIndex, 3);
		GUI.projectdescription = (String) tableModel.getValueAt(firstIndex, 4);
		
		gui.setProjectIDTextField( GUI.selectedProject);
		gui.setProjectNameTextField( GUI.projectname);
		gui.setDescriptionTextArea( GUI.projectdescription);
		//gui.setStatusTextField( (String) tableModel.getValueAt(firstIndex, 2));
		//gui.setCategoryTextField( (String) tableModel.getValueAt(firstIndex, 3));
	}
	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new AddUpdateProjectTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
			gui.setProjectIDTextField( (String) tableModel.getValueAt(firstIndex, 0));
			gui.setProjectNameTextField( (String) tableModel.getValueAt(firstIndex, 1));
			//gui.setPasswordTextField( (String) tableModel.getValueAt(firstIndex, 2));
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

