package com.gamev2.nest;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

/**
 * harvest the resource
 */
public abstract class GroundArmy {
    public double attackOnTarget(Object target){
        System.out.println(this.getClass()+" is attacking "+target.getClass());
        return 0;
    }
}
