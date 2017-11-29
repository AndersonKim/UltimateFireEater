package com.gamev2.overseas.weather;

import java.util.Observable;

public class Weather extends Observable {
    String weather="";

    public Weather(String weather) {
        this.weather = weather;
    }

    public String getInfo(){
        return weather;
    }

    /**
     * change weather
     * @param weather
     */
    public void changeWeather(Weather weather){
        if(!this.weather.equals(weather.weather)){
            this.weather=weather.weather;
            setChanged();
        }
        notifyObservers();
    }
}
