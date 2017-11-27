package com.game.Item;

import java.util.ArrayList;

/**
 * Created by Joseph.Huang on 2017/11/27.
 * 容器，代表：背包、箱子等
 */

public class Container {
    private static final int NOT_EXIST = -1;
    private static final int DEFAULT_SIZE = 10;
    private int MAX_SIZE = DEFAULT_SIZE;
    private String name;
    private ArrayList<Item> items;

    public Container(String name) {
        items = new ArrayList<>();
        this.name = name;
    }

    public Container(String name, int maxSize) {
        MAX_SIZE = maxSize;
        items = new ArrayList<>();
        this.name = name;
    }

    /**
     * 添加物品
     *
     * @param item 物品
     * @return null 表示物品成功添加至容器内
     */
    public String putItem(Item item) {
        String msg = null;
        synchronized (this) {
            msg = putItemLocked(item);
        }
        return msg;
    }

    /**
     * 添加物品至容器内
     * @param item
     * @return
     */
    private String putItemLocked(Item item) {
        int index = NOT_EXIST;
        if ((index = checkIfExistLocked(item.getID())) == NOT_EXIST) {//容器内不存在物品时
            //检查容器容量
            if (items.size() == MAX_SIZE) {
                return (name + "满了！");
            }
            //容器内不存在该物品且容量充足时
            //直接添加至容器
            items.add(item);
            return null;
        }
        //对于容器内存在物品时，情况稍微复杂些
        //首先确认该物品可叠加的数量
        if (item.getStackSize() == Item.DEFAULT_STACK_SIZE) {//可叠加数目为：1,也就是不可叠加时
            //检查容器容量
            if (items.size() == MAX_SIZE) {
                return (name + "满了！");
            }
            //容器内容量充足时
            //直接添加至容器
            items.add(item);
            return null;
        } else {//可叠加数量大于1
            int currentNumber = items.get(index).getCurrentNumber();
            currentNumber += item.getCurrentNumber();
            if (currentNumber <= item.getStackSize()) {
                item.setCurrentNumber(currentNumber);
                items.add(item);
                return null;
            } else {//叠加后数量超过了该物品可叠加的最大数量
                int vol = (int) (Math.floor(currentNumber / item.getStackSize()));//向下取整，去掉小数。
                if (currentNumber % item.getStackSize() != 0)//存在小数时
                    vol += 1;//额外占一个格子
                if (items.size() <= MAX_SIZE - vol) {//目前有足够的空格
                    items.get(index).setCurrentNumber(item.getStackSize());//设置为最大数量
                    currentNumber -= item.getStackSize();//去掉保存的物品数量
                    for (int i = 1; i < vol; i++) {//去掉本身存在物品的格子
                        Item itemInternal = items.get(index).copy();
                        currentNumber -= item.getStackSize();
                        items.add(itemInternal);
                    }
                }
                //这里其实可以优化，比如将物品先填满该容器再说~~
                //TODO 待优化
                return (name + "内空间不足！");
            }
        }
    }

    /**
     * 容器内是否存在该物品
     *
     * @param id 物品id（唯一标识）
     * @return NOT_EXIST 表示不存在，否则表示物品所处的index
     */
    private int checkIfExistLocked(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (id == items.get(i).getID()) {//存在该物品
                return i;
            }
        }
        return NOT_EXIST;
    }

    public int getNumberOfItem(Item item) {
        int number = 0;
        synchronized (this) {
            number = getNumberOfItemLocked(item.getID());
        }
        return number;
    }

    public int getNumberOfItemLocked(int id) {
        int index;
        if ((index = checkIfExistLocked(id)) != NOT_EXIST) {
            //存在该物品时，返回其数量
            return items.get(index).getCurrentNumber();
        }
        //不存在物品时，返回0
        return 0;
    }
}