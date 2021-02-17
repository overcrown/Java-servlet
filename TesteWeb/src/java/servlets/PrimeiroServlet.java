/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Teste;
import database.gerenciamento;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
@WebServlet(name = "requisitions", urlPatterns = {"/requisitions"})
public class PrimeiroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static String INSERT  = "/insert.jsp";
    //private static String INICIO = "/index.html";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("salvar");
        String forward;
        
        if (page.equalsIgnoreCase("insertPage")) {
            forward = "index.jsp";
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);                
        }else if (page.equalsIgnoreCase("insertData")) {
            //forward = "insert.jsp";
            String nome = request.getParameter("nome");
            String ra = request.getParameter("ra");
            Teste a = new Teste(nome, ra);
            gerenciamento b = new gerenciamento();
            b.testeInserir(a); 
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            //response.sendRedirect("");
            page = "showPage";           
        }else if (page.equalsIgnoreCase("showPage")) {
            forward = "mostrarPets.jsp";
            //gerenciamento dados = new gerenciamento();
            //ArrayList<Teste> lista = dados.mostrarTeste();
            //request.setAttribute("users", lista);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }else if (page.equalsIgnoreCase("delete")) {
            forward = "mostrarPets.jsp";
            int user = Integer.parseInt(request.getParameter("userId"));
            gerenciamento dados = new gerenciamento();
            dados.delete(user);
            RequestDispatcher view = request.getRequestDispatcher(forward); 
            view.forward(request, response);
        }
    }
    //<% ArrayList<Teste> obj = (ArrayList<Teste>)request.getAttribute("users"); %>

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
