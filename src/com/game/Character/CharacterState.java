package com.game.Character;

public class CharacterState {

    public static final int FLAG_INVINCIBLE=0;
    public static final int FLAG_NOMARL = 1;
    public static final int FLAG_FIGHTING = 2;
    public static final int FLAG_DIED = 3;
    private int currentLifeState = FLAG_NOMARL;

    //是否允许恢复状态，默认允许
    private boolean isAllowRenew=true;

    /**
     * 无敌和正常的生命状态下允许角色回复状态
     * @return
     */
    public boolean isAllowRenew() {
        return ( isAllowRenew?currentLifeState <= FLAG_NOMARL:false );
    }


    public int getCurrentLifeState() {
        return currentLifeState;
    }

    public void setCurrentLifeState(int currentLifeState) {
        this.currentLifeState = currentLifeState;
    }

    public void setAllowRenew(boolean allowRenew) {
        isAllowRenew = allowRenew;
    }
    public boolean getAllowRenew(){
        return isAllowRenew;
    }
}
