/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.analia.dao;

import com.analia.model.Profesor;
import java.util.List;

public interface ProfesorDAO {
    
    public List<Profesor> findAll();
    public Profesor insert(Profesor objProfesor);
    public Profesor findById(Integer id);
    public Profesor updateById(Integer id, Profesor objProfesor);
    public Boolean deleteById(Integer id);
}


