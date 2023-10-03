# WebAppConcesionario
Una aplicación web para gestionar el inventario de un concesionario, en la cual se pueden añadir, editar y borrar coches.

## Instalación
1. Clona el repositorio: `https://github.com/jmrm92/proyectoMaster.git`
2. Instala las dependencias requeridas: `mvn install`
3. Inicia la aplicación: `npm start`
4. Si fuera necesario, crear base de datos con la siguiente tabla y usuario:
    
    CREATE TABLE coches (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Matricula VARCHAR(50) NOT NULL UNIQUE,
    Marca VARCHAR(50) NOT NULL,
    Modelo VARCHAR(50) NOT NULL
);

    CREATE USER 'user'@'localhost' IDENTIFIED BY '1234';

## Uso
- Accede a la aplicación en un navegador web: `http://localhost:8080`
- Crea un nuevo automóvil: Envía una solicitud POST a `/coches` con los datos requeridos.
- Actualiza un automóvil: Envía una solicitud PUT a `/coches/{id}` con los datos actualizados.
- Elimina un automóvil: Envía una solicitud DELETE a `/coches/{id}` para eliminar un automóvil de la base de datos.


