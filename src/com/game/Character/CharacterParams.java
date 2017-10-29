package com.game.Character;

public class CharacterParams {

    public static final int ADD_ONETIME=1*1000;// 1s

    private static final int DEFAULT_MAXHP=100;
    private static final int DEFAULT_MAXMP=30;
    private static final int DEFAULT_MAXSP=0;

    private int maxHp;
    private int maxMp;
    private int maxSp;

    private int currentHp;
    private int currentMp;
    private int currentSp;

    //角色名称
    private String name;

    //恢复速率
    private double rateOfRenewHp;

    private CharacterState state;

    public CharacterState getState() {
        return state;
    }

    private CharacterParams(Builder builder){
        name=builder.name;

        rateOfRenewHp=builder.rateOfRenewHp;

        maxHp=builder.maxHp;
        maxMp=builder.maxMp;
        maxSp=builder.maxSp;

        currentHp=maxHp;
        currentMp=maxMp;
        currentSp=maxSp;

        state=new CharacterState();
    }

    public void addOneTime(){
        if(currentHp<maxHp){
            currentHp+=maxHp*rateOfRenewHp;
            if(currentHp>maxHp) {
                currentHp=maxHp;
            }
            System.out.println("角色："+name+"回血了。\t目前血量: "+currentHp);
        }else{
            System.out.println("角色："+name+"满血了。");
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Builder pattern
    public static class Builder{
        //可选参数（默认初始化）
        private int maxHp = DEFAULT_MAXHP;
        private int maxMp = DEFAULT_MAXMP;
        private int maxSp = DEFAULT_MAXSP;

        private int currentHp=maxHp;
        private int currentMp=maxMp;
        private int currentSp=maxSp;
        //恢复速率
        private double rateOfRenewHp=0.1;

        //必需参数
        private String name;//角色名称

        //构造函数
        public Builder(String name){
            this.name=name;
        }

        public Builder maxHp(int val){
            maxHp=val;
            return this;
        }

        public Builder maxMp(int val){
            maxMp=val;
            return this;
        }

        public Builder maxSp(int val){
            maxSp=val;
            return this;
        }

        public Builder rateOfRenewHp(double val){
            rateOfRenewHp=val;
            return this;
        }

        public CharacterParams build(){
            return new CharacterParams(this);
        }
    }
}
