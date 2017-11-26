package com.game.Character;

/**
 * by SwallowJoe
 *
 */
public class Character implements Runnable {

    public String TAG = "Character";

    private CharacterParams mParams;

    public Character(String name) {
        mParams = new CharacterParams.Builder(name).maxHp(10000).renewHp(20).build();
        System.out.println("角色：" + mParams.getName() + "出生了。");
        mParams.setCurrentHp(10);
    }

    public Character(CharacterParams params) {
        this.mParams = params;
    }

    public void prinlnParams() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (Exception e) {
        }
        mParams.printParams(true);
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    Thread.sleep(CharacterParams.ADD_ONETIME);
                    renewOneTime();
                    prinlnParams();
                } catch (Exception e) {

                }
            }
        }
    }

    private void renewOneTime() {
        synchronized (this) {
            renewOneTimeLocked();
        }
    }

    private void renewOneTimeLocked() {
        if (isAllowRenew()) {
            mParams.addOneTime();
        }
    }

    private boolean isAllowRenew() {
        return mParams.getState().isAllowRenew();
    }
}
