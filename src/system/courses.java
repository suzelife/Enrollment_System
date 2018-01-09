
package system;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class courses extends javax.swing.JFrame {

    public courses() {
        initComponents();
        getCourseList();
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
    }
public void hideFirst(){
    slot.setVisible(false);
    coursename.setVisible(false);
}
public void unhideFirst(){
    slot.setVisible(true);
    coursename.setVisible(true);
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
            DefaultTableModel model = (DefaultTableModel) course_table.getModel();
            model.addRow(new Object[]{rs.getString("course")});
            
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }  
}

public JPanel getPanel(){
    return coursepanel;
}
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        coursepanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        course_table = new javax.swing.JTable();
        coursename = new javax.swing.JLabel();
        searchfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        slot = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Enrollment System");

        course_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        course_table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        course_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Courses"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        course_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                course_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(course_table);

        coursename.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        coursename.setText("CourseName");

        searchfield.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Slot Available:");

        slot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        slot.setText("slot");

        javax.swing.GroupLayout coursepanelLayout = new javax.swing.GroupLayout(coursepanel);
        coursepanel.setLayout(coursepanelLayout);
        coursepanelLayout.setHorizontalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coursename, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(coursepanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(slot, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        coursepanelLayout.setVerticalGroup(
            coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursepanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(coursename)
                        .addGap(69, 69, 69)
                        .addGroup(coursepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(slot))
                        .addGap(0, 204, Short.MAX_VALUE))
                    .addGroup(coursepanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coursepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(coursepanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void course_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_course_tableMouseClicked
        Statement st;
        ResultSet rs;
        try{
            int sel = course_table.getSelectedRow();
            TableModel model = course_table.getModel();
            if(sel == -1){
                hideFirst();
            }else{
                unhideFirst();
                Connection con = Sqlconnection.connectDB();
                String course = model.getValueAt(sel,0).toString();
                String query = "SELECT * FROM courses WHERE course='"+course+"'";
                st = con.createStatement();
                rs = st.executeQuery(query);
                while(rs.next()){
                   coursename.setText(rs.getString("course"));
                   slot.setText(rs.getString("slot"));
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_course_tableMouseClicked

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
       course_table.getSelectionModel().clearSelection();
        PreparedStatement pst;
        ResultSet rs;
        try{
            if(course_table.getSelectedRow()==-1){
                hideFirst();
            }
            String query ="SELECT course FROM courses WHERE course LIKE '%"+searchfield.getText()+"%'";
            Connection con = Sqlconnection.connectDB();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            course_table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next()){
               
            }
            pst.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_searchfieldKeyReleased

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
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable course_table;
    private javax.swing.JLabel coursename;
    private javax.swing.JPanel coursepanel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel slot;
    // End of variables declaration//GEN-END:variables
}
