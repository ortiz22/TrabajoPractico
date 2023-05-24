<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Registro de Profesor</h1>
        <form action="<%= request.getContextPath()%>/ProfesorServlet" method="GET">
            <label>Id:</label>
            <input type="text" name="Id">
            <br>
            <label>Nombre:</label>
            <input type="text" name="nombre">
            <br>
            <label>Título:</label>
            <input type="text" name="título">
            <br>
            <label>Email:</label>
            <input type="text" name="email">
            <br>
            <label>Salario:</label>
            <input type="text" name="salario">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>

