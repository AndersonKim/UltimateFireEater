package com.game.Player;

import com.game.Common.Level;
import com.game.Item.Fire;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

/**
 * 玩家
 */
public class Player {
    private Level lev;
    public Player(){
        lev=new Level();
    }

    public Level getLev() {
        return lev;
    }

    private void setLev(Level lev) {
        this.lev = lev;
    }

    /**
     * 吸收火焰
     * @param fire 异火
     */
    public void eatFire(Fire fire){
        if(fire.isLive()){
           lev.suckEXP(fire.getExp());
           fire.setLive(false);
        }
    }

    /**
     * 获取玩家的基础信息
     */
    public void getBasicInfo(){
        System.out.println("玩家现在的评级："+lev.getName()+"|经验池："+lev.getExpPool()+"/"+lev.getExpLimit());
    }

    @Override
    public String toString() {
        return "Player{" +
                "lev=" + lev+
                '}';
    }
}
