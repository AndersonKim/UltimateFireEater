package com.game.Character;

public class CharacterParams {
    public static final int ADD_ONETIME=1*1000;// 1s

    private static final int DEFAULT_MAXHP=100;
    private static final int DEFAULT_MAXMP=30;
    private static final int DEFAULT_MAXSP=0;

    private Coefficient coefficient;//系数

    //正常状态下，角色三维的最大值
    private int maxHp;
    private int maxMp;
    private int maxSp;

    //战斗状态下的三维最大值
    //开始战斗时从 正常三维 取值，计算
    private int currentMaxHp;//角色受伤了,当前最大生命值可能降低
    private int currentMaxMp;
    private int currentMaxSp;

    //当前三维值
    private int currentHp;
    private int currentMp;
    private int currentSp;

    //角色名称
    private String name;

    //角色属性
    private int strength=10;//力道,决定物理攻击力/防御力,physicalATK/DEF
    private int dexterity=10;//敏捷,决定闪避值,dodgeRate
    private int vitality=10;//根骨,决定最大生命值上限/血量回复速率，maxHp/renewHp
    private int insight=10;//洞察,决定命中率,hitRate
    private int soul=5;//魂力,决定魔法攻击力/防御力,manaATK/DEF
    private int spirit=5;//精神,决定魔法值上限/魔量回复速率,maxMp/renewMp

    //角色战斗属性
    private int physicalATK;//物理攻击力
    private int physicalDEF;//物理防御力
    private int manaATK;//魔法攻击力
    private int manaDEF;//魔法防御力

    private double hitRate=1;//命中率
    private double dodgeRate=0.233;//闪避率

    private double criticalRate=0.00001;//暴击率

    //恢复速率
    private int renewHp;
    private int renewMp;

    private void setAttribute() {
        physicalATK = (int) (coefficient.getCoePhysicalATK() * strength);
        physicalDEF = (int) (coefficient.getCoePhysicalDEF() * strength);

        manaATK = (int) (coefficient.getCoeManaATK() * soul);
        manaDEF = (int) (coefficient.getCoeManaDEF() * soul);

        hitRate += coefficient.getCoeHitRate() * insight;
        dodgeRate += coefficient.getCoeDodgeRate() * dexterity;

        maxHp = (int) (coefficient.getCoeHp() * vitality);
        maxMp = (int) (coefficient.getCoeMp() * spirit);

        renewHp = (int) (coefficient.getCoeRenewHp() * vitality);
        renewMp = (int) (coefficient.getCoeRenewMp() * spirit);
    }
    private CharacterState state;
    public CharacterState getState() {
        return state;
    }

    private CharacterParams(Builder builder){
        //执行顺序很重要
        coefficient=new Coefficient();
        //设置战斗属性
        setAttribute();

        name=builder.name;
        renewHp=builder.renewHp;
        maxHp=builder.maxHp;
        maxMp=builder.maxMp;
        maxSp=builder.maxSp;

        currentHp=maxHp;
        currentMp=maxMp;
        currentSp=maxSp;
        state=new CharacterState();
    }

    public void addOneTime(){
        if(currentHp<maxHp){
            currentHp+=renewHp;
            if(currentHp>maxHp) {
                currentHp=maxHp;
            }
            System.out.println("角色："+name+"回血了。\t目前血量: "+currentHp);
        }else{
            System.out.println("角色："+name+"满血了。");
        }
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Builder pattern
    public static class Builder{
        //可选参数（默认初始化）
        private int maxHp = DEFAULT_MAXHP;
        private int maxMp = DEFAULT_MAXMP;
        private int maxSp = DEFAULT_MAXSP;

        private int currentHp=maxHp;
        private int currentMp=maxMp;
        private int currentSp=maxSp;
        //恢复速率
        private int renewHp=2;

        //必需参数
        private String name;//角色名称

        //构造函数
        public Builder(String name){
            this.name=name;
        }

        public Builder maxHp(int val){
            maxHp=val;
            return this;
        }

        public Builder maxMp(int val){
            maxMp=val;
            return this;
        }

        public Builder maxSp(int val){
            maxSp=val;
            return this;
        }

        public Builder renewHp(int val){
            renewHp=val;
            return this;
        }

        public CharacterParams build(){
            return new CharacterParams(this);
        }
    }

    //输出角色面板
    public void printParams(boolean isAttcking){
        System.out.println("--------------------------------------------------------------");
        System.out.println("                         角色面板                              ");
        System.out.println(" 姓名："+name);
        System.out.println(" 力道："+Integer.toString(strength)+"\t敏捷："+Integer.toString(dexterity));
        System.out.println(" 根骨："+Integer.toString(vitality)+"\t洞察："+Integer.toString(insight));
        System.out.println(" 魂力："+Integer.toString(soul)+"\t精神："+Integer.toString(spirit));
        System.out.println("--------------------------------------------------------------");
        System.out.println(" 气血："+Integer.toString(currentHp)+"/"+Integer.toString(maxHp));
        System.out.println(" 膜量："+Integer.toString(currentMp)+"/"+Integer.toString(maxMp));
        System.out.println("--------------------------------------------------------------");
        System.out.println(" 物理攻击力："+Integer.toString(physicalATK)+"\t物理防御力："+Integer.toString(physicalDEF));
        System.out.println(" 膜法攻击力："+Integer.toString(manaATK)+"\t膜法防御力："+Integer.toString(manaDEF));
        System.out.println(" 命中率："+Double.toString(hitRate*100)+"%\t闪避率："+Double.toString(dodgeRate*100)+"%");
        System.out.println(" 会心率："+Double.toString(criticalRate*100)+"%\t会心伤害："+Double.toString(100)+"%");
        System.out.println("--------------------------------------------------------------");
    }

    public class Coefficient {
        private double coePhysicalATK = 2.0;
        private double coePhysicalDEF = 1.2;
        private double coeManaATK = 1.0;
        private double coeManaDEF = 0.8;
        private double coeHitRate = 0.002;//每5点洞察1%的命中
        private double coeDodgeRate = 0.0015;//闪避值

        private double coeHp = 10;//每1点根骨10点血量
        private double coeMp = 6;//每1点魂力3点魔量
        private double coeRenewHp = 2;//每1点根骨回血2/s
        private double coeRenewMp = 1;//每1点魂力回魔1/s

        public double getCoePhysicalATK() {
            return coePhysicalATK;
        }

        public double getCoePhysicalDEF() {
            return coePhysicalDEF;
        }

        public double getCoeManaATK() {
            return coeManaATK;
        }

        public double getCoeManaDEF() {
            return coeManaDEF;
        }

        public double getCoeHitRate() {
            return coeHitRate;
        }

        public double getCoeDodgeRate() {
            return coeDodgeRate;
        }

        public double getCoeHp() {
            return coeHp;
        }

        public double getCoeMp() {
            return coeMp;
        }

        public double getCoeRenewHp() {
            return coeRenewHp;
        }

        public double getCoeRenewMp() {
            return coeRenewMp;
        }

    }
}
