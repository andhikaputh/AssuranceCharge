/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import utils.Connections;
/**
 *
 * @author andhi
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet{

   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        Connections.connect();
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmpassword = req.getParameter("confirm_password");
        
        pw.println("<html><body>");
        if(email.isEmpty()||password.isEmpty()||confirmpassword.isEmpty()){
            pw.println("Email atau password kosong");
        }else if(!password.equals(confirmpassword)){
            pw.println("Password dan konfirmasi tidak sama");
        }else {
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[]bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                 sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashpassword = sb.toString();
            
            if(Connections.createuser(email, hashpassword)){
                resp.sendRedirect("index.jsp");
            }else {
                pw.println("gagal");
            }
            }
            catch(NoSuchAlgorithmException e){
                pw.print(e);
            }
        }
        
        pw.println("</html></body>");
    }
    
    
}