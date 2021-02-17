<%@page import ="br.com.colaborador.Colaborador" %>
<%@page import="java.util.ArrayList" %>
<%@page import="br.com.colaborador.gerenciamentoColaborador"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
        <title>MOSTRAR VOLUNTÁRIOS</title>
        <style>
            a#links {
                padding:0px;
            }
            table#estoque {
                display:block;
                position:relative;
                top: 50px;
                left:40px;
            }
            a#adicionar {
                padding:10px;
                top: -10px;
                background-color:rgb(174, 73, 241);
            }
        </style>
    </head>
<body>

<header id="header">
<nav id="navbar">
    <ul id="lista-nav">
        <li><a href="dashboard.html">SWPETS</a></li>
        <li><a href="functionPets.html">PETS</a></li>
        <li><a href="functionAdotante.html">ADOTANTES</a></li>
        <li><a href="functionEstoque.html">ESTOQUE</a></li>
        <li><a href="login">SAIR</a></li>
    </ul>
</nav>
</header>
       
<a href="insertColaborador.html" id="adicionar"><b>ADICIONAR</b></a>
<% gerenciamentoColaborador dados = new gerenciamentoColaborador();%>
<% ArrayList<Colaborador> obj = dados.mostrarColaboradores(); %>
    
<table id="estoque">
    <thead>
        <tr>
            <th>CÓDIGO</th>
            <th>NOME</th>
            <th>IDADE</th>
            <th>NASCIMENTO</th>
            <th>ENDEREÇÕ</th>
            <th>N° DA CASA</th>
            <th>RG</th>
            <th>CPF</th>
            <th>TELEFONE</th>
            <th>CELULAR</th>
            <th>EMAIL</th>
            <th>APTIDAO</th>
            <th>DATA DE INGRESSO</th>
        </tr>
    </thead>
    <tbody>   
        <% for(Colaborador c:obj){ %>
        <tr>
            <td><%=c.getCodigo() %> - </td>
            <td><%=c.getNome()%> - </td>
            <td><%=c.getIdade()%> </td>
            <td><%=c.getNascimento()%> - </td>
            <td><%=c.getEndereco()%> - </td>
            <td><%=c.getEndereco_numero()%> - </td>
            <td><%=c.getRg()%> - </td>
            <td><%=c.getCpf()%> - </td>
            <td><%=c.getTelefone()%> - </td>
            <td><%=c.getCelular()%> - </td>
            <td><%=c.getEmail()%> - </td>
            <td><%=c.getData_inicio()%> - </td>
            <%String user = Integer.toString(c.getCodigo()); %>
            <td><a href="servletColaborador?acao=delete&userId=<%=user %>" id="links">DELETAR</a></td>
            <td><a href="servletColaborador?acao=editar&userId=<%=user%>" id="links">EDITAR</a></td>
        </tr>
        <%} %>          
    </tbody>
</table>
</body>
</html>