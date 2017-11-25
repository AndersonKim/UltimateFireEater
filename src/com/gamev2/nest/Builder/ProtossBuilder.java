package com.gamev2.nest.Builder;

import com.gamev2.nest.GroundArmy;
import com.gamev2.nest.Harvestor;
import com.gamev2.nest.Protoss.Probe;
import com.gamev2.nest.Protoss.Zealot;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */
public class ProtossBuilder implements GameBuilder {
    @Override
    public Harvestor buildHarvestor() {
        return new Probe();
    }

    @Override
    public GroundArmy buildGroundArmy() {
        return new Zealot();
    }
}
