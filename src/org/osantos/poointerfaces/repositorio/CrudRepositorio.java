package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.List;

//Alta y bajas de modificaciones
public interface CrudRepositorio {

    //Metodo de la interfaz
    List<Cliente> listar();

    //Para el metodo gett para obtener el id
    Cliente porId(Integer id);

    //Metodo para realizar una operación
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer id);


}
