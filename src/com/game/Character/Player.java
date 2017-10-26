package com.game.Character;

import com.game.Item.Fire;
import com.game.Item.Gest;
import com.game.Item.Skill;

import java.util.LinkedList;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

/**
 * 玩家
 */
public class Player extends Character{
    private Level lev;
    private LinkedList<Skill> skills;
    private LinkedList<Gest> gests;
    public Player(){
        super();
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

    /**
     * 装备功法
     * @param gest
     */
    public String equipGest(Gest gest){
        if (gests.contains(gest)){
            return "已经装备了同样的功法";
        }else {
            gests.add(gest);
            updateCharacterParams();
            return gest.getName()+"功法装备成功";
        }
    }

    /**
     * 运行功法吸收的经验值
     * @param timeSpan 修炼的时间长度
     */
    public void runGest(int timeSpan){
        double sum=0;
        for(Gest g:gests){
            sum+=g.getSpeed();
        }
        lev.suckEXP(sum);
    }



    /**
     * 根据玩家的当前状态来更新基础属性
     * todo 根据玩家的属性(CharacterParams)来决定功法(Gest)怎么搞
     */
    private void updateCharacterParams(){

    }

    @Override
    public String toString() {
        return "Player{" +
                "lev=" + lev+
                '}';
    }
}
