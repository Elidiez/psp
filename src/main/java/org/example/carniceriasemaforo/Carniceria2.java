package org.example.carniceriasemaforo;
import java.util.concurrent.Semaphore;

public class Carniceria2 {
    private Semaphore semaphore;
    private int contadorLlegada;

    public Carniceria2() {
        semaphore = new Semaphore(1); // Máximo 1 clientes atendidos en la carnicería
        contadorLlegada = 1;
    }

    public void atenderCliente(String cliente) {
        try {
            semaphore.acquire(); // El cliente adquiere el semáforo y ocupa un lugar en la carnicería

            System.out.println("Cliente " + cliente + " está siendo atendido");
            Thread.sleep(2000); // Simulación de tiempo de atención
            System.out.println("Cliente " + cliente + " ha sido atendido");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // El cliente libera el semáforo y deja un lugar disponible en la carnicería
            System.out.println("Cliente " + cliente + " abandona la tienda");
        }
    }


}
