package org.example.pistola;

public class Pistola {

    private int balas = 40;

    public Pistola() {}
    public Pistola(int balas) {
        this.balas = balas;
    }

    public int getBalas() {
        return balas;
    }

    public synchronized void disparar(int balasAdisparar) {

        for (int i = 1; i <= balasAdisparar; i++) {

            System.out.println("Bala " + i + " disparada");

            if (balas == 0) {
                System.out.println(i - 1 + " balas disparadas " + balas + " restantes");


                try {
                    wait();  //hilo quiero hasta que acaben
                    System.out.println("Continua disparando después de recargar");


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                balas--;
            }

        }System.out.println("tiroteo finalizado");
    }

    public synchronized void recargar() {
        System.out.println("Pistola recargada con otras 40 balas");

        balas = balas + 40;
       notify();

    }
}
