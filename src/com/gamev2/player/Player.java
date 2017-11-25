package com.gamev2.player;

import org.junit.Test;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */
public class Player {
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

    public void changeStatus(PlayerStatus playerStatus){
        this.playerStatus=playerStatus;
    }

}
