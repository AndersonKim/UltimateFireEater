package com.game.Item;

/**
 * edited by AndersonKim
 * at 2017/10/26
 */

/**
 * 战斗技巧:斗技
 * 通常修改玩家可以使用的技能
 */
public class Skill extends GestLevel{
    String name;
    String info;
    /*物防魔防，物攻魔攻*/
    double attackOnMagic;
    double defenceOnMagic;
    double attackOnPhysics;
    double defenceOnPhysics;
    //特殊技能
    String specialAttack;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getAttackOnMagic() {
        return attackOnMagic;
    }

    public void setAttackOnMagic(double attackOnMagic) {
        this.attackOnMagic = attackOnMagic;
    }

    public double getDefenceOnMagic() {
        return defenceOnMagic;
    }

    public void setDefenceOnMagic(double defenceOnMagic) {
        this.defenceOnMagic = defenceOnMagic;
    }

    public double getAttackOnPhysics() {
        return attackOnPhysics;
    }

    public void setAttackOnPhysics(double attackOnPhysics) {
        this.attackOnPhysics = attackOnPhysics;
    }

    public double getDefenceOnPhysics() {
        return defenceOnPhysics;
    }

    public void setDefenceOnPhysics(double defenceOnPhysics) {
        this.defenceOnPhysics = defenceOnPhysics;
    }

    public String getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }
}
