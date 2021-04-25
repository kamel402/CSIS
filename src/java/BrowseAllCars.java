/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author kamel
 */
public class BrowseAllCars extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // JDBC driver name and database URL
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/CSIS_DB";

    //  Database credentials
    static final String USER = "your User account";
    static final String PASS = "your password";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, inital-scale=1.0\">");
            out.println("<title>All Cars</title>");
            out.println("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"images/head-logo.png\"/>");
            out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
            out.println("<script type=\"text/javascript\" src=\"js/site.js\"></script>");
            out.println("</head>");
            
            out.println("<body>");
            
            out.println("<div class=\"container\">");
            out.println("<div class=\"navbar\">");
            out.println("<div class=\"logo\">");
            out.println("<img src=\"images/kfix.png\">");
            out.println("</div>");
            out.println("<nav>");
            out.println("<ul id=\"MenuItems\">");
            out.println("<li><a href=\"Add_Car_for_Sale.html\">Add Car for Sale</a></li>");
            out.println("<li><a href=\"BrowseAllCars\">Browse All Cars</a></li>");
            out.println("</ul>");
            out.println("</nav>");
            out.println("<img src=\"images/menu.png\" class=\"menu-icon\">");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class=\"add-car\">");
            out.println("<div class=\"container\">");
            out.println("<div class=\"title\">");
            out.println("All Cars");
            out.println("</div>");
            out.println("<div class=\"table-responsive\">");
            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "select CarID, Manufacturer, Model, Type, YearOfManufacturing, "
                    + "Miles, Price, CreationDateTime from Cars";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.isBeforeFirst()) {

            } else {

                out.println("<table>");
                out.println("<tr id=\"tableHeader\">");
                out.println("<th>ID</th>");
                out.println("<th>Manufacturer</th>");
                out.println("<th>Model</th>");
                out.println("<th>Type</th>");
                out.println("<th>Year of manufacturer</th>");
                out.println("<th>Miles</th>");
                out.println("<th>Price</th>");
                out.println("<th>Creation Date Time</th>");
                out.println("</tr>");

                while (rs.next()) {
                    out.println("<tr class=\"tableRow\">");

                    out.println(" <td>" + rs.getInt("CarID") + " </td> ");
                    out.println(" <td>" + rs.getString("Manufacturer") + " </td> ");
                    out.println(" <td>" + rs.getString("Model") + " </td> ");
                    out.println(" <td>" + rs.getString("Type") + " </td> ");
                    out.println(" <td>" + rs.getInt("YearOfManufacturing") + " </td> ");
                    out.println(" <td>" + rs.getInt("Miles") + " </td> ");
                    out.println(" <td>" + rs.getFloat("Price") + " </td> ");
                    out.println(" <td>" + rs.getTimestamp("CreationDateTime") + " </td> ");

                    out.println("</tr>");

                }

                out.println("</table>");

            }

        } catch (Exception ex) {
            //throw new ServletException(ex);
            out.println("There was an error exception meesage: ");

        } finally {
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            
            out.println("<div class=\"footer\">");
            out.println("<div class=\"container\">");
            out.println("<div class=\"footer-content\">");
            out.println("<h3>KCAR</h3>");
            out.println("<p>");
            out.println("car sale information system");
            out.println("</p>");
            out.println("<ul class=\"socials\">");
            out.println("<li><a href=\"#\"><img src=\"images/facebook.svg\" alt=\"\"></a></li>");
            out.println("<li><a href=\"#\"><img src=\"images/twitter-sign.svg\" alt=\"\"></a></li>");
            out.println("<li><a href=\"#\"><img src=\"images/google-plus.svg\" alt=\"\"></a></li>");
            out.println("<li><a href=\"#\"><img src=\"images/youtube-logo.svg\" alt=\"\"></a></li>");
            out.println("<li><a href=\"#\"><img src=\"images/linkedin.svg\" alt=\"\"></a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"footer-bottom\">");
            out.println("<p>copyright &copy;2021 KCAR. designed by <span>Kamel</span></p>");
            out.println("</div>");
            out.println("</div>");
            
            
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
}
