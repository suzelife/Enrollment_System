
package system;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class evaluation extends javax.swing.JFrame {

    public evaluation() {
        initComponents();
        getEvaluationList();
        hideFirst();
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
        progressbar.setVisible(false);
    }
    public class progress implements ActionListener{
  public void actionPerformed(ActionEvent evt){
	DefaultTableModel model = (DefaultTableModel) eval_table.getModel();
	int n = progressbar.getValue();

	if(n<100){
	n++;
	progressbar.setValue(n);	
	}
	else{
	timer.stop();
	JOptionPane.showMessageDialog(null,"Success","DONE",JOptionPane.INFORMATION_MESSAGE);
        progressbar.setVisible(false);
        progressbar.setValue(0);
        model.setRowCount(0);
        getEvaluationList();
	}

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

    public void getEvaluationList(){

    Connection con = Sqlconnection.connectDB();
    Statement st;
    ResultSet rs;
    String query = "SELECT ID,fname,lname,course FROM evaluation";
    try{
        st = con.createStatement();
        rs = st.executeQuery(query);
        while(rs.next()){
            DefaultTableModel model = (DefaultTableModel) eval_table.getModel();
            model.addRow(new Object[]{rs.getInt("ID"),rs.getString("fname"),rs.getString("lname"),rs.getString("course")});
            
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }  
}
    public void hideFirst(){
        fname.setVisible(false);
        mname.setVisible(false);
        lname.setVisible(false);
        course.setVisible(false);
        sep.setVisible(false);
        pass.setEnabled(false);
        fail.setEnabled(false);
        pend.setEnabled(false);
    }
    public void unhideFirst(){
        fname.setVisible(true);
        mname.setVisible(true);
        lname.setVisible(true);
        course.setVisible(true);
        sep.setVisible(true);
        pass.setEnabled(true);
        fail.setEnabled(true);
        pend.setEnabled(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eval_table = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        eval_search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        sep = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JButton();
        pend = new javax.swing.JButton();
        fail = new javax.swing.JButton();
        fname = new javax.swing.JLabel();
        mname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        course = new javax.swing.JLabel();
        progressbar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        eval_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eval_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eval_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Priority #", "Firstname", "Lastname", "Course"
            }
        ));
        eval_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eval_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eval_table);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel55.setText("Enrollment System");

        eval_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        eval_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eval_searchKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Back to main");

        sep.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sep.setText("Show entire profile");
        sep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sepMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sepMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sepMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sepMouseReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel6.setText("Evaluation:");

        pass.setText("Pass");
        pass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pass.setEnabled(false);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        pend.setText("Waitlist");
        pend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pend.setEnabled(false);

        fail.setText("Failed");
        fail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fail.setEnabled(false);

        fname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fname.setText("firstname");

        mname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mname.setText("middlename");

        lname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lname.setText("lastname");

        course.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        course.setText("course");

        progressbar.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(eval_search, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton1)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pend, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(progressbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(sep)))
                        .addGap(155, 155, 155))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(323, 323, 323))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eval_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(fname)
                        .addGap(18, 18, 18)
                        .addComponent(mname)
                        .addGap(24, 24, 24)
                        .addComponent(lname)
                        .addGap(18, 18, 18)
                        .addComponent(course)
                        .addGap(46, 46, 46)
                        .addComponent(sep)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pass)
                            .addComponent(fail)
                            .addComponent(pend))
                        .addGap(30, 30, 30)
                        .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void eval_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eval_tableMouseClicked
        Statement st;
        ResultSet rs;
        try{
            int sel = eval_table.getSelectedRow();
            TableModel model = eval_table.getModel();
            if(sel == -1){
                hideFirst();
            }else{
                unhideFirst();
                Connection con = Sqlconnection.connectDB();
                String id = model.getValueAt(sel,0).toString();
                String query = "SELECT fname,mname,lname,course FROM evaluation WHERE ID='"+id+"'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                while(rs.next()){
                   fname.setText(rs.getString("fname"));
                   mname.setText(rs.getString("mname"));
                   lname.setText(rs.getString("lname"));
                   course.setText(rs.getString("course"));
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_eval_tableMouseClicked

    private void eval_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eval_searchKeyReleased
        eval_table.getSelectionModel().clearSelection();
        PreparedStatement pst;
        ResultSet rs;
        try{
            if(eval_table.getSelectedRow()==-1){
                hideFirst();
            }
            String query ="SELECT ID,fname,lname,course FROM register WHERE CONCAT(ID,fname,lname,course) LIKE '%"+eval_search.getText()+"%'";
            Connection con = Sqlconnection.connectDB();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            eval_table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
               
            }
            pst.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }//GEN-LAST:event_eval_searchKeyReleased

    private void sepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepMouseEntered
        sep.setForeground(Color.blue);
    }//GEN-LAST:event_sepMouseEntered

    private void sepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepMouseExited
        sep.setForeground(UIManager.getColor("control"));
    }//GEN-LAST:event_sepMouseExited

    private void sepMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepMousePressed
        sep.setForeground(Color.green);
    }//GEN-LAST:event_sepMousePressed

    private void sepMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepMouseReleased
        sep.setForeground(Color.blue);
    }//GEN-LAST:event_sepMouseReleased

    private void sepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sepMouseClicked
        int sel = eval_table.getSelectedRow();
        TableModel model = eval_table.getModel();
        String ID =   model.getValueAt(sel,0).toString();
        String name = model.getValueAt(sel,1).toString();
        String last = model.getValueAt(sel,2).toString();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM evaluation WHERE ID = '"+ID+"' AND fname='"+name+"' AND lname='"+last+"'";
        try{
            Connection con = Sqlconnection.connectDB();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
                
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.pack();
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                
                JTextArea area = new JTextArea();
                area.setPreferredSize(new Dimension(700,550));
                area.setEditable(false);
                area.append("PROFILE\n\n" + "Firstname:\t\t" + rs.getString("fname") + 
                        "\nMiddlename:\t\t"+rs.getString("mname")+"\nLastname:\t\t"+rs.getString("lname")+
                        "\nDate of Birth:\t\t"+rs.getString("dob")+"\nAge:\t\t"+rs.getString("age")+
                        "\nGender:\t\t"+rs.getString("gender")+"\nStatus:\t\t"+rs.getString("status")+"\nHeight:\t\t"+rs.getInt("height")+
                        "\nWeight:\t\t"+rs.getInt("weight")+"\nBlood Type:\t\t"+rs.getString("btype")+"\nAddress:\t\t"
                        +rs.getString("address")+"\nCitizenship:\t\t"+rs.getString("cship")+"\nCell Number:\t\t"
                        +rs.getInt("cnumber")+"\n\nFAMILY" + "\n\nFather:" + "\n\nFirstname:\t\t"+rs.getString("ffname")+
                        "\nMiddlename:\t\t"+rs.getString("fmname")+"\nLastname:\t\t"+rs.getString("flname")+
                        "\nOccupation:\t\t"+rs.getString("foccupation")+
                        "\n\nMother:" + "\n\nFirstname:\t\t"+rs.getString("mfname")+
                        "\nMiddlename:\t\t"+rs.getString("mmname")+"\nLastname:\t\t"+rs.getString("mlname")+
                        "\nOccupation:\t\t"+rs.getString("moccupation")+"\nSibling:\t\t"+rs.getInt("psibling")+"\n\n"
                
                            );
                
                JDialog dialog = new JDialog(this,"Profile",true);
                dialog.getContentPane().add(area);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                
                               
                
            }
            
        } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
        
    
    }//GEN-LAST:event_sepMouseClicked

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        progressbar.setVisible(true);
        int sel = eval_table.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel) eval_table.getModel();
        String ID =   model.getValueAt(sel,0).toString();
        Statement st;
        try{
            
            String query = "INSERT INTO state (ID,fname,mname,lname,age,gender,status,height,weight,btype,dob,address,cship,cnumber,ffname,fmname,flname,foccupation,mfname,mmname,mlname,moccupation,psibling,course)"
                    + "SELECT ID,fname,mname,lname,age,gender,status,height,weight,btype,dob,address,cship,cnumber,ffname,fmname,flname,foccupation,mfname,mmname,mlname,moccupation,psibling,course "
                    + "FROM evaluation WHERE ID='"+ID+"';"
                    +  "DELETE FROM evaluation WHERE ID='"+ID+"';"
                    + "UPDATE state SET state='Enrolled' WHERE ID='"+ID+"';"
                    + "COMMIT";
            Connection con = Sqlconnection.connectDB();
            st = con.createStatement();
            st.executeUpdate(query);
            
            timer.start();
            
         
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_passActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        timer = new Timer(15,new progress());
    }//GEN-LAST:event_formWindowOpened


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
            java.util.logging.Logger.getLogger(evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(evaluation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new evaluation().setVisible(true);
            }
        });
    }
    private Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel course;
    private javax.swing.JTextField eval_search;
    private javax.swing.JTable eval_table;
    private javax.swing.JButton fail;
    private javax.swing.JLabel fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel mname;
    private javax.swing.JButton pass;
    private javax.swing.JButton pend;
    private javax.swing.JProgressBar progressbar;
    private javax.swing.JLabel sep;
    // End of variables declaration//GEN-END:variables
}
