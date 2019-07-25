package az.voida.client.utils;

import az.voida.client.model.TimeModel;
import az.voida.client.service.TimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class TimeClientThread extends Thread {
    private static final Logger log = LoggerFactory.getLogger(TimeClientThread.class);

    private TimeClient timeClient;
    private int requestCount;

    public TimeClientThread(TimeClient timeClient, int requestCount) {
        this.timeClient = timeClient;
        this.requestCount = requestCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < requestCount; i++) {
            TimeModel time = timeClient.getTime(Thread.currentThread().getName());
            LocalDateTime localDateTime = LocalDateTime.now();
            log.info(getName() + " " + time + " " + localDateTime);
        }
    }
}
