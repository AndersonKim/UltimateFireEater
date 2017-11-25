package com.gamev2.nest.BuilderV2;

import com.gamev2.nest.Protoss.ProtossItem;
import com.gamev2.nest.Terran.TerranItem;
import com.gamev2.nest.Zerg.ZergItem;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

/**
 * this builder divide product into different race item
 */
public interface GameBuilderV2 {
    public ProtossItem buildPItem();
    public ZergItem buildZItem();
    public TerranItem buildTItem();
}
