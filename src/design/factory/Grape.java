package design.factory;

/**
 * edited by AndersonKim
 * at 2017/11/8
 */
public class Grape extends Logable implements Fruit {
    @Override
    public void grow() {
        log("Grape is growing");
    }

    @Override
    public void harvest() {
    log("Grape harvested");
    }

    @Override
    public void plant() {
log("planting Grape");
    }
}
