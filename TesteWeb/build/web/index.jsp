<%-- 
    Document   : index
    Created on : 16/11/2020, 23:33:07
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="requisitions" method="get" > 
            NOME <input type="text" name="nome" />
            RA <input type="text" name="ra" />
            SALVAR <input type="submit" name="salvar" value="insertData" />
            <a href="http:/localhost:8080/TesteWeb/index.html" >VOLTAR</a>
        </form>
    </body>
</html>
