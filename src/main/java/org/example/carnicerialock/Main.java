package org.example;

import org.example.carnicerialock.Carniceria;
import org.example.carnicerialock.Cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
•	Varios clientes entran en una carnicería a comprar carne. Sólo hay un carnicero que atiende a los clientes.
•	Se generan 8 clientes de los cuales sólo 4 pueden estar en ejecución.

•	Un cliente entra en la carnicería, pide carne, paga y se va.
•	El método pedirCarne  Muestra un mensaje indicando “El cliente X ha pedido 2kg de chuletas de cordero”
•	El método pagar  Muestra un mensaje indicando “El cliente X ha pagado su pedido”
•	El método despedirse  Muestra un mensaje indicando “ Hasta luego”.
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
 */
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {




    public static void main(String[] args) {

/*executorservice --> solo uno atiende
        pide carne --> bloqueo lock al final de pedir desbloqueo
        paga --> bloqueo lock al final desboqueo
        despedirse --> bloqueo lock al final desboqueo

        debe haber 3 clases --> la que es hilo CLIENTE , no puede tener un metodo con try o lock, como con el synchronized
        debe ser CARNICERIA la de los metodos */

    Carniceria c1 = new Carniceria(1);

    Cliente cl1 = new Cliente("Juan", c1);
    Cliente cl2 = new Cliente("Maria", c1);
    Cliente cl3 = new Cliente("Pedro", c1);
    Cliente cl4 = new Cliente("Ana", c1);
    Cliente cl5 = new Cliente("Jose", c1);
    Cliente cl6 = new Cliente("Luis", c1);
    Cliente cl7 = new Cliente("Juanito", c1);
    Cliente cl8 = new Cliente("Joseito", c1);

        ExecutorService es = Executors.newFixedThreadPool(4);

 es.execute(cl1);
 es.execute(cl2);
 es.execute(cl3);
 es.execute(cl4);
 es.execute(cl5);
 es.execute(cl6);
 es.execute(cl7);
 es.execute(cl8);

 es.shutdown();




    }
}