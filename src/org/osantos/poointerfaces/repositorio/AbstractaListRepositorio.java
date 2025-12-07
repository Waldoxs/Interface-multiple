package org.osantos.poointerfaces.repositorio;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractaListRepositorio<T>
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

//    @Override
//    public T porId(Integer id) {
//        T resultado = null;
//        for(T cli: dataSource){
//            if(cli.getId() != null && cli.getId().equals(id)){
//                resultado = cli;
//                break;
//            }
//        }
//        return resultado;
//    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
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





