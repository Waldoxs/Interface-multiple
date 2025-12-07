package org.osantos.poointerfaces.repositorio;

import java.util.List;

public interface PaginableRespositorio<T> {
    //Sobrecarga de metodo
    List<T> listar (int desde, int hasta);
}
