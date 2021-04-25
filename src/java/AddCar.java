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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author kamel
 */
public class AddCar extends HttpServlet {

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
        processRequest(request, response);
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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String manufacturer = request.getParameter("manufacturer");
            String model = request.getParameter("model");
            String type = request.getParameter("type");
            String year = request.getParameter("year");
            String miles = request.getParameter("miles");
            String price = request.getParameter("price");
            String hasAC = request.getParameter("hasAC");
            String hasDVD = request.getParameter("hasDVD");
            String comments = request.getParameter("comments");

            //Loading and register a JDBC Driver
            Class.forName(JDBC_DRIVER);

            //Establishing a Connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO Cars (Manufacturer, Model, `Type`, "
                    + "YearOfManufacturing, Miles, Price, HasAC, HasDVD, Comments, "
                    + "CreationDateTime) VALUES (?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, NOW())";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, manufacturer);                     // 1 specifies the first parameter in the query  
            pStmt.setString(2, model);             // 2 specifies the second parameter in the query
            pStmt.setString(3, type);
            pStmt.setString(4, year);
            pStmt.setString(5, miles);
            pStmt.setString(6, price);
            if (hasAC != null) {
                hasAC = "T";
            } else {
                hasAC = "F";
            }
            pStmt.setString(7, hasAC);

            if (hasDVD != null) {
                hasDVD = "T";
            } else {
                hasDVD = "F";
            }

            pStmt.setString(8, hasDVD);
            pStmt.setString(9, comments);

            int k = pStmt.executeUpdate();     // returns number of affected rows

            if (k == 1) {
                //insert a record success
                response.sendRedirect("BrowseAllCars");
            } else // i.e.  k = 0
            {
                //insert a record error
                response.sendRedirect("Add_Car_for_Sale.html");
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
            out.close();
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
