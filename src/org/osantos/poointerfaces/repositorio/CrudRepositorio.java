package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

//Alta y bajas de modificaciones
public interface CrudRepositorio<T> {

    //Metodo de la interfaz
    List<T> listar();

    //Para el metodo get para obtener el id
    T porId(Integer id) throws AccesoDatoException;

    //Metodo para realizar una operación
    void crear(T obj) throws EscrituraAccesoDatoException;
    void editar(T obj) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;


}
