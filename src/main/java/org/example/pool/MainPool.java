package org.example.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainPool {

    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=0;i<100;i++)
        {
            executor.execute(new HiloPool(i));
        }

        executor.shutdown();
    }
}
