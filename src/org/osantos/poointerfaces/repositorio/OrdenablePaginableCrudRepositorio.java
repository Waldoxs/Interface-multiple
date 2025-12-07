package org.osantos.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenableRepositorio<T>, PaginableRespositorio<T>, CrudRepositorio<T>, ContableRepositorio {

}
