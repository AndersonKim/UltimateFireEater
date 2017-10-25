package com.game.Player;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

import com.game.Common.GlobalConstance;

/**
 * 所有的物品以及人物公用的等级机制
 */
public class Level {
    private int levels;
    private String name;
    private double expPool;
    private double expLimit;

    public double getExpLimit() {
        return expLimit;
    }

    private void setExpLimit(double expLimit) {
        this.expLimit = expLimit;
    }

    public int getLevels() {
        return levels;
    }

    private void setLevels(int levels) {
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getExpPool() {
        return expPool;
    }

    private void setExpPool(double expPool) {
        this.expPool = expPool;
    }

    /**
     * 初始化等级
     */
    public Level(){
        suckEXP(0);
    }

    /**
     * 任何形式的吸收经验值
     * @param exp
     */
    public void suckEXP(double exp){
        //是否算是高等级玩家
        if (levels< GlobalConstance.LOW_HIGH_DIVIDE){
            expLimit=GlobalConstance.LOW_LEVEL_EXP_POOL;
        }else {
            expLimit=GlobalConstance.HIGH_LEVEL_EXP_POOL;
        }
        //是否可以升级
        if (expPool+exp>=expLimit){
            levels++;
            expPool=0;
        }else {
            expPool+=exp;
        }
        //自动化产生对应评价
        name=GlobalConstance.RANK[levels];
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
