package MobileThird;
/*
 其中包含一个常量ATK，表示敌人的伤害值，并选择在构造方法中对其赋值；
包含两个方法：
1. 攻击王子的方法，并接收王子的闪避系统参数：void attack(Dodge dodge)，在其中
调用闪避系统的闪避方法。
2. 被王子反击的方法：void attacked()，在其中直接打印“反击成功”的字符串即可（在闪
避系统里回调该方法）。
在Dodge类中声明一个静态常量表示王子自身的防御值DODGE。选择逃跑时直接打印“王子逃跑”的字符
串即可。
*/
public class Enemy {
    private int attack;

    public Enemy() {
    }

    public Enemy(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void atk(Dodge dodge) {
        dodge.dodgeEnemy(this);
    }

    public void attacked() {
        System.out.println("反击成功");
    }
}
