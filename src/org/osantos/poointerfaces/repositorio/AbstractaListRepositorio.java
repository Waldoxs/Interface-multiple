package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.BaseEntidad;
import org.osantos.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractaListRepositorio<T extends BaseEntidad>
        implements OrdenablePaginableCrudRepositorio<T> {

    //Atributo DataSource
    protected List<T> dataSource;

    //Para inicializar la lista
    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("id invalido debe ser mayor a cero");
        }


        T resultado = null;
        for (T client : dataSource) {
            if (client.getId() != null && client.getId().equals(id)) {
                resultado = client;
                break;
            }
        }

        if(resultado == null){
            throw new LecturaAccesoDatoException("No existe el registro con id: " + id);
        }


        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null");
        }
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return this.dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}





