package org.osantos.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T elemento : camion) {
            if (elemento instanceof Animal) {
                System.out.println(((Animal) elemento).getTipo()
                        + ": " + ((Animal) elemento).getNombre());
            }

            if (elemento instanceof Maquinaria) {
                System.out.println(((Maquinaria) elemento).getTipo());
            }

            if (elemento instanceof Automovil) {
                System.out.println(((Automovil) elemento).getMarca());
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.addObj(new Animal("Horacio", "Caballo"));
        transporteCaballos.addObj(new Animal("Hugo", "Caballo"));
        transporteCaballos.addObj(new Animal("Gigi", "Caballo"));
        transporteCaballos.addObj(new Animal("Zeus", "Caballo"));
        transporteCaballos.addObj(new Animal("Diamante", "Caballo"));

        Camion<Maquinaria> transMaquinaria = new Camion<>(3);
        transMaquinaria.addObj(new Maquinaria("Bulldozer"));
        transMaquinaria.addObj(new Maquinaria("Grua Horquilla"));
        transMaquinaria.addObj(new Maquinaria("Perforadora"));

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.addObj(new Automovil("Toyota"));
        transAuto.addObj(new Automovil("Mazda"));
        transAuto.addObj(new Automovil("Chevrolet"));

        imprimirCamion(transporteCaballos);
        imprimirCamion(transMaquinaria);
        imprimirCamion(transAuto);

    }
}
