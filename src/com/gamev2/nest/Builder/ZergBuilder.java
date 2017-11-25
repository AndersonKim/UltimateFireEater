package com.gamev2.nest.Builder;

import com.gamev2.nest.GroundArmy;
import com.gamev2.nest.Harvestor;
import com.gamev2.nest.Zerg.Queue;
import com.gamev2.nest.Zerg.Zergling;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */
public class ZergBuilder implements GameBuilder {
    @Override
    public Harvestor buildHarvestor() {
        return new Queue();
    }

    @Override
    public GroundArmy buildGroundArmy() {
        return new Zergling();
    }
}
