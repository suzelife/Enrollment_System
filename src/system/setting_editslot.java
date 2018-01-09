/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class setting_editslot extends javax.swing.JFrame {

    
    public setting_editslot() {
        initComponents();
    }

    public JPanel getEditSlotPanel(){
        return editslotpanel;
    }
    
    public JButton getSumbit(){
        return submit;
    }
    
    public JTextField getField(){
        return field;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editslotpanel = new javax.swing.JPanel();
        field = new javax.swing.JTextField();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        field.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submit.setText("Sumbit");

        javax.swing.GroupLayout editslotpanelLayout = new javax.swing.GroupLayout(editslotpanel);
        editslotpanel.setLayout(editslotpanelLayout);
        editslotpanelLayout.setHorizontalGroup(
            editslotpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editslotpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(field)
                .addContainerGap())
            .addGroup(editslotpanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(submit)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        editslotpanelLayout.setVerticalGroup(
            editslotpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editslotpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(submit)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editslotpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editslotpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(setting_editslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(setting_editslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(setting_editslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(setting_editslot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setting_editslot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editslotpanel;
    private javax.swing.JTextField field;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
