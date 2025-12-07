package org.osantos.genericsclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion implements Iterable {
    private List objetos;
    private int max;    //Maxímo de elementos a transportar

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void addObj(Object objeto) {
        if (this.objetos.size() <= this.max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("No hay más espacio.");
        }

    }

    @Override
    public Iterator iterator() {
        return this.objetos.iterator();
    }
}
