package com.game.Character;

/**
 * by SwallowJoe
 *
 */
public class Character implements Runnable{

    public String TAG="Character";

    private CharacterParams mParams;

    public Character(String name){
        mParams=new CharacterParams.Builder(name).maxHp(10000).rateOfRenewHp(0.01).build();
        System.out.println("角色："+mParams.getName()+"出生了。");
        mParams.setCurrentHp(10);
    }

    public Character(CharacterParams params){
        this.mParams=params;
    }

    @Override
    public void run() {
        synchronized (this){
            while(true){
                try{
                    Thread.sleep(CharacterParams.ADD_ONETIME);
                    renewOneTime();
                }catch (Exception e){

                }
            }
        }
    }

    private void renewOneTime(){
        if(isAllowRenew()){
            mParams.addOneTime();
        }
    }

    private boolean isAllowRenew(){
        return mParams.getState().isAllowRenew();
    }
}
