<%@page import ="br.com.estoque.Estoque" %>
<%@page import="java.util.ArrayList" %>
<%@page import="br.com.estoque.gerenciamentoEstoque"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
        <link rel="stylesheet" type="text/css" href="css/mostrar.css"/>
        <title>MOSTRAR ITENS</title>
    </head>
    <style>
        /*
        table#estoque {
            position: absolute;
            display:block;
            left:20px;
         
        }
        thead#colunas th{
            display:inline-block;
            margin-right: 40px;
        }
        table#estoque td {
            display: inline-block;
            margin-right: 85px;
            padding:5px;
            vertical-align: middle;
        }*/
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
       
<a href="insertEstoque.html" id="adicionar"><b>ADICIONAR</b></a>
<% ArrayList<Estoque> obj = (ArrayList<Estoque>)request.getAttribute("lista");%>
<table id="estoque">
    <thead id="colunas">
        <tr>
            <th>CÓDIGO</th>
            <th>ITEM</th>
            <th>CATEGORIA</th>
            <th>QUANTIDADE</th>
        </tr>
    </thead>  
    <tbody id="corpo">      
        <% for(Estoque c:obj){ %>
        <%String user = Integer.toString(c.getCodigo()); %>
        <tr id="dados">
            <td><%=c.getCodigo() %></td>
            <td><%=c.getItem()%></td>
            <td><%=c.getCategoria()%></td>
            <td><%=c.getQuantidade()%></td>          
            <td><a href="servletEstoques?acao=delete&userId=<%=user%>" id="links"><b>DELETAR</b></a></td>
            <td><a href="servletEstoques?acao=editar&userId=<%=user%>" id="links"><b>EDITAR</b></a></td>           
        </tr>
        <%} %>
    </tbody>     
</table>
    
</body>
</html>
