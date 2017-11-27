package com.gamev2.player;

import com.gamev2.overseas.weather.Weather;
import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */
public class Player implements Observer{
    private PlayerType playerType;
    private PlayerStatus playerStatus;

    public static void main(String[] args){
        Player a=new Player();
        a.playerType=new GameManager();
        a.playerStatus=new Rest();
        a.playerStatus.printStatus();
        a.playerType.printType();
        //change into different status
        a.changeStatus(new Ultimate());
        int exp = a.playerStatus.countEXP(20);
        System.out.println(a.playerStatus.getClass()+" exp: "+exp);
    }

    public Player() {
    }

    public Player(Weather weather) {
        weather.addObserver(this);
    }

    public void changeStatus(PlayerStatus playerStatus){
        this.playerStatus=playerStatus;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(" weather changed into "+((Weather)o).getInfo());
    }
}
