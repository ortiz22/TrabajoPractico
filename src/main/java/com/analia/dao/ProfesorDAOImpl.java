/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.analia.dao;
import com.analia.config.Conexion;
import com.analia.model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProfesorDAOImpl implements ProfesorDAO{
    
    private Conexion objConexion;
private Connection objConnection;

public ProfesorDAOImpl() {
    objConexion = new Conexion();
}

@Override
public List<Profesor> findAll() {
    String consulta = "SELECT * FROM profesores";
    List<Profesor> listado = new LinkedList<>();

    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        ResultSet rs = prest.executeQuery();

        Profesor objProfesor;

        while (rs.next()) {
            objProfesor = new Profesor();
            objProfesor.setId(rs.getInt("Id"));
            objProfesor.setNombre(rs.getString("nombre"));
            objProfesor.setTitulo(rs.getString("titulo"));
            objProfesor.setEmail(rs.getString("email"));
            objProfesor.setSalario(rs.getString("salario"));

            listado.add(objProfesor);
        }
    } catch (Exception e) {
        System.out.println("Error en la consulta: " + e);
    }

    return listado;
}

@Override
public Profesor insert(Profesor objProfesor) {
    String consulta = "INSERT INTO profesores (nombre, titulo, email, salario) VALUES (?,?,?,?)";
    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);

        prest.setString(1, objProfesor.getNombre());
        prest.setString(2, objProfesor.getTitulo());
        prest.setString(3, objProfesor.getEmail());
        prest.setString(4, objProfesor.getSalario());

        int count = prest.executeUpdate();

        ResultSet rs = null;
        rs = prest.executeQuery("SELECT LAST_INSERT_ID()");

        int autoKey = -1;
        if (rs.next()) {
            autoKey = rs.getInt(1);
            objProfesor.setId(autoKey);
            System.out.println("Último ID insertado: " + autoKey);
        } else {
            System.out.println("No existe dato de ID");
        }

    } catch (Exception e) {
        System.out.println("Error al insertar: " + e);
    }

    return objProfesor;
}

@Override
public Profesor findById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Profesor updateById(Integer id, Profesor objProfesor) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Boolean deleteById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}
}



