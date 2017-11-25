package com.gamev2.nest.BuilderV2;

import com.gamev2.nest.Protoss.Probe;
import com.gamev2.nest.Protoss.ProtossItem;
import com.gamev2.nest.Protoss.Zealot;
import com.gamev2.nest.Terran.Marine;
import com.gamev2.nest.Terran.SCV;
import com.gamev2.nest.Terran.TerranItem;
import com.gamev2.nest.Zerg.Queue;
import com.gamev2.nest.Zerg.ZergItem;
import com.gamev2.nest.Zerg.Zergling;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

/**
 *
 */
public class GroundArmyBuilder implements GameBuilderV2 {
    @Override
    public ProtossItem buildPItem() {
        return new Zealot();
    }

    @Override
    public ZergItem buildZItem() {
        return new Zergling();
    }

    @Override
    public TerranItem buildTItem() {
        return new Marine();
    }
}
