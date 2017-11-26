package com.game.Character;

import java.util.ArrayList;

/**
 * Created by Joseph.Huang on 2017/11/26.
 * 角色等级系统
 */
public class CharacterLevel {
    public static final String TAG = "CharacterLevel";

    private static final int MAX_LEVEL=500;

    private int level = 0;//角色等级

    private long expPool = 0;//目前为止角色获取的所有经验
    private long potencyPool = 0;//目前为止角色获得的所有潜能点，用于心法升级
    private int attributePool=0;//目前为止角色获得的所有属性点

    private int currentExp =0;//当前等级下获得的经验

    private Character.LevelListener mCharacterLevelListener;
    public CharacterLevel(Character.LevelListener characterLevelListener){
        mCharacterLevelListener=characterLevelListener;
    }

    public int getLevel(){
        return level;
    }

    /**
     * 获得经验
     * @param exp 获得的经验值
     * @return exp<=0 : false
     */
    public boolean addExp(int exp){
        System.out.println("获得经验值："+exp);
        if(exp<=0) return false;
        synchronized (this){
            addExpLocked(exp);
            expPool += exp;
        }
        return true;
    }
    private void addExpLocked(int exp){
        if(level<MAX_LEVEL) {
            currentExp += exp;
            if (currentExp > getExpNeededWhenNextLevelUp(level)) {
                levelUpLocked();
            }
        }
    }

    //升级了！！！
    private void levelUpLocked() {
        System.out.println("升级了：Level "+level+"=>"+(level+1));

        //当前经验池更新
        currentExp -= getExpNeededWhenNextLevelUp(level);

        potencyPool+=potancyWhenLevelUp;
        attributePool+=attributeWhenLevelUp;

        //等级提升
        ++level;
        notifyAllListenerWhenLevelUp();
        waitForAllNotified();
        //判断是否连续升级
        addExpLocked(0);
    }
    private void waitForAllNotified(){
        try{
            //休眠0.01s，等待通知执行，必需
            //否则会导致属性点延迟加点，这一块应该是加锁问题，待优化（其实现在还可以）
            Thread.sleep(10);
        }catch (Exception e){}
    }
    /**
     * 通知关联模块等级提升了
     */
    private void notifyAllListenerWhenLevelUp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                mCharacterLevelListener.levelUp();
            }
        }).start();
    }
    public long getExpPool() {
        return expPool;
    }

    public long getPotencyPool() {
        return potencyPool;
    }

    public int getAttributePool() {
        return attributePool;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public static int getAttributeWhenLevelUp() {
        return attributeWhenLevelUp;
    }

    public static int getPotancyWhenLevelUp() {
        return potancyWhenLevelUp;
    }

    //每次升级的固定奖励点
    private static final int attributeWhenLevelUp = 10;//每次升级角色可获得的属性点，基本属性加点
    private static final int potancyWhenLevelUp = 1000;//每次升级角色可获得的潜能点

    /**
     * 获取角色下次升级所需的经验
     * @param level 角色当前等级,至少大于1
     * @return 经验点
     */
    public static int getExpNeededWhenNextLevelUp(int level) {
        if(level<0) return -1;
        //升级所需经验： (等级)^3+60
        return (int)(Math.pow(level , 3) + 60);
    }
}
