package com.juanma.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juanma.proyecto.entidades.Coche;
import com.juanma.proyecto.repositorios.CocheRepositorio;

@Service
public class CocheServicio implements CocheServicioInterfaz {

	@Autowired
    private CocheRepositorio repositorio;

    /**
    * Guarda un coche en el repositorio.
     *
     * @param  coche  el coche a guardar
    * @return        el coche guardado
     */
    @Override
    public Coche guardarCoche(Coche coche) {
        repositorio.save(coche);
        return coche;
    }

    /**
    * Devuelve una lista de objetos Coche llamando al método findAll() del objeto repositorio.
    *
    * @return  una lista de objetos Coche
    */
    @Override
    public List<Coche> listarCoches(){
		return repositorio.findAll();
	}
	
    /**
    * Obtiene un objeto Coche por su ID.
    *
    * @param  id  el ID del objeto Coche   * @return     el objeto Coche con el ID especificado
    */
    @Override
	public Coche obtenerCochePorID(Long id) {
		return repositorio.findById(id).get();
	}

    /**
    * Elimina un coche del repositorio basado en su ID.
    *
    * @param  id  el ID del coche que se va a eliminar
    */
    @Override
	public void borrarCochePorID(Long id) {
		repositorio.deleteById(id);
	}

    /**
     * Actualiza un objeto Coche.
     *
     * @param  coche el objeto Coche a actualizar
     * @return       el objeto Coche actualizado
     */
    @Override
    public Coche actualizarCoche(Coche coche) {
        return repositorio.save(coche);
    }
}