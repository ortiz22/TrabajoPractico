/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analia;
import com.analia.dao.ProfesorDAOImpl;
import com.analia.model.Profesor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.analia.dao.ProfesorDAO;


@WebServlet(urlPatterns = "/ProfesorServlet")
public class ProfesorServlet extends HttpServlet{
 
    private ProfesorDAO profesorDAO;

public ProfesorServlet() {
    super();
    profesorDAO = new ProfesorDAOImpl();
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.procesarSolicitud(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.procesarSolicitud(req, resp);
}

protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    switch (request.getParameter("action")) {
        case "list":
            // this.list(request, response);
            break;
        case "create":
            this.create(request, response);
            break;
        case "read":
            // this.read(request, response);
            break;
        case "update":
            // this.update(request, response);
            break;
        case "delete":
            // this.delete(request, response);
            break;
        case "showRegister":
            this.showRegister(request, response);
            break;
        case "index":
            this.index(request, response);
            break;
        default:
            this.index(request, response);
            break;
    }
}

private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
}

private void showRegister(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
    dispatcher.forward(request, response);
}

private void create(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nombre = request.getParameter("nombre");
    String titulo = request.getParameter("titulo");
    String email = request.getParameter("email");
    String salario = request.getParameter("salario");

    // Crear el objeto que se envía a la base de datos
    Profesor profesor = new Profesor();
    profesor.setNombre(nombre);
    profesor.setTitulo(titulo);
    profesor.setEmail(email);
    profesor.setSalario(salario);

    profesorDAO.insert(profesor);

    // Redireccionar al "index"
    this.index(request, response);
}
}



