
package system;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.sql.*;



public final class Profile extends javax.swing.JFrame {

    
    public Profile() {
        initComponents();
        state();
        setIconImage(Toolkit.getDefaultToolkit().createImage("icon/icon.png"));
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       addWindowListener(new WindowAdapter() {
                        @Override
			public void windowClosing(WindowEvent e) {
                            int choice = JOptionPane.showConfirmDialog(
					null, 
					"Are you sure you want to exit?", 
					"CONFIRM", 
					JOptionPane.YES_NO_OPTION
				);
				if (choice == JOptionPane.YES_OPTION) { //yes
					System.exit(0);
				}
				
			}
		});
 
    }
    public JTextArea profArea(){
        return profilearea;
    }
    public JLabel getID(){
        return prioID;
    }
    public JCheckBox getPaybox(){
        return paybox;
    }
    public JCheckBox getRqbox(){
        return rqbox;
    }
   
    public void state(){
              
        String id = prioID.getText();
        Statement st;
        ResultSet rs;
        String query = "SELECT payment,requirement FROM register WHERE id ='"+id+"'";
        try{
            Connection con = Sqlconnection.connectDB();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                if(rs.getString("payment") == null){
                    paybox.setSelected(false);
                }else{
                    paybox.setSelected(true);
                }
                if(rs.getString("requirement") == null){
                    rqbox.setSelected(false);
                }else{
                    rqbox.setSelected(true);
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void Sqlupdate(String query,String message){
        Statement st;
        
        try{
            Connection con = Sqlconnection.connectDB();
            st = con.createStatement();
            st.executeUpdate(query);
            if(st.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(null,"Data "+message+"successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Data not "+message,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        }
       
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profilearea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        paybox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        rqbox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        updatestatus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        prioID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profilearea.setBackground(new java.awt.Color(240, 240, 240));
        profilearea.setColumns(20);
        profilearea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        profilearea.setRows(5);
        jScrollPane1.setViewportView(profilearea);

        paybox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        paybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payboxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Payments");

        rqbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rqbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rqboxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Requirements");

        updatestatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatestatus.setForeground(new java.awt.Color(0, 153, 51));
        updatestatus.setText("Update Status");
        updatestatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatestatusActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 51));
        jButton2.setText("Edit Profile");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText(" ID:");

        prioID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        prioID.setText("id");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Back to list");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paybox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(rqbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updatestatus)
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(prioID, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(rqbox)
                        .addComponent(jLabel2)
                        .addComponent(paybox))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updatestatus)
                            .addComponent(jButton2)
                            .addComponent(jLabel4)
                            .addComponent(prioID))
                        .addGap(2, 2, 2))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rqboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rqboxActionPerformed
        if(paybox.isSelected()){
            
        }
    }//GEN-LAST:event_rqboxActionPerformed

    private void payboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payboxActionPerformed
        
    }//GEN-LAST:event_payboxActionPerformed

    private void updatestatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatestatusActionPerformed
       if(paybox.isSelected()){
           String query = "UPDATE register SET payment = 'paid' WHERE id= '"+prioID.getText()+"'";
           Sqlupdate(query,"Updated");
       }else{
           String query = "UPDATE register SET payment = NULL WHERE id= '"+prioID.getText()+"'";
           Sqlupdate(query,"Updated");
       }
       if(rqbox.isSelected()){
           String query = "UPDATE register SET requirement = 'completed' WHERE id= '"+prioID.getText()+"'";
           Sqlupdate(query,"Updated");
       }else{
           String query = "UPDATE register SET requirement = NULL WHERE id= '"+prioID.getText()+"'";
           Sqlupdate(query,"Updated");
       }
       
    }//GEN-LAST:event_updatestatusActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
       jLabel5.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
       jLabel5.setForeground(UIManager.getColor("control"));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       Registered rgt = new Registered();
       rgt.setVisible(true);
       rgt.setLocationRelativeTo(null);
       this.dispose();
       
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox paybox;
    private javax.swing.JLabel prioID;
    private javax.swing.JTextArea profilearea;
    private javax.swing.JCheckBox rqbox;
    private javax.swing.JButton updatestatus;
    // End of variables declaration//GEN-END:variables
}