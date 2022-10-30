abstract public class Hero implements Mortal {
    public String name;
    protected int power = 20;
    protected int health = 100;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    abstract void attackEnemy(Enemy enemy);
    abstract void takeDamage(int damage);
    public boolean isAlive() {
        return this.health > 0;
    }
}
