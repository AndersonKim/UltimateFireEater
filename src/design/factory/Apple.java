package design.factory;

/**
 * edited by AndersonKim
 * at 2017/11/8
 */
public class Apple extends Logable implements Fruit {
    @Override
    public void grow() {
        log("apple is growing");
    }

    @Override
    public void harvest() {
    log("apple harvested");
    }

    @Override
    public void plant() {
log("planting apple");
    }
}
