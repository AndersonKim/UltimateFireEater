package com.game.Item;

/**
 * edited by AndersonKim
 * at 2017/10/23
 */

/**
 * 异火
 */
public class Fire {
    private String name;
    private String note;
    private double exp;
    private boolean live;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Fire(){
        setFire();
    }
    public void setFire(){
        live=true;
        name="基础火焰";
        note="随处可见的普通火焰";
        exp=10.0;
    }

    @Override
    public String toString() {
        return "Fire{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", exp=" + exp +
                ", live=" + live +
                '}';
    }
}
