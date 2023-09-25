package com.juanma.proyecto;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.juanma.proyecto.controladores.CocheControlador;
import com.juanma.proyecto.entidades.Coche;
import com.juanma.proyecto.servicios.CocheServicio;

@SpringBootTest
class ProyectoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private CocheServicio cocheServicio;
	
	@InjectMocks
	private CocheControlador cocheControlador;

	@Test
	public void testActualizarCoche() {
		// Set up test data
		Long id = 1L;
		Coche coche = new Coche();
		coche.setMarca("Honda");
		coche.setModelo("Civic");
		coche.setMatricula("1234ABC");
	
		Coche cocheAntiguo = new Coche();
		cocheAntiguo.setId(id);
	
		when(cocheServicio.obtenerCochePorID(id)).thenReturn(cocheAntiguo);
	
		String result = cocheControlador.actualizarCoche(id, coche, mock(Model.class));
	
		assertEquals("redirect:/coches", result);
	}
}
