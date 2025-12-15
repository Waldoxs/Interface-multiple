package org.osantos.poointerfaces;

import org.osantos.poointerfaces.modelo.Cliente;
import org.osantos.poointerfaces.repositorio.*;
import org.osantos.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.osantos.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {

            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Pérez"));
            repo.crear(new Cliente("Oswaldo", "Santos"));
            repo.crear(new Cliente("Luci", "Martínez"));
            repo.crear(new Cliente("Andrés", "Guzmán"));
            repo.crear(null);

            List<Cliente> clientes = repo.listar();
            for (Cliente client : clientes) {
                System.out.println(client);
            }
            System.out.println("======= Paginable =======");
            List<Cliente> paginable = repo.listar(0, 4);
            for (Cliente pag : paginable) {
                System.out.println(pag);
            }

            System.out.println("======= Ordenable =======");
            List<Cliente> clientesOrdenASC = repo.listar("nombre", Direccion.DESC);
            for (Cliente ordenAsc : clientesOrdenASC) {
                System.out.println(ordenAsc);
            }

            System.out.println("======= Editar =======");
            Cliente clientActulizar = new Cliente("Oswaldo", "Hernandez");
            clientActulizar.setId(2);
            repo.editar(clientActulizar);
            Cliente bea = repo.porId(20);
            System.out.println(bea);


            System.out.println("======= Eliminar =======");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);


            System.out.println("======= Total  de registros =======");
            System.out.println(repo.total());

        } catch (LecturaAccesoDatoException e) {
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace(System.out);
        }
        catch (EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace(System.out);
        }
        catch (AccesoDatoException e) {
            System.out.println("Genérica: " + e.getMessage());
            e.printStackTrace(System.out);
        }

    }
}
