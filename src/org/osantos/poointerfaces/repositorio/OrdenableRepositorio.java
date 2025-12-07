package org.osantos.poointerfaces.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {

    //Metodo para ordenar
    List<T> listar(String campo, Direccion dir);



}
