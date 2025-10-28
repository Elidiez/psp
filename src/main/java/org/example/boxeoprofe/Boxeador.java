package org.example.boxeoprofe;


public class Boxeador extends Thread {
    private String nombre;
    private int salud = 100;
    private Ring ring;

    public Boxeador(String nombre, Ring ring) {
        this.nombre = nombre;
        this.ring = ring;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void recibirGolpe(int daño, String atacante) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println("💥 " + atacante + " golpea a " + nombre + " (-" + daño + "). Salud de " + nombre + ": " + salud);
        if (salud == 0) {
            ring.terminarPelea(new Boxeador(atacante, ring));
        }
    }

    @Override
    public void run() {
        ring.esperarComienzo(); // espera que el árbitro empiece

        while (!ring.peleaTerminada() && salud > 0) {
            ring.golpear(this);
            try {
                Thread.sleep((int) (Math.random() * 700) + 300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}