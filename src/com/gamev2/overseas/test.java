package com.gamev2.overseas;

import com.gamev2.overseas.weather.Rain;
import com.gamev2.player.Player;

public class test {
    public static void main(String[] args){
        GameSpace gs=new GameSpace(new Rain("Rain"));
        gs.addPlayer(new Player());
    }
}
