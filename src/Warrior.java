public class Warrior extends Hero implements Mortal{
    protected int health, power;


    int GetHealth(){
        return health;
    }
    void SetHealth(int health){
        this.health = health;
    }
    Warrior(String name, int power, int health){
        super(name);
        this.health = health;
        this.power = power;

    }

    @Override
    void attackEnemy(Enemy enemy){
        System.out.println(name + " is attacking " + enemy.name + " and damages " + this.power + " hp");
        if (enemy.health < 0){
            power *= 0;
        }
        enemy.takeDamage(power);
    }
    @Override
    void takeDamage(int damage){
        if (this.health < 0){
            damage *= 0;
        }
        health -= damage;
        System.out.println("Warrior has " + this.health + " hp left");

    }
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
