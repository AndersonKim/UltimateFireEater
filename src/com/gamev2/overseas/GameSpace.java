package com.gamev2.overseas;

import com.gamev2.overseas.weather.Weather;
import com.gamev2.player.Player;

import java.util.ArrayList;

/**
 * main player activity space
 * contain weather and players
 * when weather changed players behavior will different
 */
//todo make player can aware of weather's change
public class GameSpace {
    Weather weather;
    ArrayList<Player> players=new ArrayList<Player>();

    public GameSpace(Weather weather) {
        this.weather = weather;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
}
