
package utils;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Connections {
    static Connection connection = null;
    static Statement stmt = null;
    

   
   public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugasakhir","root","92971463");
        stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Koneksi ke db berhasil");
        
    }
   
   public static ResultSet selectALL(String tablename){
        try {
            return stmt.executeQuery("select * from "+ tablename);
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
   public static ResultSet selectUser(String email,String password){
        try {
            return stmt.executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
   public static boolean insert(int age,String gender, float bmi, int children,String smoker,String region,float charges) {
        String sql = "insert into datapasien (age,gender,bmi,children,smoker,region,charges) values ("+age+",'"+gender+"',"+bmi+","+children+",'"+smoker+"','"+region+"',"+charges+")";
        try{
            
            if(stmt.executeUpdate(sql)>0){
            return true;
        }else {
            return false;
        }
        }catch (SQLException  e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        
    }
   
   public static boolean createuser(String username, String password){
       String sql = "insert into users (email,password) values('"+username+"','"+password+"')";
       try{
           if(stmt.executeUpdate(sql)>0){
               return true;
           }else {
               return false;
           }
       }
       catch (SQLException e){
           throw new RuntimeException();
       }
   }
   
   public static boolean update(int id,int age,String gender, float bmi, int children,String smoker,String region,float charges) throws SQLException{
       String sql = "update datapasien set age = "+age+",gender='"+gender+"',bmi="+bmi+",children="+children+",smoker='"+smoker+"',region='"+region+"',charges="+charges+" where id="+id+"";
       if(stmt.executeUpdate(sql)>0){
           return true;
       }else{
           return false;
       }
   }
 
   public static boolean delete(int id) throws SQLException{
       String sql = "delete from datapasien where id="+id+"";
       if(stmt.executeUpdate(sql)>0){
           return true;
       }else {
           return false;
       }
   }
   
}
