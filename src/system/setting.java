
package system;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static org.hsqldb.OpTypes.COUNT;


public class setting extends javax.swing.JFrame {

    public setting() {
         
        
        initComponents();
        getCourseList();
        update.setEnabled(false);
        slotfield.setEnabled(false);
        slot.setVisible(false);
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
    
    public void getCourseList(){

    Connection con = Sqlconnection.connectDB();
    Statement st;
    ResultSet rs;
    String query = "SELECT * FROM courses";
    try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
            DefaultTableModel model = (DefaultTableModel) setting_table.getModel();
            model.addRow(new Object[]{rs.getString("course"),rs.getInt("slot")});
            
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }  
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        setting_table = new javax.swing.JTable();
        request = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        slot = new javax.swing.JLabel();
        addcourse = new javax.swing.JButton();
        slotfield = new javax.swing.JTextField();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel55.setText("Enrollment System");

        setting_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setting_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setting_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Number of Slot"
            }
        ));
        setting_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setting_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(setting_table);

        request.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        request.setText("Request Form");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Available slot:");

        slot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        slot.setText("SLOT");

        addcourse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addcourse.setText("Add course");

        slotfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        slotfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                slotfieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                slotfieldKeyTyped(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("Update slot");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addcourse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(request, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(slotfield, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slot, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel55)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(slot))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(slotfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update))
                        .addGap(54, 54, 54)
                        .addComponent(addcourse)
                        .addGap(18, 18, 18)
                        .addComponent(request))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setting_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting_tableMouseClicked
        update.setEnabled(false);
        slotfield.setEnabled(true);
        int sel = setting_table.getSelectedRow();
        TableModel model = setting_table.getModel();
        String numCourse = model.getValueAt(sel,0).toString();
        int num = (int)model.getValueAt(sel,1);
        Connection con;
        String query = "SELECT COUNT(state) AS rowcount FROM state WHERE course='"+numCourse+"'";
        try{
            con = Sqlconnection.connectDB();
            Statement st;
            ResultSet rs;
            st= con.createStatement();
            rs=st.executeQuery(query);
            
            while(rs.next()){
            
            slotfield.setText(num+"");
            slotfield.setEnabled(true);
            int count = rs.getInt("rowcount");
            int t = num-=count;
            slot.setText(t+"");
            slot.setVisible(true);
            
            }
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_setting_tableMouseClicked

    private void slotfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_slotfieldKeyReleased
        try{
            int sel = setting_table.getSelectedRow();
             TableModel model = setting_table.getModel();
             String old = model.getValueAt(sel,1).toString();
            if(!slotfield.getText().equals(old)){
                update.setEnabled(true);
            }else{
                update.setEnabled(false);
            }
                            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_slotfieldKeyReleased

    private void slotfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_slotfieldKeyTyped
        /*try{
            int sel = setting_table.getSelectedRow();
             TableModel model = setting_table.getModel();
             String old = model.getValueAt(sel,1).toString();
            if(!slotfield.getText().equals(old)){
                update.setEnabled(true);
            }else{
                update.setEnabled(false);
            }
                            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }*/
    }//GEN-LAST:event_slotfieldKeyTyped

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        Connection con;
        Statement st;
        int r = setting_table.getSelectedRow();
        DefaultTableModel md = (DefaultTableModel) setting_table.getModel();
        String cs = md.getValueAt(r,0).toString();
        String query = "UPDATE courses SET slot='"+slotfield.getText()+"' WHERE course ='"+cs+"'";
        try{
            con = Sqlconnection.connectDB();
            st = con.createStatement();
            st.executeUpdate(query);
            if(st.executeUpdate(query)==1){
                JOptionPane.showMessageDialog(null,"Data Updated successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                md.setRowCount(0);
                getCourseList();
                slotfield.setEnabled(false);
                slotfield.setText(null);
                slot.setText(null);
            }
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_updateActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addcourse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton request;
    private javax.swing.JTable setting_table;
    private javax.swing.JLabel slot;
    private javax.swing.JTextField slotfield;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    private void getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Object COUNT() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setIcon(ImageIcon imageIcon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
