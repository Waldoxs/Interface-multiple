package org.osantos.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntidad {
    protected Integer id;
    private static int ultimoId;

    public BaseEntidad() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //Es el metodo que usa el .remove
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntidad base = (BaseEntidad) o;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
