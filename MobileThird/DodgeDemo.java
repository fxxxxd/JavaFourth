package MobileThird;

import java.util.Scanner;

/*
1. 抽象类：Dodge.class，表示对闪避系统的抽象，其中包含一个抽象方法dodgeEnemy()和一个
Dodge本身的变量next，如果当前防御系统不满足条件，则调用next变量执行其中的
dodgeEnemy()方法。下面有一个简单的示例：
最后你需要在主函数中，将四个等级的闪避系统对象依次赋值给上一级闪避系统的next变量。像下
面这样：
2. 具体实现类：DodgeLv1.class, DodgeLv2.class, DodgeLv3.class, DodgeLv4.class，分别表示四个
等级的闪避系统。
public abstract Dodge {
Dodge next; // 下一级闪避系统
abstract void dodgeEnemy(Enemy enemy); // 躲避敌人攻击的抽象方法，在其子类里具
体实现
}
dodgeLv1.setNext(dodgeLv2);
dodgeLv2.setNext(dodgeLv3);
*/
public class DodgeDemo {
    public static void D() {
        Enemy enemy = new Enemy();
        Scanner sc = new Scanner(System.in);
        System.out.println("王子的防御值为：" + Dodge.resistance);
        System.out.print("请给敌人赋予攻击值：");
        int atk = sc.nextInt();
        enemy.setAttack(atk);
        checkAtk(enemy);
        DodgeLv1 dodgeLv1 = new DodgeLv1();
        DodgeLv2 dodgeLv2 = new DodgeLv2();
        DodgeLv3 dodgeLv3 = new DodgeLv3();
        DodgeLv4 dodgeLv4 = new DodgeLv4();
        dodgeLv1.setNext(dodgeLv2);
        dodgeLv2.setNext(dodgeLv3);
        dodgeLv3.setNext(dodgeLv4);
        System.out.print("王子");
        enemy.atk(dodgeLv1);
    }

    public static void checkAtk(Enemy e) throws AtkException {
        if(e.getAttack()<0 || e.getAttack()>1000){
            throw new AtkException("你赋予的攻击值有误（0~1000）");
        }
    }
}

class DodgeLv1 extends Dodge {
    public DodgeLv1() {
    }

    @Override
    void dodgeEnemy(Enemy enemy) {
        if (enemy.getAttack() >= (resistance * 3)) {
            System.out.println("逃跑！");
        } else
            getNext().dodgeEnemy(enemy);
    }
}

class DodgeLv2 extends Dodge {
    public DodgeLv2() {
    }

    @Override
    void dodgeEnemy(Enemy enemy) {
        if (enemy.getAttack() >= (resistance * 2)) {
            System.out.println("挡下一击，选择逃跑！");
        } else
            getNext().dodgeEnemy(enemy);
    }
}

class DodgeLv3 extends Dodge {
    public DodgeLv3() {
    }

    @Override
    void dodgeEnemy(Enemy enemy) {
        if (enemy.getAttack() >= resistance) {
            System.out.println("选择躲避本次攻击");
            enemy.attacked();
        } else
            getNext().dodgeEnemy(enemy);
    }
}

class DodgeLv4 extends Dodge {
    public DodgeLv4() {
    }

    @Override
    void dodgeEnemy(Enemy enemy) {
        if (enemy.getAttack() < resistance) {
            System.out.println("选择直接反击！");
            enemy.attacked();
        } else
            getNext().dodgeEnemy(enemy);
    }
}