package com.game.Character;

public class CharacterParams {


    private static final int DEFAULT_MAXHP=100;
    private static final int DEFAULT_MAXMP=30;
    private static final int DEFAULT_MAXSP=10;

    private int MaxHp;
    private int MaxMp;
    private int MaxSP;

    private int mCurrentHp;
    private int mCurrentMp;
    private int mCurrentSp;

    //恢复速率
    private double rateOfRenewHp=0.1;

    private CharacterState mCState;

    public CharacterParams(){
        MaxHp=DEFAULT_MAXHP;
        MaxMp=DEFAULT_MAXMP;
        MaxSP=DEFAULT_MAXSP;

        mCState=new CharacterState();

        renew();
    }

    protected String renew(){
        if(!allowRenew()){
            return "Can't renew!";
        }
        mCurrentHp=MaxHp;
        mCurrentMp=MaxMp;
        mCurrentSp=MaxSP;

        return "";
    }

    //check if allow renew
    private boolean allowRenew(){
        if((mCState.getCurrentState()& CharacterState.FLAG_ALLOW_RENEW)!=0){
            return true;
        }
        return false;
    }

    class CharacterState{
        public static final int FLAG_ALLOW_RENEW=0x00;

        public int getCurrentState(){
            return FLAG_ALLOW_RENEW;
        }
    }
}
