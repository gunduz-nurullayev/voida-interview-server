package az.voida.client.service.impl;


import az.voida.client.model.TimeModel;
import az.voida.client.service.TimeClient;
import az.voida.client.utils.CustomHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class TimeClientImpl implements TimeClient {

    @Override
    public TimeModel getTime(String threadId) {
        try {
            TimeModel timeModel = new TimeModel();
            HttpGet getRequest = new HttpGet("http://localhost:8080/time/now?threadId=" + threadId);
            HttpResponse response = CustomHttpClient.getHttpClient().execute(getRequest);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String json = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = new JSONObject(json);
                timeModel.setDate(jsonObject.getString("date"));
                timeModel.setTime(jsonObject.getString("time"));
                timeModel.setTimezone(jsonObject.getString("timezone"));
            }
            return timeModel;
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong when sending sms. Details: " + e.getMessage());
        }
    }
}
