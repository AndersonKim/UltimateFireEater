package com.game.Item;

import com.game.Character.Player;

/**
 * 验魔石碑 参见第一章
 */
public class RankStone {
    //斗之气分一至十段
    public static String rank="斗之气";
    public static String[] subRank={"一段","二段","三段","四段","五段","六段",
            "七段","八段","九段"};
    //高阶和低阶斗之气的分界
    public static int rankDivider=4;

    /**
     * 测试玩家的斗之气阶段的评价
     * @param player 玩家
     * @return 斗之气X段|低级/高级
     */
    public static String testRank(Player player){
        if (player.getLev().getLevels()>1){
            return "验魔石碑承受不住能量继而炸裂开来";
        }else{
            int r=(int)player.getLev().getExpPool()/20;
            String info=r>4?"高级":"低级";
            return rank+subRank[r]+"|"+info;
        }
    }
}
