/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Administrador;
import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.repository.AdministradorRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
public class AdministradorImpl implements IAdministrador{

    
    @Autowired
    private AdministradorRepository administradorRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean autenticar(Administrador administrador) {
        List<Administrador> administradores = administradorRepository.findAll();
        
        for (Administrador usuario1 : administradores) {
            
            System.out.println(usuario1.getCorreo());
            if((administrador.getCorreo().equals(usuario1.getCorreo()))&&(administrador.getClave().equals(usuario1.getClave()))){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Administrador> readAdministrador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Administrador> buscarPorId(Long id) {
        return administradorRepository.findById(id);
    }

    @Override
    public Administrador buscarPorCorreo(String correo) {
        List<Administrador> admin = administradorRepository.findAll();
         for (Administrador administrador : admin) {
            if(correo.equals(administrador.getCorreo())){
                return administrador;
            }
        }
        return null;
    }
    
}
