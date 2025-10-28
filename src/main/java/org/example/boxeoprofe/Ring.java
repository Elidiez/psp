package org.example.boxeoprofe;

public class Ring {


    private boolean peleaActiva = false;
    private boolean peleaTerminada = false;
    private Arbitro arbitro;
    private Boxeador b1, b2;

    public synchronized void setBoxeadores(Boxeador b1, Boxeador b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public synchronized void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public synchronized void esperarComienzo() {
        while (!peleaActiva) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void comenzarPelea() {
        peleaActiva = true;
        System.out.println("\n🥊 ¡La pelea comienza!\n");
        notifyAll(); // despierta a los boxeadores
    }

    public synchronized void golpear(Boxeador atacante) {
        if (!peleaTerminada) {
            Boxeador defensor = (atacante == b1) ? b2 : b1;
            int golpe = (int) (Math.random() * 10) + 1;
            defensor.recibirGolpe(golpe, atacante.getNombre());
        }
    }

    public synchronized void terminarPelea(Boxeador ganador) {
        if (!peleaTerminada) {
            peleaTerminada = true;
            peleaActiva = false;
            System.out.println("\n🏁 ¡Fin del combate! 🏁");
            System.out.println("💪 El ganador es: " + ganador.getNombre());
            notifyAll(); // despierta al árbitro
        }
    }

    public synchronized void esperarFinal() {
        while (!peleaTerminada) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean peleaActiva() {
        return peleaActiva;
    }

    public boolean peleaTerminada() {
        return peleaTerminada;
    }
}


