package az.voida.client;

import az.voida.client.service.TimeClient;
import az.voida.client.service.impl.TimeClientImpl;
import az.voida.client.utils.TimeClientThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        TimeClient timeClient=new TimeClientImpl();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0; i< 5; i++) {
            Thread thread = new TimeClientThread(timeClient, 5);
            executorService.submit(thread);
        }
        executorService.shutdown();
    }
}
