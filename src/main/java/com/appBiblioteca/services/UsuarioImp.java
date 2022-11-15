/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Usuario;
import com.appBiblioteca.repository.UsuarioRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
@Log4j2
public class UsuarioImp implements IUsuario{
        
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public boolean crearUsuario(Usuario usuario){
        try {
            if (!usuarioRepository.existsById(usuario.getId())){
                
                usuarioRepository.save(usuario);
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Usuario> readUsuarios(){
        return usuarioRepository.findAll();
    }


//   
//    @Override
//    public boolean autenticar(Usuario usuario){
//        Usuario usuarioN=usuarioRepository.findById(usuario.getId());
//     //Usuario usuarioN = usuarioRepository.findById(usuario.getClave());
//     if (usuario.getCorreo().equals(usuarioN.getCorreo()) &&
//         usuario.getClave().equals(usuarioN.getClave())){
//         return true; 
//     }
//     return false;
//    }

    @Override
     public boolean autenticar(Usuario usuario){
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        for (Usuario usuario1 : usuarios) {
            
            System.out.println(usuario1.getCorreo());
            //if((usuario.getCorreo().equals(usuario1.getCorreo()))&&(usuario.getClave().equals(usuario1.getClave()))){
              //  return true;
            //}
        }
  
        
//        String sql = "select  e from usuarios where e.correo = :correo and e.clave = :clave";
//        Query q = entityManager.createQuery(sql);
//        q.setParameter("correo", usuario.getCorreo());
//        q.setParameter("clave", usuario.getClave());
//        try {
//            usuario = (Usuario)q.getSingleResult();
//            if (usuario != null){
//                return true;
//            }
//        }catch (Exception e ){
//            log.error("No se encuentra el usuario", e);
//        }
                    
        return false;
    }

}
