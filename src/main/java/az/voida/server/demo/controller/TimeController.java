package az.voida.server.demo.controller;

import az.voida.server.demo.model.TimeModel;
import az.voida.server.demo.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    private static final Logger log = LoggerFactory.getLogger(TimeController.class);


    @GetMapping("/now")
    private TimeModel getThreadTime(@RequestParam(name = "threadId") String threadId){
        TimeModel timeModel = timeService.getTime(threadId);
        log.info(threadId + " " +timeModel);
        return timeModel;
    }
    
}
