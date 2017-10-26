package com.game.Item;

/**
 * edited by AndersonKim
 * at 2017/10/26
 */

/**
 * 功法
 * 通常可以修改玩家的基础属性
 */
public class Gest extends GestLevel{
    String name;
    String info;

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
