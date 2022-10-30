public class Mage extends Hero implements Mortal{
    protected int power, health;
    Mage(String name, int health, int power){
        super(name);
        this.health = health;
        this.power = power;
    }
    @Override
    void attackEnemy(Enemy enemy){
        int randomAdditionalMagicDamage = (int) (Math.random() * 100);
        if (randomAdditionalMagicDamage >= 90){
            power *= 1.15;

        }
        if (randomAdditionalMagicDamage <= 10){
            power *= 0.9;

        }
        if (randomAdditionalMagicDamage >= 99){
            power *= 3;

        }
        if (enemy.health < 0){
            power *= 0;
        }
        System.out.println(this.name + " is attacking " + enemy.name + " and damages " + this.power + " hp");
        enemy.takeDamage(power);
    }
    @Override
    void takeDamage(int damage){
        if (this.health < 0){
            damage *= 0;
        }
        health -= damage;
        System.out.println("Mage has " + this.health + " hp left");

    }
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
