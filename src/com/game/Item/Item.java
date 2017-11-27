package com.game.Item;

/**
 * Created by Joseph.Huang on 2017/11/27.
 * 所有物品的基类
 */

public abstract class Item {
    public static final int DEFAULT_STACK_SIZE = 1;
    public static final int A_GROUP_STACK_SIZE = 99;
    public static final int MAX_STACK_SIZE = 999;

    /**
     * 获取物品唯一标识
     *
     * @return 物品标识
     */
    public abstract int getID();

    /**
     * 获取物品名称
     *
     * @return 物品名称
     */
    public abstract String getName();

    /**
     * 获取物品类型
     *
     * @return 物品类型
     */
    public abstract ItemType getType();

    /**
     * 该物品可叠加的最大数量（比如在背包里占一格，99个）
     *
     * @return
     */
    public abstract int getStackSize();

    /**
     * 当前物品的数量，一般是1，用于物品的叠加
     * @return
     */
    public abstract int getCurrentNumber();

    /**
     * 设置当前物品数量
     * @param number 数量
     */
    public abstract void setCurrentNumber(int number);

    /**
     * 对当前物品的拷贝
     * @return
     */
    public abstract Item copy();

    /**
     * 物品的类型
     */
    public class ItemType {
        private int typeFlag;//物品大类
        private int detailFlag;//详细分类

        public ItemType(int typeFlag, int detailFlag) {
            this.typeFlag = typeFlag;
            this.detailFlag = detailFlag;
        }

        //物品大类
        public static final int FLAG_EQUIPMENT = 0x1;//装备类，如武器、衣服、首饰等
        public static final int FLAG_MYSTERY = 0x2;//功法类
        public static final int FLAG_COMSUE = 0x3;//消耗品，如回血药

        //装备分类
        public static final int FLAG_EQUIPMENT_WEAPON = 0x1;//武器

    }
}
