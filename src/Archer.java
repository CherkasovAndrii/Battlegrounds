public class Archer extends Hero implements Mortal{
    protected int power, health;
    Archer(String name, int health, int power){
        super(name);
        this.health = health;
        this.power = power;
    }
    @Override
    void attackEnemy(Enemy enemy){
        System.out.println(this.name + " is attacking " + enemy.name);
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
        int randomNoDamage = (int) (Math.random() * 100);
        if (randomNoDamage >= 90){
            System.out.println("Archer dodged attack and got no damage and has " + this.health + " hp left");
        }
        else {
            health -= damage;
            System.out.println("Archer has " + this.health + " hp left");
        }
    }
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
