package com.gamev2.nest.BuilderV2;

import com.gamev2.nest.Protoss.Probe;
import com.gamev2.nest.Protoss.ProtossItem;
import com.gamev2.nest.Terran.SCV;
import com.gamev2.nest.Terran.TerranItem;
import com.gamev2.nest.Zerg.Queue;
import com.gamev2.nest.Zerg.ZergItem;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

/**
 *
 */
public class HarvestorBuilder implements GameBuilderV2 {
    @Override
    public ProtossItem buildPItem() {
        return new Probe();
    }

    @Override
    public ZergItem buildZItem() {
        return new Queue();
    }

    @Override
    public TerranItem buildTItem() {
        return new SCV();
    }
}
