package az.voida.client.model;

import java.io.Serializable;

public class TimeModel implements Serializable {
    private static final long serialVersionUID = -6374424613452108296L;
    private String date;
    private String time;
    private String timezone;

    public TimeModel() {
        this.date = "";
        this.time = "";
        this.timezone = "";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "TimeModel{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
