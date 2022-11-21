/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.repository;

import com.appBiblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author santi
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {
    //public boolean existsById(Long id);
   //public Usuario findByEmail(String email);
}