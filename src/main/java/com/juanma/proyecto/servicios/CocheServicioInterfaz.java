package com.juanma.proyecto.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.juanma.proyecto.entidades.Coche;

@Service
public interface CocheServicioInterfaz {

    //Interfaz para establecer los métodos a implementar en la clase CocheServicio

    public Coche guardarCoche(Coche coche);

    public List<Coche> listarCoches();
	
	public Coche obtenerCochePorID(Long id);

	public void borrarCochePorID(Long id);

    public Coche actualizarCoche (Coche coche);
}
