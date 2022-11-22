/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.controller;

import com.appBiblioteca.entity.Administrador;
import com.appBiblioteca.entity.Articulo;
import com.appBiblioteca.entity.Reserva;
import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.services.IAdministrador;
import com.appBiblioteca.services.IArticulo;
import com.appBiblioteca.services.IReserva;
import com.appBiblioteca.services.IUsuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
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
public class gestorAdminController {
     @Autowired private IAdministrador serviceAdministrador;
    
     @Autowired private IUsuario serviceUsuarior;
     
    @Autowired private IReserva serviceReserva;
    
    @Autowired
    private IArticulo serviceArticulo; 
    
    
 
    @GetMapping("/marcarRegistro/{id_arti}/{id_user}/{id_reser}")
    public String marcarRetiro(@PathVariable String id_arti, @PathVariable String id_user, @PathVariable String id_reser, Model modelo) {
        
        Date date = Date.from(Instant.now());
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaActual.plusDays(5);
        
        Reserva rese = serviceReserva.buscarPorId(Long.parseLong(id_reser)).get();
        rese.setFechaEntrega(fechaEntrega);
       
        serviceReserva.guardarReserva(rese);
        
        
        
        
        Usuario user = serviceUsuarior.buscarPorId(Long.parseLong(id_user)).get();
        
        Articulo articulo = serviceArticulo.buscarPorId(Long.parseLong(id_arti)).get();
        modelo.addAttribute("arti", articulo);
        modelo.addAttribute("usur",user);
        modelo.addAttribute("reser",rese);
        return "retiroInfo";

    }
    
    
    @GetMapping("/marcarEntrega/{id_arti}/{id_user}/{id_reser}")
    public String marcarEntrega(@PathVariable String id_arti, @PathVariable String id_user, @PathVariable String id_reser, Model modelo) {
        
        Reserva rese = serviceReserva.buscarPorId(Long.parseLong(id_reser)).get();
        serviceReserva.eliminarReserva(rese);
       
        Articulo arti =serviceArticulo.buscarPorId(Long.parseLong(id_arti)).get();
        arti.setEstado(true);
        serviceArticulo.guardarArticulo(arti);
        
        
        
        
        
        
        
        Usuario user = serviceUsuarior.buscarPorId(Long.parseLong(id_user)).get();
        
        Articulo articulo = serviceArticulo.buscarPorId(Long.parseLong(id_arti)).get();
        modelo.addAttribute("arti", articulo);
        modelo.addAttribute("usur",user);
        modelo.addAttribute("reser",rese);
        return "retiroInfo";

    }
    
    
    
}
