/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Articulo;
import com.appBiblioteca.repository.ArticulosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
public class ArticuloImp implements IArticulo{
    
    @Autowired
    private ArticulosRepository repositorio;
    @Override
    public List<Articulo> listarTodosArticulos() {
        return repositorio.findAll();
    }
    
}
