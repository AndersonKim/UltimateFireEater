package com.gamev2.player.attack;

import com.gamev2.player.Player;

/**
 * edited by AndersonKim
 * at 2017/12/5
 */
public class Attack implements AbstractAttack {
    @Override
    public void attack(Player player) {
        System.out.println("attacking "+player);
    }
}
