package org.osantos.poointerfaces.repositorio;

import org.osantos.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio, PaginableRespositorio {

    //Atributo DataSource
    private List<Cliente> dataSource;

    //Para inicializar la lista
    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for (Cliente client : dataSource) {
            if (client.getId().equals(id)) {
                resultado = client;
            }
            break;
        }

        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente client = this.porId(cliente.getId());
        client.setNombre(cliente.getNombre());
        client.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente client = this.porId(id);
        this.dataSource.remove(client);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        //Se usa la expresión lambda y se asume que es de tipo Cliente
        this.dataSource.sort((a, b) -> {
                    int resultado = 0;
                    if (dir == Direccion.ASC) {
                        switch (campo) {
                            case "id" -> resultado = a.getId().compareTo(b.getId());
                            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                        }
                    } else if (dir == Direccion.DESC) {
                        switch (campo) {
                            case "id" -> resultado = b.getId().compareTo(a.getId());
                            case "nombre" -> resultado = b.getNombre().compareTo(a.getNombre());
                            case "apellido" -> resultado = b.getApellido().compareTo(a.getApellido());
                        }
                    }
                    return resultado;
                }
        );
        return this.dataSource;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return this.dataSource.subList(desde,hasta);
    }
}
