package com.gamev2.nest;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

/**
 * harvest the resource
 */
public abstract class Harvestor {
    public double harvestMin(double Min){
        System.out.println(this.getClass()+" is harvesting min");
        return Min;
    }
    public double harvestGas(double Gas){
        System.out.println(this.getClass()+" is harvesting gas");
        return Gas;
    }
}
