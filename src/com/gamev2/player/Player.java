package com.gamev2.player;

import org.junit.Test;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */
public class Player {
    private PlayerType playerType;
    private PlayerStatus playerStatus;
    @Test
    public void test(){
        playerType=new GameManager();
        playerStatus=new Rest();
        playerStatus.printStatus();
        playerType.printType();
    }

}
