package com.appBiblioteca.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
;

import com.appBiblioteca.services.IUsuario;

import org.springframework.ui.Model;
import com.appBiblioteca.entity.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class RegistroController {

    @Autowired
    IUsuario usuarioService;

    @PostMapping("/registrar")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuarioDTO) {

        if (usuarioService.crearUsuario(usuarioDTO)) {
            System.out.println(usuarioDTO);
            return "redirect:/registro?exito";
        }
        return "redirect:/registro?error";

    }

    @GetMapping("/registro")
    public String getRegistro(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "registro";
    }
}