/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pasien;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import utils.Connections;
@WebServlet(name = "LoginPas", urlPatterns = {"/LoginPas"})
public class LoginPas extends HttpServlet{
    public static boolean isvalid=false;
    public static void unauthorizedAccess(HttpServletResponse resp) throws IOException{
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("Invalid Access<br/>");
        writer.println("<h4><a href=\"index.jsp\">Kembali Ke Halaman Login</a></h4>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter pw = resp.getWriter();
       Connections.connect();
       String email = req.getParameter("username");
       String password = req.getParameter("password");
       
       ResultSet rs = null;
       
       pw.println("<html><body>");
       try{
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(password.getBytes());
           byte[] bytes = md.digest();
           StringBuilder sb = new StringBuilder();
           for (int i = 0; i < bytes.length; i++) {
               sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
           }
           String encrypPassword = sb.toString();
           rs = Connections.selectUser(email, encrypPassword);
           
           if(rs.next()){
               isvalid = true;
               if(email.equals("admin")&&password.equals("admin123")){
                   resp.sendRedirect("Main");
               }else {
                   resp.sendRedirect("html/TampilanUser.html");
               }
    
           }else {
               isvalid = false;
               pw.println("Invalid email or password");
               pw.println(" <a href=\"index.jsp\" >Masukkan kembali email password</a><br>");
        
           }
           pw.println("</body></html>");
       }catch(SQLException ex){
           Logger.getLogger(LoginPas.class.getName()).log(Level.SEVERE, null, ex);
    
       }catch (NoSuchAlgorithmException ex){
           Logger.getLogger(LoginPas.class.getName()).log(Level.SEVERE, null, ex);
    
       }
    }

    
}
    
    

