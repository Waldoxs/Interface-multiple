package org.osantos.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T> {
    private List<T> objetos;
    private int max;    //Maxímo de elementos a transportar

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void addObj(T objeto) {
        if (this.objetos.size() <= this.max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("No hay más espacio.");
        }

    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
