package PanelsInGUI;

/**
 *
 * @author akash
 */
public class ProjectManagementPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProjectManagementPanel
     */
    public ProjectManagementPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        projectManagementPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        addProjectButton = new javax.swing.JButton();
        deleteProjectButton = new javax.swing.JButton();
        updateProjectButton = new javax.swing.JButton();
        displayProjectButton = new javax.swing.JButton();
        projectInfoTablePanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();

        projectManagementPanel.setBackground(new java.awt.Color(255, 255, 102));
        projectManagementPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Project Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 0, 0))); // NOI18N

        searchButton.setText("Search");

        addProjectButton.setText("Add");
        addProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjectButtonActionPerformed(evt);
            }
        });

        deleteProjectButton.setText("Delete");

        updateProjectButton.setText("Update");

        displayProjectButton.setText("Display Project");

        projectInfoTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Information Table"));

        javax.swing.GroupLayout projectInfoTablePanelLayout = new javax.swing.GroupLayout(projectInfoTablePanel);
        projectInfoTablePanel.setLayout(projectInfoTablePanelLayout);
        projectInfoTablePanelLayout.setHorizontalGroup(
            projectInfoTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
        projectInfoTablePanelLayout.setVerticalGroup(
            projectInfoTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Project Name", "User Name", "Category" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectManagementPanelLayout = new javax.swing.GroupLayout(projectManagementPanel);
        projectManagementPanel.setLayout(projectManagementPanelLayout);
        projectManagementPanelLayout.setHorizontalGroup(
            projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectManagementPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectInfoTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(projectManagementPanelLayout.createSequentialGroup()
                        .addGroup(projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(projectManagementPanelLayout.createSequentialGroup()
                                .addComponent(addProjectButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteProjectButton))
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(projectManagementPanelLayout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(searchButton))
                            .addGroup(projectManagementPanelLayout.createSequentialGroup()
                                .addComponent(updateProjectButton)
                                .addGap(18, 18, 18)
                                .addComponent(displayProjectButton)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        projectManagementPanelLayout.setVerticalGroup(
            projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectManagementPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(20, 20, 20)
                .addGroup(projectManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProjectButton)
                    .addComponent(deleteProjectButton)
                    .addComponent(updateProjectButton)
                    .addComponent(displayProjectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectInfoTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(projectManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void addProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          


    // Variables declaration - do not modify                     
    private javax.swing.JButton addProjectButton;
    private javax.swing.JButton deleteProjectButton;
    private javax.swing.JButton displayProjectButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel projectInfoTablePanel;
    private javax.swing.JPanel projectManagementPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton updateProjectButton;
    // End of variables declaration                   
}
