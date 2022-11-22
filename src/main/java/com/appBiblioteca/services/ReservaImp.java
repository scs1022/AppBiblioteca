/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appBiblioteca.services;

import com.appBiblioteca.entity.Articulo;
import com.appBiblioteca.entity.Reserva;
import com.appBiblioteca.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author santi
 */
@Service
@Log4j2
public class ReservaImp implements IReserva{

    
    @Autowired
    private ReservaRepository reservaRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void crearReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

//    @Override
//    public Optional<Reserva> buscarPorIdArticulo(String id_user) {
//           return reservaRepository.findBy("id_usuario", id_user);
//    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return reservaRepository.findAll();
    }
    
    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.findById(id);
    }
    
    @Override
    public void guardarReserva(Reserva rese) {
        reservaRepository.save(rese);
    }
    
    @Override
    public void eliminarReserva(Reserva rese) {
        reservaRepository.delete(rese);
    }


}