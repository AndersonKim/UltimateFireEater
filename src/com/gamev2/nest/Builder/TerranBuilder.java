package com.gamev2.nest.Builder;

import com.gamev2.nest.GroundArmy;
import com.gamev2.nest.Harvestor;
import com.gamev2.nest.Terran.Marine;
import com.gamev2.nest.Terran.SCV;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */
public class TerranBuilder implements GameBuilder {
    @Override
    public Harvestor buildHarvestor() {
        return new SCV();
    }

    @Override
    public GroundArmy buildGroundArmy() {
        return new Marine();
    }
}
