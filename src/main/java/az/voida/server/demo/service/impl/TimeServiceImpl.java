package az.voida.server.demo.service.impl;

import az.voida.server.demo.model.TimeModel;
import az.voida.server.demo.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeServiceImpl implements TimeService {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final Clock DEFAULT_ZONE = Clock.systemDefaultZone();

    @Override
    public TimeModel getTime(String threadId) {
        LocalDateTime localDateTime = LocalDateTime.now();

        TimeModel timeModel = new TimeModel();
        timeModel.setDate(localDateTime.format(DATE_FORMAT));
        timeModel.setTime(localDateTime.format(TIME_FORMAT));
        timeModel.setTimezone(DEFAULT_ZONE.getZone().toString());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return timeModel;
    }
}
