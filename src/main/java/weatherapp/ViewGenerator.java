package weatherapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ViewGenerator {

    private String temperature;
    private int weathercode;
    private String output;
    private String date;

    WeatherInfo info;
    ViewGenerator() {

        info = new WeatherInfo();
        this.temperature = info.getCurrentTemperature();
        this.weathercode = info.getWeatherCode();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        java.util.Date date = new Date();
        this.date = formatter.format(date) ;

    }


    public void printOutput(){
        String out = """
                %s              %s°C %s
                %s              
                """.formatted(getAsciiForWeathercode()[0],this.temperature,this.date,getAsciiForWeathercode()[1]);

        System.out.println(out);
    }



    private String[] getAsciiForWeathercode() {
        String  code;
        //0	Clear sky
        //1, 2, 3	Mainly clear, partly cloudy, and overcast
        //45, 48	Fog and depositing rime fog
        //51, 53, 55	Drizzle: Light, moderate, and dense intensity
        //56, 57	Freezing Drizzle: Light and dense intensity
        //61, 63, 65	Rain: Slight, moderate and heavy intensity
        //66, 67	Freezing Rain: Light and heavy intensity
        //71, 73, 75	Snow fall: Slight, moderate, and heavy intensity
        //77	Snow grains
        //80, 81, 82	Rain showers: Slight, moderate, and violent
        //85, 86	Snow showers slight and heavy
        //95 *	Thunderstorm: Slight or moderate
        //96, 99 *	Thunderstorm with slight and heavy hail


        if(this.weathercode == 0) {
            code =  WeatherASCII.SUN.ASCII;
        } else if (this.weathercode > 0 && this.weathercode < 4) {
            code =  WeatherASCII.CLOUDY.ASCII;
        } else {
            code = WeatherASCII.RAIN.ASCII;
        }

        ArrayList<String> aList = new ArrayList<String>(List.of(code.split("\n")));
        String firstLine = aList.get(0);
        aList.remove(0);

        String rest = String.join("\n",aList);
        return new String[] {firstLine,rest};
    }

}
