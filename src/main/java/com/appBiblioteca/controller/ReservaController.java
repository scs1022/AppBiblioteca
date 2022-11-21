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
public class ReservaController {

    @Autowired
    private IReserva reservaService;

    @Autowired
    private IArticulo articuloService;

    @Autowired
    private IUsuario usuarioService;

//    @GetMapping("/reserva")
//    public String getRegistro(/*@PathVariable("id") String id*/Model modelo,@ModelAttribute("articulo") Usuario articuloDTO) {
//            //modelo.addAttribute(nombre, articuloDTO);
////        IReserva.setNombre(nombre);
////        reservaService.crearReserva(reserva);
//        //modelo.addAttribute("reserva", new Reserva());
//        
//        return "reserva";
//    }
//    @PostMapping("/reservar")
//    public String registrarUsuario(@ModelAttribute("reserva") Reserva estudianteDTO) {
//
//        if (reservaService.crearReserva(estudianteDTO)) {
//            System.out.println(estudianteDTO);
//            return "redirect:/reserva?exito";
//        }
//        return "redirect:/reserva?error";
//
//    }
    @GetMapping("/reserva")
    public String getRegistro(Model modelo) {
        modelo.addAttribute("reserva", new Reserva());
        return "reserva";
    }

    @GetMapping("/reserva/{id_arti}/{id_user}")
    public String Reserva(@PathVariable String id_arti, @PathVariable String id_user, Model modelo) {
        modelo.addAttribute("reserva", new Reserva());
        System.out.println("id_art = " + id_arti);
        System.out.println("id_user = " + id_user);

        Articulo arti = articuloService.buscarPorId(Long.parseLong(id_arti)).get();
        arti.setEstado(false);
        articuloService.guardarArticulo(arti);

        Date date = Date.from(Instant.now());
        LocalDateTime fechaActual = LocalDateTime.now();

        Reserva rese = new Reserva();

        LocalDateTime fechaRetiro = fechaActual.plusDays(5);

        rese.setFechaRetiro(fechaRetiro);
        rese.setArticulo_id(arti);
        //rese.setId(Long.valueOf(id_arti));
        rese.setUsuario_id(usuarioService.buscarPorId(Long.valueOf(id_user)).get());
        reservaService.crearReserva(rese);

        modelo.addAttribute("date", date);
        modelo.addAttribute("date", date);

        
        
        Usuario user = usuarioService.buscarPorId(Long.parseLong(id_user)).get();
        
        Articulo articulo = articuloService.buscarPorId(Long.parseLong(id_arti)).get();
        modelo.addAttribute("arti", articulo);
        modelo.addAttribute("usur",user);
        modelo.addAttribute("reser",rese);
        return "reservaInfo";
    }
}
