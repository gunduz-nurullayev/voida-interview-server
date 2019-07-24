package az.voida.server.demo.service;

import az.voida.server.demo.model.TimeModel;


public interface TimeService {
    TimeModel getTime(String threadId);
}
