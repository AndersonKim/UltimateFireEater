package com.game.Character;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

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
    /**
     * 全局常量
     */
    static class GlobalConstance {
        /*低等级和高等级对应的经验池的大小*/
        public static final int LOW_HIGH_DIVIDE=4;
        public static final double LOW_LEVEL_EXP_POOL=200;
        public static final double HIGH_LEVEL_EXP_POOL=20000;
        /*等级及其对应的评价*/
        public static final String[] RANK={
                "斗之气"
                ,"斗者"
                ,"斗师"
                ,"大斗师"
                ,"斗灵"
                ,"斗王"
                ,"斗皇"
                ,"斗宗"
                ,"斗尊"
                ,"斗尊巅峰"
                ,"半步斗圣"
                ,"斗圣"
                ,"斗帝"
        };
    }
}
