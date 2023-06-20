/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pasien;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author andhi
 */
@WebServlet(name = "predict", urlPatterns = {"/predict"})
public class predict extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>\n" +
"<head>\n" +
"<style>\n" +
"* {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
"input[type=text], select, textarea {\n" +
"  width: 100%;\n" +
"  padding: 12px;\n" +
"  border: 1px solid #ccc;\n" +
"  border-radius: 4px;\n" +
"  resize: vertical;\n" +
"}\n" +
"\n" +
"label {\n" +
"  padding: 12px 12px 12px 0;\n" +
"  display: inline-block;\n" +
"}\n" +
"\n" +
"input[type=submit] {\n" +
"  background-color: #04AA6D;\n" +
"  color: white;\n" +
"  padding: 12px 20px;\n" +
"  border: none;\n" +
"  border-radius: 4px;\n" +
"  cursor: pointer;\n" +
"  float: right;\n" +
"}\n" +
"\n" +
"input[type=submit]:hover {\n" +
"  background-color: #45a049;\n" +
"}\n" +
"\n" +
".container {\n" +
"  border-radius: 5px;\n" +
"  background-color: #f2f2f2;\n" +
"  padding: 20px;\n" +
"}\n" +
"\n" +
".col-25 {\n" +
"  float: left;\n" +
"  width: 25%;\n" +
"  margin-top: 6px;\n" +
"}\n" +
"\n" +
".col-75 {\n" +
"  float: left;\n" +
"  width: 75%;\n" +
"  margin-top: 6px;\n" +
"}\n" +
"\n" +
"/* Clear floats after the columns */\n" +
".row::after {\n" +
"  content: \"\";\n" +
"  display: table;\n" +
"  clear: both;\n" +
"}\n" +
"\n" +
"/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */\n" +
"@media screen and (max-width: 600px) {\n" +
"  .col-25, .col-75, input[type=submit] {\n" +
"    width: 100%;\n" +
"    margin-top: 0;\n" +
"  }\n" +
"}\n" +
"</style>\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<h2>Predict Your Assurance Charge</h2>\n" +
"<p>We help you to count assurance charge</p>\n" +
"\n" +
"<div class=\"container\">\n" +
"<form method=\"post\" action=\"predict\" >"+
                   
"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"fname\">Age</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <input type=\"text\" id=\"age\" name=\"age\" placeholder=\"Umur anda..\">\n" +
"    </div>\n" +
"  </div>\n" +
                   
"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"country\">Gender</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <select id=\"gender\" name=\"gender\">\n" +
"        <option value=\"0\">Female</option>\n" +
"        <option value=\"1\">Male</option>\n" +
"      </select>\n" +
"    </div>\n" +
"  </div>\n" +

"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"fname\">BMI</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <input type=\"text\" id=\"bmi\" name=\"bmi\" placeholder=\"Total BMI anda..\">\n" +
"    </div>\n" +
"  </div>\n" +
                   
"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"fname\">Total Anak</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <input type=\"text\" id=\"children\" name=\"children\" placeholder=\"Total anak yang anda miliki..\">\n" +
"    </div>\n" +
"  </div>\n" +
                   
"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"smoker\">Perokok</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <select id=\"smoker\" name=\"smoker\">\n" +
"        <option value=\"1\">Yes</option>\n" +
"        <option value=\"0\">No</option>\n" +
"      </select>\n" +
"    </div>\n" +
"  </div>\n" +  
                   
"  <div class=\"row\">\n" +
"    <div class=\"col-25\">\n" +
"      <label for=\"region\">Kota</label>\n" +
"    </div>\n" +
"    <div class=\"col-75\">\n" +
"      <select id=\"region\" name=\"region\">\n" +
"        <option value=\"0\">Southwest</option>\n" +
"        <option value=\"1\">Southeast</option>\n" +
"        <option value=\"2\">Northwest</option>\n" +
"        <option value=\"3\">Northeast</option>\n" +
"      </select>\n" +
"    </div>\n" +
"  </div>\n" +  
                   

"  </div>\n" +
                   

"  <div class=\"row\">\n" +
"    <input type=\"submit\" value=\"Submit\">\n" +
"  </div>\n" +
"  </form>\n" +
"</div>\n" +
"\n" +
"</body>\n" +
"</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h2>Hasil prediksi salary</h2>");
        String stringAge = req.getParameter("age");
        int age = Integer.parseInt(stringAge);
        
        String stringGender = req.getParameter("gender");
        
        String stringBMI = req.getParameter("bmi");
        float bmi = Float.parseFloat(stringBMI);
        
        String stringChildren = req.getParameter("children");
        int children = Integer.parseInt(stringChildren);
        
        String stringSmoker = req.getParameter("smoker");
        
        String stringRegion = req.getParameter("region");
        float region = Float.parseFloat(stringRegion);
        
        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                "C:/Users/andhi/TugasTIA.py",
                "C:/Users/andhi/insuranceasli.csv",
                stringAge,stringGender,stringBMI,stringChildren,stringSmoker,stringRegion);
        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line = reader.readLine())!= null){
            writer.println("<h4> Charges Assurance = "  + line + "</h4>");
            System.out.println(line);
        }
        writer.println("<a href=\"html/TampilanUser.html\">Kembali ke Menu Utama</a>");
        writer.println("</html>");
    }
    
    
}