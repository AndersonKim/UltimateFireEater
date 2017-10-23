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

    public void setLev(Level lev) {
        this.lev = lev;
    }

    /**
     * 吸收火焰
     * @param fire
     */
    public void eatFire(Fire fire){
        if(fire.isLive()){
           lev.setExpPool(lev.getExpPool()+fire.getExp());
            fire.setLive(false);
        }
        lev.genLev();
    }

    /**
     * 获取玩家的基础信息
     */
    public void getBasicInfo(){
        System.out.println("玩家现在的评级："+lev.getName()+"|经验池："+lev.getExpPool());
    }

    @Override
    public String toString() {
        return "Player{" +
                "lev=" + lev+
                '}';
    }
}
