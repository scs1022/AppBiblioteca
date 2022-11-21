/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.controller;

import com.appBiblioteca.entity.Articulo;
import com.appBiblioteca.entity.Reserva;
import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.services.IArticulo;
import com.appBiblioteca.services.IReserva;
import com.appBiblioteca.services.IUsuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
public class consultarFechaRetiroContoller {
    
    
    @Autowired
    private IReserva reservaService;

    @Autowired
    private IArticulo articuloService;

    @Autowired
    private IUsuario usuarioService;
    
    @GetMapping("/consultarFechaRetiro/{id_user}")
    public String Reserva(@PathVariable String id_user, Model modelo) {
        //modelo.addAttribute("reserva", new Reserva());

//        Articulo arti = articuloService.buscarPorId(Long.parseLong(id_arti)).get();
//        arti.setEstado(false);
//        articuloService.guardarArticulo(arti);
        
        List<Reserva> reser =reservaService.listarTodasReservas();
        List<Articulo> arti = articuloService.listarTodosArticulos();
   
        
        Usuario user = usuarioService.buscarPorId(Long.parseLong(id_user)).get();
        
       // Articulo articulo = articuloService.buscarPorId(Long.parseLong(id_arti)).get();
        modelo.addAttribute("arti", arti);
        modelo.addAttribute("usur",user);
        modelo.addAttribute("reser",reser);
        return "consultarFechaRetiro";
    }
}
