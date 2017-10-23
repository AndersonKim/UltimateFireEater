package com.game;

import com.game.Item.Fire;
import com.game.Player.Player;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

/**
 * 游戏控制器，现在用来控制剧本
 */
public class GameController {
    public static void main(String[] args){
        Fire f=new Fire();
        f.setFire();
        Player p=new Player();

        p.getBasicInfo();

        System.out.println("使用一团基础火焰:"+f.getName()+"|"+f.getNote());
        p.eatFire(f);
        p.getBasicInfo();

        System.out.println("接着使用十团基础火焰:"+f.getName()+"|"+f.getNote());
        for (int i=0;i<10;i++){
            p.eatFire(f);
        }
        p.getBasicInfo();

    }
}
