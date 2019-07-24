package az.voida.server.demo;

import az.voida.server.demo.model.TimeModel;
import az.voida.server.demo.service.TimeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

    @Autowired
    private TimeService timeService;

    @Test
    public void contextLoads() {
        TimeModel timeModel = timeService.getTime("Thread1");
        Assert.assertEquals("24.07.2019", timeModel.getDate());
    }




}
