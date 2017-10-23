package com.game.Common;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

/**
 * 所有的物品以及人物公用的等级机制
 */
public class Level {
    int levels;
    String name;
    double expPool;

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExpPool() {
        return expPool;
    }

    public void setExpPool(double expPool) {
        this.expPool = expPool;
    }

    public Level(){
        levels=0;
        name="啥都不懂";
        expPool=0.0;
    }

    /**
     * 根据当前的经验值来产生对应的等级以及名称
     */
    public void genLev(){
        if(expPool<10){
            levels=1;
            name="练气";
        }else if(expPool>=10){
            levels=2;
            name="斗者";
        }
    }

    @Override
    public String toString() {
        return "Level{" +
                "levels=" + levels +
                ", name='" + name + '\'' +
                ", expPool=" + expPool +
                '}';
    }
}
