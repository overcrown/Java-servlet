/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.estoque.Estoque;
import br.com.estoque.gerenciamentoEstoque;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
@WebServlet(name = "servletEstoques", urlPatterns = {"/servletEstoques"})
public class servletEstoques extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("acao");
        String forward;
        
        if (page.equalsIgnoreCase("INSERIR")) {
            forward = "mostrarEstoque.jsp";
            String item = request.getParameter("item");
            String categoria = request.getParameter("categoria");
            String quantidade = request.getParameter("quantidade");
     
            Estoque produto = new Estoque(item, categoria, quantidade);
            gerenciamentoEstoque b = new gerenciamentoEstoque();
            b.inserirEstoque(produto);             
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarEstoque.jsp");
                       
        }else if (page.equalsIgnoreCase("mostrar")) {
            forward = "mostrarEstoque.jsp";
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarEstoque.jsp");
        }else if (page.equalsIgnoreCase("delete")) {
            //forward = "mostrarEstoque.jsp";
            int user = Integer.parseInt(request.getParameter("userId"));
            gerenciamentoEstoque dados = new gerenciamentoEstoque();
            dados.deleteItem(user);
            //RequestDispatcher view = request.getRequestDispatcher(forward); 
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarEstoque.jsp");
        }else if (page.equalsIgnoreCase("editar")) {
            forward = "editarAdotante.jsp";
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarEstoque.jsp");
        }else if (page.equalsIgnoreCase("buscar")) {
            forward = "resultEstoque.jsp";
            //int codigo = Integer.parseInt(request.getParameter("codigo"));
            String item = request.getParameter("item");
            //String categoria = request.getParameter("categoria");
            ArrayList<Estoque> lista = new ArrayList<>();
            gerenciamentoEstoque dados = new gerenciamentoEstoque();
            lista = dados.buscarItem(item);
            request.setAttribute("lista", lista);
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
            
        }
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
