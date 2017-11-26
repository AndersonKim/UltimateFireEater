package com.game.Character;

/**
 * by SwallowJoe
 *
 */
public class Character implements Runnable {
    public String TAG = "Character";
    public static boolean DEBUG=false;

    private CharacterParams mParams;
    private CharacterLevel mLevel;

    private LevelListener levelListener=new LevelListener() {
        @Override
        public void levelUp() {
            //TODO:升级了
            synchronized (mParams){
                mParams.levelUp();
            }
        }
    };

    public Character(String name) {
        mParams = new CharacterParams.Builder(name).maxHp(10000).renewHp(20).build();
        mLevel=new CharacterLevel(levelListener);
        System.out.println("角色：" + mParams.getName() + "出生了。");
        mParams.setCurrentHp(10);
    }

    public Character(CharacterParams params) {
        this.mParams = params;
        mLevel=new CharacterLevel(levelListener);
    }

    public void addExp(int exp){
        mLevel.addExp(exp);
    }
    //输出角色面板
    public void printlnInfo(boolean isAttcking) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("                         角色面板                              ");
        System.out.println(" 姓名：" + mParams.getName()+"\t\t\t\t等级："+mLevel.getLevel());
        System.out.println(" 经验池："+Integer.toString(mLevel.getCurrentExp())+"/"+Integer.toString(CharacterLevel.getExpNeededWhenNextLevelUp(mLevel.getLevel())));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" 力道：" + Integer.toString(mParams.getStrength()) + "\t\t敏捷：" + Integer.toString(mParams.getDexterity()));
        System.out.println(" 根骨：" + Integer.toString(mParams.getVitality()) + "\t\t洞察：" + Integer.toString(mParams.getInsight()));
        System.out.println(" 魂力：" + Integer.toString(mParams.getSoul()) + "\t\t精神：" + Integer.toString(mParams.getSpirit()));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" 可分配属性点：" + Integer.toString(mParams.getAttributePoint()));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" 气血：" + Integer.toString(mParams.getCurrentHp()) + "/" + Integer.toString(mParams.getMaxHp()));
        System.out.println(" 膜量：" + Integer.toString(mParams.getCurrentMp()) + "/" + Integer.toString(mParams.getMaxMp()));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" 物理攻击力：" + Integer.toString(mParams.getPhysicalATK()) + "\t\t物理防御力：" + Integer.toString(mParams.getPhysicalDEF()));
        System.out.println(" 膜法攻击力：" + Integer.toString(mParams.getManaDEF()) + "\t\t膜法防御力：" + Integer.toString(mParams.getManaDEF()));
        System.out.println(" 命中率：" + Double.toString(mParams.getHitRate() * 100) + "%\t\t闪避率：" + Double.toString(mParams.getDodgeRate() * 100) + "%");
        System.out.println(" 会心率：" + Double.toString(mParams.getCriticalRate() * 100) + "%\t\t会心伤害：" + Double.toString(100) + "%");
        System.out.println("---------------------------------------------------------------");
    }

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {
                    Thread.sleep(CharacterParams.ADD_ONETIME);
                    renewOneTime();
                    printlnInfo(false);
                } catch (Exception e) {

                }
            }
        }
    }

    private void renewOneTime() {
        synchronized (this) {
            renewOneTimeLocked();
        }
    }

    private void renewOneTimeLocked() {
        if (isAllowRenew()) {
            mParams.addOneTime();
        }
    }

    private boolean isAllowRenew() {
        return mParams.getState().isAllowRenew();
    }

    public interface LevelListener{
        void levelUp();
    }
}
