
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.adotantes.gerenciamentoAdotante;
import br.com.adotantes.Adotante;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author gabri
 */
@WebServlet(name = "servletAdotante", urlPatterns = {"/adotante"})
public class servletAdotante extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("acao");
        String forward;
        
        if (page.equalsIgnoreCase("INSERIR")) {
            //forward = "mostrarAdotantes.jsp";
            String nome = request.getParameter("nome");
            int idade = Integer.parseInt(request.getParameter("idade"));
            String nascimento = request.getParameter("nascimento");
            String endereco = request.getParameter("endereco");
            int endereco_numero = Integer.parseInt(request.getParameter("endereco_numero"));
            int rg = Integer.parseInt(request.getParameter("rg"));
            int cpf = Integer.parseInt(request.getParameter("cpf"));
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");
            String aptidao = request.getParameter("aptidao");          
            String documento = request.getParameter("documento");
            String observacao = request.getParameter("observacao");
            
            Adotante adotador = new Adotante(nome, idade, nascimento, endereco, endereco_numero, rg, cpf, telefone, celular, email, aptidao, documento, observacao);
            gerenciamentoAdotante b = new gerenciamentoAdotante();
            b.inserirAdotante(adotador); 
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarAdotantes.jsp");
                       
        }else if (page.equalsIgnoreCase("mostrar")) {
            //forward = "mostrarAdotantes.jsp";
            //RequestDispatcher view = request.getRequestDispatcher(forward);
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarAdotantes.jsp");
        }else if (page.equalsIgnoreCase("delete")) {
            //forward = "mostrarAdotantes.jsp";
            int user = Integer.parseInt(request.getParameter("userId"));
            gerenciamentoAdotante dados = new gerenciamentoAdotante();
            dados.deleteAdotante(user);
            //RequestDispatcher view = request.getRequestDispatcher(forward); 
            //view.forward(request, response);
            response.sendRedirect("http://localhost:8080/TesteWeb/mostrarAdotantes.jsp");
        }else if (page.equalsIgnoreCase("editar")) {
            forward = "editar.jsp";
        }else if (page.equalsIgnoreCase("buscar")) {
            forward = "resultAdotante.jsp";
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nome = request.getParameter("nome");
            int idade = Integer.parseInt(request.getParameter("idade"));                
            gerenciamentoAdotante dados = new gerenciamentoAdotante();
            request.setAttribute("lista", dados.buscarAdotante(codigo, nome, idade));
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
