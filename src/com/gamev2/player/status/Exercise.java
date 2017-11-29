package com.gamev2.player.status;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */
public class Exercise extends PlayerStatus {
    @Override
    public void printStatus() {
        System.out.println("player in exercise mod");
    }

    @Override
    public int countEXP(int exp) {
        return exp*1;
    }
}
