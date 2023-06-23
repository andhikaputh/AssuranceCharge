
package pasien;


import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Connections;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.text.DecimalFormat;
@WebServlet(name = "ShowPas", urlPatterns = {"/ShowPas"})
public class ShowPas extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(LoginPas.isvalid==true){
            try{
                showall(resp);
            }catch(SQLException ex){
                Logger.getLogger(ShowPas.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
    }

    
    
    public static void showall(HttpServletResponse resp)throws IOException,SQLException{
        ResultSet rs = null;
        PrintWriter pw = resp.getWriter();
         try{
            rs = Connections.selectALL("datapasien");
            DecimalFormat df = new DecimalFormat("###,###.##");
            pw.println("<html lang=\"en\">\n" +
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

"                <ul class=\"nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start\" id=\"menu\">\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"Main\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">Home</span>\n" +
"                        </a>\n" +
"                    </li>\n" +
"                    <li class=\"nav-item\">\n" +
"                        <a href=\"ShowPas\" class=\"nav-link align-middle px-0\">\n" +
"                            <i class=\"fs-4 bi-house\"></i> <span class=\"ms-1 d-none d-sm-inline\">CRUD Table</span>\n" +
"                        </a>\n" +
"                    </li>\n" +

"                        \n" +
"               \n" +
"            </div>\n" +
"        </div>\n" +
"        <div class=\"col py-3\">\n" +
"            <section class=\"main\">\n" +
"      <div class=\"main-top\">\n" +
"        <h1>CRUD Table</h1>\n" +

"      </div>\n" +
"      <table class=\"table\">\n" +
"  <thead>\n" +
"    <tr>\n" +
"      <th scope=\"col\">ID</th>\n" +
"      <th scope=\"col\">Age</th>\n" +
"      <th scope=\"col\">Gender</th>\n" +
"      <th scope=\"col\">BMI</th>\n" +
"      <th scope=\"col\">Children</th>\n" +
"      <th scope=\"col\">Smoker</th>\n" +
"      <th scope=\"col\">Region</th>\n" +
"      <th scope=\"col\">Charges</th>\n" +
"      <th scope=\"col\">Edit</th>\n" +
"      <th scope=\"col\">Delete</th>\n" +
"    </tr>\n" +
"  </thead>");
           
          
            while(rs.next()){
                int id= rs.getInt("id");
                int age=rs.getInt("age");
                String gendervalue = rs.getString("gender").replace(" ","");
                float bmi = rs.getFloat("bmi");
                int children = rs.getInt("children");
                String smoker = rs.getString("smoker");
                String region = rs.getString("region");
                float charges = rs.getFloat("charges");
                
                pw.println("<tbody>");
                pw.println("<tr>");
               pw.println("<td>"+id+"</td>");
               pw.println("<td>"+age+"</td>");
               pw.println("<td>"+gendervalue+"</td>");
               pw.println("<td>"+bmi+"</td>");
               pw.println("<td>"+children+"</td>");
               pw.println("<td>"+smoker+"</td>");
               pw.println("<td>"+region+"</td>");
               String formatcharge = df.format(charges);
               pw.println("<td>"+formatcharge+"</td>");
               pw.println("<td><a href = UpdatePas?id="+id+"&age="+age+"&gender="+gendervalue+"&bmi="+bmi+"&children="+children+"&smoker="+smoker+"&region="+region+"&charges="+charges+">Edit</a></td>");
               pw.println("<td><a href = DeletePas?id="+id+"&age="+age+"&gender="+gendervalue+"&bmi="+bmi+"&children="+children+"&smoker="+smoker+"&region="+region+"&charges="+charges+">Delete</a></td>");
               pw.println("</tr>");
               pw.println("</tbody>");
            }
            pw.println("</table>");
//            pw.println("<br>");
//            pw.println("<a href=\"Main\" >Menuju tampilan awal</a>");
            pw.println("</body>");
            pw.println("</html>");
            }catch(SQLException ex){
                pw.print(ex);
            }
    }
    
}