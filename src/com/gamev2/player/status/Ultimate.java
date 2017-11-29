package com.gamev2.player.status;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */
public class Ultimate extends PlayerStatus {
    @Override
    public void printStatus() {
        System.out.println("player in ultimate mod");
    }

    @Override
    public int countEXP(int exp) {
        return exp*10;
    }
}
