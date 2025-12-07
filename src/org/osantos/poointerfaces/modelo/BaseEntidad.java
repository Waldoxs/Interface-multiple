package org.osantos.poointerfaces.modelo;

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
}
