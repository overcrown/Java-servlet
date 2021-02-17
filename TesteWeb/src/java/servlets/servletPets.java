
package servlets;

import database.animais;
import database.gerenciamento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
@WebServlet(name = "servletPets", urlPatterns = {"/pets"})
public class servletPets extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String page = request.getParameter("acao");
        String forward;
        
        if (page.equalsIgnoreCase("INSERIR")) {
            forward = "mostrarPets.jsp";
            String nome = request.getParameter("nome");
            String especie = request.getParameter("especie");
            String cor = request.getParameter("cor");
            String raca = request.getParameter("raca");
            int idade = Integer.parseInt(request.getParameter("idade"));
            String castrado = request.getParameter("castrado");
            String vacinacao = request.getParameter("vacinacao");
            String dataChegada = request.getParameter("dataChegada");
            String adotado = request.getParameter("adotado");
            String nascimento = request.getParameter("nascimento");
            String porte = request.getParameter("porte");
            int adotante = 0;
            int cadastrador = Integer.parseInt(request.getParameter("cadastrador"));
            String observacao = request.getParameter("observacao");
            
            
            animais animal = new animais(nome, especie, cor, raca, idade, castrado, vacinacao, dataChegada, adotado, adotante,nascimento, porte, cadastrador,observacao);
            gerenciamento b = new gerenciamento();
            b.inserir(animal); 
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarPets.jsp");             
        }else if (page.equalsIgnoreCase("mostrar")) {
            //forward = "mostrarPets.jsp";
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarPets.jsp");
        }else if (page.equalsIgnoreCase("delete")) {
            //forward = "mostrarPets.jsp";
            int user = Integer.parseInt(request.getParameter("userId"));
            gerenciamento dados = new gerenciamento();
            dados.delete(user);
            //RequestDispatcher view = request.getRequestDispatcher(forward); 
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarPets.jsp");
        }else if (page.equalsIgnoreCase("editar")) {
            forward = "editar.jsp";
        }else if (page.equalsIgnoreCase("buscar")) {
            forward = "resultPet.jsp";
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nome = request.getParameter("nome");
            String especie = request.getParameter("especie");
            ArrayList<animais> lista = new ArrayList<>();
            gerenciamento dados = new gerenciamento();
            request.setAttribute("lista", dados.buscarAnimal(codigo, nome, especie));
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
