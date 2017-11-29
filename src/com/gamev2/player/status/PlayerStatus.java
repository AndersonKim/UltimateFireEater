package com.gamev2.player.status;

/**
 * edited by AndersonKim
 * at 2017/11/7
 */

/**
 * 玩家状态的抽象类
 * 提供修炼，休息的缺省实现
 */
abstract public class PlayerStatus {
    public abstract void printStatus();
    public abstract int countEXP(int exp);
}
