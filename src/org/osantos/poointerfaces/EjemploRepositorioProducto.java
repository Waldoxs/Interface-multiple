package org.osantos.poointerfaces;

import org.osantos.poointerfaces.modelo.Cliente;
import org.osantos.poointerfaces.modelo.Producto;
import org.osantos.poointerfaces.repositorio.Direccion;
import org.osantos.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.osantos.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.osantos.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.osantos.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 500.1));
            repo.crear(new Producto("Silla", 399.99));
            repo.crear(new Producto("Lampara", 890.0));
            repo.crear(new Producto("Libreta", 32.0));

            List<Producto> productos = repo.listar();
            for (Producto product : productos) {
                System.out.println(product);
            }
            System.out.println("======= Paginable =======");
            List<Producto> paginable = repo.listar(0, 4);
            for (Producto pag : paginable) {
                System.out.println(pag);
            }

            System.out.println("======= Ordenable =======");
            List<Producto> productoOrdenASC = repo.listar("descripcion", Direccion.DESC);
            for (Producto ordenAsc : productoOrdenASC) {
                System.out.println(ordenAsc);
            }

            System.out.println("======= Editar =======");
            Producto productoActulizar = new Producto("lampara", 299.99);
            productoActulizar.setId(3);
            repo.editar(productoActulizar);
            Producto bea = repo.porId(3);
            System.out.println(bea);


            System.out.println("======= Eliminar =======");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);


            System.out.println("======= Total  de registros =======");
            System.out.println(repo.total());

        } catch (
                LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }

    }
}
