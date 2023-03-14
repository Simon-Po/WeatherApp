package weatherapp;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherApp implements Runnable{


    private ViewGenerator view;
    public WeatherApp() {
        this.view = new ViewGenerator();

    }

    @Override
    public void run() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        this.view.printOutput();

    }
}
