package org.example.prioridades;

public class MainPriority {

public static void main(String[] args) {

    Thread hilo1 = new Thread(new Tarea("Hilo1"),"Hilo1");
    Thread hilo2 = new Thread(new Tarea("Hilo2"),"Hilo2");
    Thread hilo3 = new Thread(new Tarea("Hilo3"),"Hilo3");

    hilo2.setPriority(Thread.MAX_PRIORITY);
    hilo1.setPriority(Thread.MIN_PRIORITY);
    hilo3.setPriority(Thread.NORM_PRIORITY);


    hilo1.start();
    hilo2.start();
    hilo3.start();
}
}
