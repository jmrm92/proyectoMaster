package com.juanma.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.juanma.proyecto.repositorios.CocheRepositorio;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);

		
	}

	@Autowired
	private CocheRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
	}

}
