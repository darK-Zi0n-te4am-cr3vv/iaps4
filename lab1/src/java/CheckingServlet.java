/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Властитель
 */
public class CheckingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // PrintWriter out = response.getWriter();
        String points="";
        try{
            points=request.getParameter("xselect")+";"+request.getParameter("yselect")+";"+request.getParameter("rselect");
            request.setAttribute("Points", points);
            double x = Double.parseDouble(request.getParameter("xselect"));
            double y= Double.parseDouble(request.getParameter("yselect"));
            double r= Double.parseDouble(request.getParameter("rselect"));
            
            
            Checking.CheckThrow(r, x, y);
            
            request.setAttribute("isHit",String.valueOf(Checking.LastState));
            request.setAttribute("Error",null);
            
            //out.append(String.valueOf(Checking.LastState));
        }
        catch(Exception ex)
        {
            
            request.setAttribute("isHit",String.valueOf(false));
            request.setAttribute("Error",ex);
        }
        finally
        {
            //out.close();
        }
        
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
