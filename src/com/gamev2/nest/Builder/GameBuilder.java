package com.gamev2.nest.Builder;

/**
 * edited by AndersonKim
 * at 2017/11/24
 */

import com.gamev2.nest.GroundArmy;
import com.gamev2.nest.Harvestor;

/**
 * provide all build in game
 * this builder divide prodect into harvestor and army
 */
public interface GameBuilder {
    public Harvestor buildHarvestor();
    public GroundArmy buildGroundArmy();

}
