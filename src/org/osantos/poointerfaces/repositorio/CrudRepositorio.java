package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.List;

//Alta y bajas de modificaciones
public interface CrudRepositorio<T> {

    //Metodo de la interfaz
    List<T> listar();

    //Para el metodo gett para obtener el id
    T porId(Integer id);

    //Metodo para realizar una operación
    void crear(T obj);
    void editar(T obj);
    void eliminar(Integer id);


}
