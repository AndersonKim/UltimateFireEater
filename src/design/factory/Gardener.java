package design.factory;

/**
 * edited by AndersonKim
 * at 2017/11/9
 */
public class Gardener {
    public Fruit factory(String str){
        if(str.equals("Grape")){
            return new Grape();
        }else if(str.equals("Apple")){
            return new Apple();
        }
        return null;
    }

    public static void returnInfo(Fruit fruit){
        fruit.plant();
        fruit.grow();
        fruit.harvest();
    }

    public static void main(String args[]){
        Gardener gardener=new Gardener();
        Fruit a=gardener.factory("Apple");
        Fruit b=gardener.factory("Grape");
        returnInfo(a);
        returnInfo(b);

    }
}
