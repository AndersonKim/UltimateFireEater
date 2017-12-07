package com.gamev2.player.attack;

import com.gamev2.player.Player;

/**
 * edited by AndersonKim
 * at 2017/12/5
 */
public class AttackMethod implements AbstractAttack {

    AbstractAttack abstractAttack;

    public AttackMethod() {
    }

    public AttackMethod(AbstractAttack abstractAttack) {
        this.abstractAttack = abstractAttack;
    }

    @Override
    public void attack(Player player) {
        abstractAttack.attack(player);
    }
}
