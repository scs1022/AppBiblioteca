/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
public interface IUsuario {
    public boolean crearUsuario(Usuario usuario);
    public boolean autenticar(Usuario usuario);
    public List<Usuario> readUsuarios();
    public Usuario buscarPorCorreo(String correo);
    public Optional<Usuario> buscarPorId(Long id);
}