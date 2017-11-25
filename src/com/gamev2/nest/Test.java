package com.gamev2.nest;

import com.gamev2.nest.Builder.GameBuilder;
import com.gamev2.nest.Builder.ProtossBuilder;
import com.gamev2.nest.Builder.TerranBuilder;
import com.gamev2.nest.Builder.ZergBuilder;
import com.gamev2.nest.BuilderV2.GameBuilderV2;
import com.gamev2.nest.BuilderV2.GroundArmyBuilder;
import com.gamev2.nest.BuilderV2.HarvestorBuilder;

/**
 * edited by AndersonKim
 * at 2017/11/22
 */
public class Test {
    public static void main(String[] args){

        GameBuilder a[]={new TerranBuilder(),new ProtossBuilder(),new ZergBuilder()};
        a[0].buildHarvestor();
        a[0].buildGroundArmy();

        GameBuilderV2 b[]={new GroundArmyBuilder(),new HarvestorBuilder()};
        b[0].buildPItem();
        b[0].buildTItem();
        b[0].buildZItem();
    }
}
