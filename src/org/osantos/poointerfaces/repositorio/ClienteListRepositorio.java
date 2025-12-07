package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

 public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente>  {

    @Override
    public void editar(Cliente cliente) {
        Cliente client = this.porId(cliente.getId());
        client.setNombre(cliente.getNombre());
        client.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        //Retorna una nueva lista inmutable
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        //Se usa la expresión lambda y se asume que es de tipo Cliente
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }


    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

}





