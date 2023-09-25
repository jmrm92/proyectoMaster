package com.juanma.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.juanma.proyecto.entidades.Coche;
import com.juanma.proyecto.servicios.CocheServicio;

@Controller
public class CocheControlador {

    @Autowired
    private CocheServicio cocheServicio;

    /**
     * Recupera una lista de coches y los agrega al modelo para representar la vista "coches".
     *
     * @param  modelo  el objeto de modelo al que se agregan la lista de coches
     * @return         el nombre de la vista a representar ("coches")
     */
    @GetMapping({ "/coches", "/" })
    public String listaCoches (Model modelo) {
        modelo.addAttribute("coche", cocheServicio.listarCoches());
        return "coches";
    }

     /**
     * Recupera la página de registro de un nuevo coche.
     *
     * @param  modelo   el objeto de modelo para la vista
     * @return          el nombre de la plantilla de vista para crear un nuevo coche
     */
    @GetMapping("/coches/nuevo")
	public String registroNuevoCoche(Model modelo) {
		Coche coche = new Coche();
		modelo.addAttribute("coche", coche);
		return "crear_coche";
	}

    /**
     * Crea un nuevo coche guardando el objeto coche proporcionado.
     *
     * @param  coche  el objeto coche que se va a crear
     * @return        una cadena de texto que representa la URL de redirección
     */
    @PostMapping("/coches")
    public String crearCoche(@ModelAttribute("coche") Coche coche) {
        cocheServicio.guardarCoche(coche);
        return "redirect:/coches";
    }

    /**
     * Recupera un coche específico para editar.
     *
     * @param  id     el ID del coche a editar
     * @param  modelo el objeto de modelo para la vista
     * @return        el nombre de la vista para editar un coche
     */
    @GetMapping("/coches/editar/{id}")
	public String edicionCoche(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("coche", cocheServicio.obtenerCochePorID(id));
		return "editar_coche";
	}

    /**
     * Actualiza un coche en la base de datos.
     *
     * @param  id      el ID del coche a actualizar
     * @param  coche   el objeto de coche actualizado
     * @param  modelo  el objeto de modelo a utilizar para renderizar la vista
     * @return         una cadena que representa la URL de redirección
     */
    @PostMapping("/coches/{id}")
    public String actualizarCoche(@PathVariable Long id, @ModelAttribute("coche") Coche coche,
    Model modelo) {
        Coche cocheAntiguo = cocheServicio.obtenerCochePorID(id);  
        cocheAntiguo.setMarca(coche.getMarca());
        cocheAntiguo.setModelo(coche.getModelo());
        cocheAntiguo.setMatricula(coche.getMatricula());
        cocheServicio.actualizarCoche(cocheAntiguo);
        return "redirect:/coches";
    }

    /**
    * Recupera un coche específico basado en su ID y lo elimina de la base de datos.
    *
    * @param  cocheId  el ID del coche que se va a eliminar
    * @return          una cadena que representa la URL de redirección después de eliminar el coche
    */
    @GetMapping("/coches/{id}")
    public String borrarCoche(@PathVariable(value = "id") Long cocheId) {
        cocheServicio.borrarCochePorID(cocheId);
        return "redirect:/coches";
    }
}
