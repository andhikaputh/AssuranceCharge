/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pasien;

import utils.Connections;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author andhi
 */
@WebServlet(name = "MainUser", urlPatterns = {"/MainUser"})
public class MainUser extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connections.connect();
        PrintWriter writer = resp.getWriter();
        if(LoginPas.isvalid==true){
            writer.println("<html lang=\"en\">\n" +
"<head>\n" +
"    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n" +
"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n" +
"\n" +
"  <meta charset=\"UTF-8\" />\n" +
"  <title>Dashboard | By Code Info</title>\n" +
"  <link rel=\"stylesheet\" href=\"style1.css\" />\n" +
"  <!-- Font Awesome Cdn Link -->\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\"/>\n" +
"</head>\n" +
"<body>\n" +
"  <div class=\"container-fluid\">\n" +
"    <div class=\"row flex-nowrap\">\n" +
"        <div class=\"col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark\">\n" +
"            <div class=\"d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100\">\n" +

"                    <span class=\"fs-5 d-none d-sm-inline\">Menu</span>\n" +
"                </a>\n" +
"                <ul class=\"nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start\" id=\"menu\">\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"MainUser\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">Home</span>\n" +
"                        </a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"ShowPasUser\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">Assurance Data</span>\n" +
"                        </a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"InsertPas\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">Insert Data Assurance</span>\n" +
"                        </a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"Logout\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">Logout</span>\n" +
"                        </a>\n" +
"                    </li>\n" +
"                        \n" +
"               \n" +
"            </div>\n" +
"        </div>\n" +
"        <div class=\"col py-3\">\n" +
"            Selamat datang USER\n" +
"     \n" +
"\n" +
"\n" +
"    \n" +
"</body>\n" +
"</html>\n" +
"");
            writer.flush();
        }else {
            LoginPas.unauthorizedAccess(resp);
        }
        
    }
    
}