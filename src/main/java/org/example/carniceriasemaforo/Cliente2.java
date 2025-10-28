package org.example.carniceriasemaforo;


public class Cliente2 extends Thread {
    private Carniceria2 carniceria;
    private String nombre;
    private int prioridad;

    public Cliente2(Carniceria2 carniceria, String nombre, int prioridad) {
        this.carniceria = carniceria;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public void run() {
        Thread.currentThread().setPriority(prioridad); // Establecer la prioridad del hilo
        System.out.println("Cliente " + nombre + " ha llegado a la carnicera");
        carniceria.atenderCliente(nombre);
    }
}
