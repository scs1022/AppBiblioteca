/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Articulo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */

@Service
public interface IArticulo {
    public List<Articulo> listarTodosArticulos();
    
}
