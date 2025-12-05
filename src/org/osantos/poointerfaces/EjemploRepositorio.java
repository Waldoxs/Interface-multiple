package org.osantos.poointerfaces;

import org.osantos.poointerfaces.modelo.Cliente;
import org.osantos.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Oswaldo", "Santos"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));

        List<Cliente> clientes = repo.listar();
        for (Cliente client : clientes) {
            System.out.println(client);
        }
        System.out.println("======= Paginable =======");
        List<Cliente> paginable = ((PaginableRespositorio) repo).listar(0, 4);
        for (Cliente pag : paginable) {
            System.out.println(pag);
        }

        System.out.println("======= Ordenable =======");
        List<Cliente> clientesOrdenASC = ((OrdenableRepositorio) repo).listar("apellido", Direccion.ASC);
        for (Cliente ordenAsc : clientesOrdenASC) {
            System.out.println(ordenAsc);
        }

        System.out.println("======= Editar =======");
        Cliente clientActulizar = new Cliente("Oswaldo", "Hernandez");
        clientActulizar.setId(2);
        repo.editar(clientActulizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);


        System.out.println("======= Eliminar =======");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);




    }
}
