<%@page import ="database.animais" %>
<%@page import="java.util.ArrayList" %>
<%@page import="database.gerenciamento"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
        <title>MOSTRAR ANIMAIS</title>
        <style>
            a#links {
                padding:0px;
            }
            table#estoque {
                display:block;
                position:relative;
                top: 50px;
                left:0px;
                font-size: 9pt;
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
    
<a href="insertPets.html" id="adicionar"><b>ADICIONAR</b></a>
<% gerenciamento dados = new gerenciamento();%>
<% ArrayList<animais> obj = dados.mostrarCachorro(); %>  

<table id="estoque">
    <thead>
        <tr>
            <th>CÓDIGO</th>
            <th>NOME</th>
            <th>ESPÉCIE</th>
            <th>COR</th>
            <th>RAÇA</th>
            <th>IDADE</th>
            <th>CASTRADO</th>
            <th>VACINAS</th>
            <th>DATA DE CHEGADA</th>
            <th>ADOTADO</th>
            <th>NASCIMENTO</th>
            <th>PORTE</th>
            <th>ADOTANTE</th>
            <th>CÓDIGO DO CADASTRADOR</th>
            <th>OBSERVAÇÃO</th>
        </tr>
    </thead>
    <tbody>
        <% for(animais c:obj){ %>
        <tr>
            <td><%=c.getCodigo() %> - </td>
            <td><%=c.getNome()%> - </td>
            <td><%=c.getEspecie()%> </td>
            <td><%=c.getCor()%> - </td>
            <td><%=c.getRaca()%> - </td>
            <td><%=c.getIdade()%> - </td>
            <td><%=c.getCastrado()%> - </td>
            <td><%=c.getVacinacao()%> - </td>
            <td><%=c.getDataChegada()%> - </td>
            <td><%=c.getAdotado()%> - </td>
            <td><%=c.getNascimento()%> - </td>
            <td><%=c.getPorte()%> - </td>
            <td><%=c.getAdotante()%> - </td>
            <td><%=c.getCadastrador()%> - </td>
            <td><%=c.getObservacao()%> - </td>
            <%String user = Integer.toString(c.getCodigo()); %>
            <td><a href="pets?acao=delete&userId=<%=user %>" id="links">DELETAR</a></td>
            <td><a href="pets?acao=editar&userId=<%=user%>" id="links" >EDITAR</a></td>
        </tr>
        <%} %>      
    </tbody>
</table>
</body>
</html>
