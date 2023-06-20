/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pasien;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Connections;

/**
 *
 * @author andhi
 */
@WebServlet(name = "UpdatePas", urlPatterns = {"/UpdatePas"})
public class UpdatePas extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(LoginPas.isvalid==true){
           String id = req.getParameter("id");
           String age = req.getParameter("age");
           String gender = req.getParameter("gender");
           String bmi = req.getParameter("bmi");
           String children = req.getParameter("children");
           String smoker = req.getParameter("smoker");
           String region = req.getParameter("region");
           String charges = req.getParameter("charges");
           
           PrintWriter pw = resp.getWriter();
           pw.println("<html><body>");
           pw.println("<h2>Edit Data Pasien</h2>");
            pw.println("<form action=\"UpdatePas\" method=\"post\">");
            pw.println("id          :     <input type=\"text\" size=\"2\" name=\"id\""  +
                    " value="+id+" readonly><br/>");
            pw.println("Age         :    <input type=\"text\" size=\"25\" name=\"age\"" +
                    " value="+age+"><br/>");
            pw.println("Gender      :     <input type=\"text\" size=\"25\" name=\"gender\""  +
                    " value="+gender+"><br/>");
            pw.println("BMI         :     <input type=\"text\" size=\"25\" name=\"bmi\""  +
                    " value="+bmi+"><br/>");
            pw.println("Children    :     <input type=\"text\" size=\"25\" name=\"children\""  +
                    " value="+children+"><br/>");
            pw.println("Smoker      :     <input type=\"text\" size=\"25\" name=\"smoker\""  +
                    " value="+smoker+"><br/>");
            pw.println("Region      :     <input type=\"text\" size=\"25\" name=\"region\""  +
                    " value="+region+"><br/>");
            pw.println("Charges     :     <input type=\"text\" size=\"25\" name=\"charges\""  +
                    " value="+charges+"><br/>");
            pw.println("<input type=\"submit\" value=\"Simpan\"/>");
            pw.println("</form>");
            pw.println("</pre>");
           pw.println("</html></body>");
           pw.flush();
       }else{
           LoginPas.unauthorizedAccess(resp);
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter sc = resp.getWriter();
        String paramid = req.getParameter("id");
        int id = Integer.parseInt(paramid);
        
        String paramage = req.getParameter("age");
        int age = Integer.parseInt(paramage);
        
        String gender = req.getParameter("gender");
        
        String parambmi = req.getParameter("bmi");
        float bmi = Float.parseFloat(parambmi);
        
        String paramchild = req.getParameter("children");
        int children = Integer.parseInt(paramchild);
        
        String smoker = req.getParameter("smoker");
        
        String region = req.getParameter("region");
        
        String paramcharge = req.getParameter("charges");
        float charges = Float.parseFloat(paramcharge);
        
        try{
            if(Connections.update(id,age, gender, bmi, children, smoker, region, charges)){
                sc.println("Berhasil");
            }else {
                sc.println("Gagal");
            }
        }catch(SQLException ex){
            Logger.getLogger(UpdatePas.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        sc.println("<html><body>");
        sc.println("<a href=\"Main\">Kembali ke halaman utama</a></br>");
        
        sc.println("</html></body>");
        sc.flush();
    }
    
    
}