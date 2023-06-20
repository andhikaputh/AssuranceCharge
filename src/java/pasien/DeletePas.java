/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pasien;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import utils.Connections;

/**
 *
 * @author andhi
 */
@WebServlet(name = "DeletePas", urlPatterns = {"/DeletePas"})
public class DeletePas extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        if(LoginPas.isvalid==true){
           String id = req.getParameter("id");
           String age = req.getParameter("age");
           String gender = req.getParameter("gender");
           String bmi = req.getParameter("bmi");
           String children = req.getParameter("children");
           String smoker = req.getParameter("smoker");
           String region = req.getParameter("region");
           String charges = req.getParameter("charges");
           
           pw.println("<html><body>");
           pw.println("<h2>Hapus Data Pasien</h2>");
            pw.println("<form action=\"DeletePas\" method=\"post\">");
            pw.println("id          :     <input type=\"text\" size=\"2\" name=\"id\""  +
                    " value="+id+" readonly><br/><br/>");
            pw.println("Age         :    <input type=\"text\" size=\"25\" name=\"age\"" +
                    " value="+age+"><br/><br/>");
            pw.println("Gender      :     <input type=\"text\" size=\"25\" name=\"gender\""  +
                    " value="+gender+"><br/><br/>");
            pw.println("BMI         :     <input type=\"text\" size=\"25\" name=\"bmi\""  +
                    " value="+bmi+"><br/><br/>");
            pw.println("Children    :     <input type=\"text\" size=\"25\" name=\"children\""  +
                    " value="+children+"><br/><br/>");
            pw.println("Smoker      :     <input type=\"text\" size=\"25\" name=\"smoker\""  +
                    " value="+smoker+"><br/><br/>");
            pw.println("Region      :     <input type=\"text\" size=\"25\" name=\"region\""  +
                    " value="+region+"><br/><br/>");
            pw.println("Charges     :     <input type=\"text\" size=\"25\" name=\"charges\""  +
                    " value="+charges+"><br/><br/>");
            pw.println("<input type=\"submit\" value=\"Hapus\"/>");
            pw.println("</form>");
            pw.println("</pre>");
           pw.println("</html></body>");
           pw.flush();
        }else {
            LoginPas.unauthorizedAccess(resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw =resp.getWriter();
        String idpas = req.getParameter("id");
        int id = Integer.parseInt(idpas);
        
        try{
            if(Connections.delete(id)){
                pw.println("Data berhasil di delete");
            }
        }catch(Exception e){
            pw.println(e);
        }
        pw.println("<html><body>");
        pw.println("<a href=\"Main\">Kembali ke halaman utama</a></br>");
        
        pw.println("</html></body>");
    }
    
    
    
}