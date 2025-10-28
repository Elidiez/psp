package org.example.prioridades;

public class Tarea extends Thread {


    int numero;
    String nombre;
    public Tarea( String nombre) {
      super();
        this.nombre = nombre;
    }


    public void run() {
        for (int i = 0; i <5; i++) {
            System.out.println("Hilo "  + this.numero + " Iteración " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
