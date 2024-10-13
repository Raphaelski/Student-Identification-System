import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class StudentIdentification extends javax.swing.JFrame {


    public StudentIdentification() {
        initComponents();
        Connect();
    }

    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/db_studentidsystem","root","");
            } catch (SQLException ex) {
                Logger.getLogger(StudentIdentification.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentIdentification.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScanTxt = new javax.swing.JLabel();
        LRNtxt = new javax.swing.JTextField();
        tablebt = new javax.swing.JButton();
        signOutbt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Identification");
        setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        ScanTxt.setFont(new java.awt.Font("Cascadia Mono", 0, 18)); // NOI18N
        ScanTxt.setText("Scan Barcode:");

        LRNtxt.setFont(new java.awt.Font("Cascadia Code", 1, 18)); // NOI18N
        LRNtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LRNtxtKeyPressed(evt);
            }
        });

        tablebt.setFont(new java.awt.Font("Cascadia Code", 1, 12)); // NOI18N
        tablebt.setText("Table");
        tablebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablebtActionPerformed(evt);
            }
        });

        signOutbt.setFont(new java.awt.Font("Cascadia Code", 0, 12)); // NOI18N
        signOutbt.setText("Sign out");
        signOutbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutbtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LRNtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tablebt))
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signOutbt)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(ScanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LRNtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablebt)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signOutbt)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LRNtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LRNtxtKeyPressed
        // TODO add your handling code here:
        String LRN = LRNtxt.getText();
        
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                
                java.util.Date date = new java.util.Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime()); 
                java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());
                
                pst = con.prepareStatement("SELECT * FROM tbl_studentinfo WHERE LRN =?");
                pst.setString(1,LRN);
                rs = pst.executeQuery();
                
                if(rs.next()==true){
                    
                    pst = con.prepareStatement("INSERT INTO tbl_studentlog (LRN,Log_Date,time)VALUES(?,?,?)");
                    pst.setString(1,LRN);
                    pst.setDate(2, sqldate);
                    pst.setTimestamp(3, sqltime);
                    
                    int q = pst.executeUpdate();
                    if(q == 1){
                        JOptionPane.showMessageDialog(this, ("Log in Complete!"));
                        LRNtxt.setText("");
                        LRNtxt.requestFocus();
                    }else {
                        JOptionPane.showMessageDialog(this, ("Log in Failed."));
                    }
                    
                }else {
                    JOptionPane.showMessageDialog(this, ("ID not Found."));
                }
               
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(StudentIdentification.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_LRNtxtKeyPressed
}
    private void tablebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablebtActionPerformed
        // TODO add your handling code here:                                           
    // Create an instance of the next JFrame
     Student_List_Table nextFrame = new Student_List_Table();
    // Make the next JFrame visible
     nextFrame.setVisible(true);
    // Close the current JFrame (optional)
     dispose();
          
    }//GEN-LAST:event_tablebtActionPerformed

    private void signOutbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutbtActionPerformed
        // TODO add your handling code here:
        LoginFrame nextFrame = new LoginFrame();
        nextFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_signOutbtActionPerformed


    
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
            java.util.logging.Logger.getLogger(StudentIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentIdentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentIdentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LRNtxt;
    private javax.swing.JLabel ScanTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton signOutbt;
    private javax.swing.JButton tablebt;
    // End of variables declaration//GEN-END:variables
}
