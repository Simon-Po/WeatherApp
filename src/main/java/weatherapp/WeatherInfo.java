package weatherapp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WeatherInfo {


    private JSONObject jsonWeatherData;
    private HashMap<String,String[]> weatherHash;

    public WeatherInfo() {

        try {
            GetRequest b = new GetRequest("https://api.open-meteo.com/v1/forecast?latitude=47.63&longitude=7.90&hourly=temperature_2m,weathercode&timezone=Europe%2FBerlin");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(b.getContentasString());
            this.jsonWeatherData = (JSONObject) obj;
            this.weatherHash = createWeatherHash();
        }catch (
                IOException e) {
            e.printStackTrace();
            //TODO: Handle expception
        } catch (ParseException e) {
            e.printStackTrace();
            //TODO: Handle expception
        }



    }


    public String getCurrentTemperature() {
        // 2023-03-06T01:00
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:");
        Date date = new Date();
        String dateStr = formatter.format(date) + "00";

        return this.weatherHash.get(dateStr)[0];
    }

    public int getWeatherCode() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:");
        Date date = new Date();
        String dateStr = formatter.format(date) + "00";

        return Integer.parseInt(this.weatherHash.get(dateStr)[1]);
    }

    private HashMap<String,String[]> createWeatherHash() {
        JSONObject js = (JSONObject) this.jsonWeatherData.get("hourly");
        HashMap<String,String[]> map = new HashMap<>();

        String temps = js.get("temperature_2m").toString();
        temps =  temps.replace("[","");
        temps =  temps.replace("]","");
        String[] tempArr = temps.split(",");

        String times = js.get("time").toString();
        temps =  times.replace("[","");
        temps =  times.replace("]","");
        String[] timesArr = temps.split(",");

        String weatherCode = js.get("weathercode").toString();
        weatherCode =  weatherCode.replace("[","");
        weatherCode =  weatherCode.replace("]","");
        String[] weatherCodeArr = weatherCode.split(",");



        for (int i = 0; i < tempArr.length; i++) {
            String tmp = timesArr[i].replace("\"","");
            map.put(tmp.replace("T"," "),new String[] {tempArr[i], weatherCodeArr[i]});

        }

        return map;

    }



}
