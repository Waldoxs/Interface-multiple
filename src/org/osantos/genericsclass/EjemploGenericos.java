package org.osantos.genericsclass;

public class EjemploGenericos {
    public static void main(String[] args) {
        Camion transporteCaballos = new Camion(5);
        transporteCaballos.addObj(new Animal("Horacio", "Caballo"));
        transporteCaballos.addObj(new Animal("Hugo", "Caballo"));
        transporteCaballos.addObj(new Animal("Gigi", "Caballo"));
        transporteCaballos.addObj(new Animal("Zeus", "Caballo"));
        transporteCaballos.addObj(new Animal("Diamante", "Caballo"));

        for (Object o : transporteCaballos) {
            Animal a = (Animal) o; //Cast de Animal a object
            System.out.println(a.getNombre() + ", tipo: " + a.getTipo());
        }
        System.out.println();

        Camion transMaquinaria = new Camion(3);
        transMaquinaria.addObj(new Maquinaria("Bulldozer"));
        transMaquinaria.addObj(new Maquinaria("Grua Horquilla"));
        transMaquinaria.addObj(new Maquinaria("Perforadora"));

        for (Object o : transMaquinaria) {
            Maquinaria m = (Maquinaria) o;
            System.out.println(m.getTipo());
        }
        System.out.println();

        Camion transAuto = new Camion(3);
        transAuto.addObj(new Maquinaria("Toyota"));
        transAuto.addObj(new Maquinaria("Mazda"));
        transAuto.addObj(new Maquinaria("Chevrolet"));

        for (Object o : transAuto) {
            Maquinaria a = (Maquinaria) o;
            System.out.println(a.getTipo());
        }

    }
}
