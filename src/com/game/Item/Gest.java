package com.game.Item;

/**
 * edited by AndersonKim
 * at 2017/10/26
 */

/**
 * 功法
 * 通常可以修改玩家的基础属性以及吸收灵气的速度
 */
public class Gest extends GestLevel{
    String name;
    String info;
    double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
