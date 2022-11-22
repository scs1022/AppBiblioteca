/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Administrador;
import com.appBiblioteca.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */

@Service
public interface IAdministrador {
    //public boolean crearAdministrador(Usuario usuario);
    public boolean autenticar(Administrador administrador);
    public List<Administrador> readAdministrador();
    public Administrador buscarPorCorreo(String correo);
    public Optional<Administrador> buscarPorId(Long id);
}