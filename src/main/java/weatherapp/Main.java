package weatherapp;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    // TODO: Zeit wird nicht geupdated
    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(app, 0, 10, TimeUnit.SECONDS);
    }

}
