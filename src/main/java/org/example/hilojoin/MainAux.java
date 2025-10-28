package org.example.hilojoin;

public class MainAux {

    public static void main(String[] args) throws InterruptedException
    {
        HiloAuxiliar hilo1 = new HiloAuxiliar();

        System.out.println("Hilo con estado: " + hilo1.getState());
        hilo1.start();
        System.out.println("Hilo iniciado con estado: " + hilo1.getState());
        System.out.println("Esperando a que termine su función");

        hilo1.join();

        System.out.println("Hilo muerto con estado: " + hilo1.getState());

    }
}
