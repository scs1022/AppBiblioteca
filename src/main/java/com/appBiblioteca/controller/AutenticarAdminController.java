/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.controller;

import com.appBiblioteca.entity.Administrador;
import com.appBiblioteca.entity.Articulo;
import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.services.IAdministrador;
import com.appBiblioteca.services.IArticulo;
import com.appBiblioteca.services.IReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author santi
 */
@Controller
public class AutenticarAdminController {
    
    @Autowired private IAdministrador serviceAdministrador;
    
    @Autowired private IReserva serviceReserva;
    
    @Autowired
    private IArticulo serviceArticulo; 
    
    @GetMapping("/marcarRetiro/{id}")
    public String verPaginaDeInicio(@PathVariable String id , Model modelo) {
        System.out.println("id = " + id);
//        System.out.println("Modelo ");  
//        System.out.println(modelo.getAttribute("username"));
        
        Administrador admin = serviceAdministrador.buscarPorId(Long.parseLong(id)).get();
        System.out.println("admib = " + admin.getCorreo());
        modelo.addAttribute("admin",admin);
        modelo.addAttribute("reservas",serviceReserva.listarTodasReservas());
        return "gestorAdmin";
    }
    
    
    
     @GetMapping("/marcarEntrega/{id}")
    public String verPaginaMarcarEntregas(@PathVariable String id , Model modelo) {
        System.out.println("id = " + id);
//        System.out.println("Modelo ");  
//        System.out.println(modelo.getAttribute("username"));
        
        Administrador admin = serviceAdministrador.buscarPorId(Long.parseLong(id)).get();
        System.out.println("admib = " + admin.getCorreo());
        modelo.addAttribute("admin",admin);
        modelo.addAttribute("reservas",serviceReserva.listarTodasReservas());
        return "gestorAdmin2";
    }
    
    
    @PostMapping("/autenticarAdmin")
    public String autenticar(@ModelAttribute("admin") Administrador  administradorDTO) {
        
        System.out.println(administradorDTO.getCorreo());
        if (!serviceAdministrador.autenticar(administradorDTO)) {
            System.out.println(administradorDTO);
            return "redirect:/autenticaAdmin?error";   

        }
        Administrador admin= serviceAdministrador.buscarPorCorreo(administradorDTO.getCorreo());
        if(admin!=null){
            return "redirect:/marcarRetiro/"+admin.getId();
        }
        return "redirect:/autenticarAdminOK";
            
    }
    
     @GetMapping("/autenticaAdmin")
    public String getAutenticar(Model modelo) {
        Administrador admi =new Administrador();
//        usua.setCorreo("ola@22");
        modelo.addAttribute("admin", admi);
        return "autenticarAdmin";
    }
}
