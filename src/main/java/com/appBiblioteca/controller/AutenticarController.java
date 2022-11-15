package com.appBiblioteca.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.services.IUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AutenticarController {
    @Autowired IUsuario usuario;
    
    
    @GetMapping("/autenticar")
    public String getAutenticar(Model modelo) {
        modelo.addAttribute(modelo);
        return "autenticar";
    }
    
    @GetMapping("/autenticarOK")
    public String verPaginaDeInicio(Model modelo) {
        System.out.println("Modelo ");
        System.out.println(modelo.getAttribute("username"));
        
        List<Usuario> usuarios = usuario.readUsuarios();
        modelo.addAttribute("usuarios", usuarios);
            //modelo.addAttribute("estudiantes", servicioEstudiante.ConsultaTodos());
        return "index";
    }
    
    @PostMapping("/autentica")
    public String autenticar(@ModelAttribute("usuario") Usuario  usuarioDTO) {
        
        System.out.println(usuarioDTO.getCorreo());
        if (!usuario.autenticar(usuarioDTO)) {
            System.out.println(usuarioDTO);
            return "redirect:/autenticar?error";

        }
        return "redirect:/autenticarOK";
            
            
    }
    
}
