package org.example.camareros;

public class Cliente extends Thread {

    /*
    En el bar “Los Hilos Dorados” hay 3 camareros.
Cada uno puede atender a un cliente a la vez.
El bar tiene un aforo total de 40 personas, y todos quieren pedir una bebida.
Cuando el bar abre, los clientes llegan y son atendidos por los camareros disponibles.
Cada servicio tarda entre 1 y 4 segundos, y cuando terminan, el camarero queda libre para atender al siguiente cliente.


    */


    int n;

public Cliente(int n){
    this.n=n;
}

@Override
    public void run()
{
    System.out.println("Cliente " + n + " es atendido por el camarero: " + Thread.currentThread().getName());

    try {
        sleep(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
}
