package az.voida.client.service;

import az.voida.client.model.TimeModel;

public interface TimeClient {
    TimeModel getTime(String threadId);
}
