/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.controller;

import com.appBiblioteca.services.IArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class articuloController {
    @Autowired
    private IArticulo service;
    @RequestMapping(value="/listar",method =RequestMethod.GET )
    public String listar(Model modelo) {
        modelo.addAttribute("Articulos", service.listarTodosArticulos());
        return "listar";
    }
}
