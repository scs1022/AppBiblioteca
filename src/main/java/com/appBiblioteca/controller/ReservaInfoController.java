/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.controller;

import com.appBiblioteca.entity.Reserva;
import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.services.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author santi
 */
@Controller
public class ReservaInfoController {
    
    
    @Autowired IUsuario usuario;
    
    @GetMapping("/reservaInfo/{id_arti}/{id_user}")
    public String getReservaInfo(@PathVariable String id_arti,@PathVariable String id_user,Model modelo) {
        System.out.println("mira esto sare que si ");
        System.out.println("id_arti = " + id_arti);
        System.out.println("id_user = " + id_user);
        Usuario user = usuario.buscarPorId(Long.parseLong(id_user)).get();
        modelo.addAttribute("userR", user);
        return "reservaInfo";
    }
    
    @GetMapping("/reservaInfo")
    public String getReserva(Model modelo){
        
        return "reservaInfo";
    }
    
}
