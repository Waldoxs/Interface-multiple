package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRespositorio {
    //Sobrecarga de metodo
    List<Cliente> listar (int desde, int hasta);
}
