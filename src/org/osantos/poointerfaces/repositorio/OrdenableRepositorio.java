package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    //Metodo para ordenar
    List<Cliente> listar(String campo, Direccion dir);



}
