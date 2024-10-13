import com.mysql.jdbc.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author pc
 */
public final class Student_List_Table extends javax.swing.JFrame {

    /**
     * Creates new form Student_List_Table
     */
    public Student_List_Table() {
        initComponents();
        Connect();
        LoadAttendance();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

        public void Connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_studentidsystem","root","");
            } catch (SQLException ex) {
                Logger.getLogger(StudentIdentification.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentIdentification.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
        public void LoadAttendance(){
    
        try {
            int q;
            
            pst = con.prepareStatement("SELECT * FROM tbl_studentinfo a INNER JOIN tbl_studentlog e ON a.LRN = e.LRN");
            rs = pst.executeQuery();
            
            ResultSetMetaData rss = (ResultSetMetaData) rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)studentList.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                
                for(int a = 1; a<=q; a++){
                    v2.add(rs.getString("First_Name"));
                    v2.add(rs.getString("Last_Name"));
                    v2.add(rs.getString("LRN"));
                    v2.add(rs.getString("Grade"));
                    v2.add(rs.getString("Section"));
                    v2.add(rs.getString("Log_Date"));
                    v2.add(rs.getString("time"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Student_List_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
}
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        scanbt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentList.setBackground(new java.awt.Color(204, 204, 255));
        studentList.setFont(new java.awt.Font("Cascadia Code", 0, 12)); // NOI18N
        studentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "First_Name", "Last_Name", "LRN", "Grade", "Section", "Log Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentList);
        if (studentList.getColumnModel().getColumnCount() > 0) {
            studentList.getColumnModel().getColumn(0).setPreferredWidth(125);
            studentList.getColumnModel().getColumn(1).setPreferredWidth(125);
            studentList.getColumnModel().getColumn(2).setPreferredWidth(125);
            studentList.getColumnModel().getColumn(3).setPreferredWidth(50);
            studentList.getColumnModel().getColumn(4).setPreferredWidth(75);
            studentList.getColumnModel().getColumn(5).setPreferredWidth(100);
            studentList.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setForeground(new java.awt.Color(153, 255, 153));

        scanbt.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        scanbt.setText("Back to Scan");
        scanbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanbtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 0, 14)); // NOI18N
        jLabel1.setText("Search:");

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scanbt)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scanbt)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void scanbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanbtActionPerformed
        // TODO add your handling code here:
        StudentIdentification scanbt = new StudentIdentification();
        scanbt.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_scanbtActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:

         String searchText = txtsearch.getText().trim().toLowerCase();

    // Create a TableRowSorter for the table's model
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(studentList.getModel());
    studentList.setRowSorter(sorter);

    // If the search text is not empty, apply the filter
    if (!searchText.isEmpty()) {
        // Define a RowFilter to filter rows based on the search text
        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);

        // Apply the filter to the TableRowSorter
        sorter.setRowFilter(rowFilter);
    } else {
        // If the search text is empty, remove any existing filter
        sorter.setRowFilter(null);
    }

        
    }//GEN-LAST:event_txtsearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student_List_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_List_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_List_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_List_Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_List_Table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton scanbt;
    private javax.swing.JTable studentList;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

    private static class scanbt {

        public scanbt() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
