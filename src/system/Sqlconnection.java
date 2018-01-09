
package system;

import java.sql.*;


public class Sqlconnection {
   
   public static Connection connectDB(){
       Connection con = null;
       String path = "jdbc:ucanaccess://C:\\Users\\ppqafqa\\Documents\\NetBeansProjects\\Enrollment_system\\Database\\enrollmentsystem.accdb";
        try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection(path);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return con;
   }
   
}
