package com.juanma.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juanma.proyecto.entidades.Coche;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {
    //La clase CocheRepositorio debe implementar la interfaz JpaRepository que nos permitirá usar una serie de métodos
    //propios de dicha interfaz para la persistencia de datos
}