package com.juanma.proyecto.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity //Indicamos que la clase coche es una entidad, para que la base de datos lo reconozca
@Table(name = "coches")
public class Coche {

     @Id //Indicamos que la columna id es la clave primaria
     @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos que la columna id es autoincrementable
     private Long id;

     @Column(name = "Matricula",nullable = false,length = 50,unique = true) //Indicamos que la columna matricula es única
	private String matricula;
     @Column(name = "Marca",nullable = false,length = 50) //Indicamos que la columna marca no puede ser nula
	private String marca;
     @Column(name = "Modelo",nullable = false,length = 50) //Indicamos que la columna modelo no puede ser nula
	private String modelo;
	
	
	public Coche(Long id, String marca, String modelo, String matricula) {
          this.id = id;
          this.marca = marca;
          this.modelo = modelo;
          this.matricula = matricula;
     }
     

     public Coche() {
     }

     public String getMarca() {
          return marca;
     }

     public Long getId() {
          return id;
     }


     public void setId(Long id) {
          this.id = id;
     }

     public void setMarca(String marca) {
          this.marca = marca;
     }

     public String getModelo() {
          return modelo;
     }

     public void setModelo(String modelo) {
          this.modelo = modelo;
     }

     public String getMatricula() {
          return matricula;
     }

     public void setMatricula(String matricula) {
          this.matricula = matricula;
     }   
}
