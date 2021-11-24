package MobileThird;

public abstract class Dodge {
    Dodge next;
   public static final int  resistance=100;

    abstract void dodgeEnemy(Enemy enemy);

    public Dodge getNext() {
        return next;
    }

    public Dodge setNext(Dodge next) {
        this.next = next;
       return this.next;
    }
}
