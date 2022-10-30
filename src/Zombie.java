import java.util.Objects;

public class Zombie extends Enemy implements Mortal{
    protected int power;
    protected int health;
    protected int newHealthAfterReborn = 75;

    int GetHealth(){
        return health;
    }
    void SetHealth(int health){
        this.health = health;
    }
    Zombie(String name, int power, int health){
        super(name);
        this.power = power;
        this.health = health;
    }
    @Override
    void takeDamage(int damage){
        if (this.health < 0){
            damage *= 0;
        }
        int randomDodge = (int) (Math.random() * 100);
        if (randomDodge <= 80) {
            health -= damage;
            System.out.println("Zombie has " + this.health + " hp left");
        }
        else if (randomDodge > 81 && randomDodge < 95){
            health -= damage * 0.5;
            System.out.println("Zombie has avoided attack and got 50% of the damage and has " + this.health + " hp left");
        }
        else if (randomDodge > 96){
            health -= damage * 0.1;
            System.out.println("Zombie has avoided attack and got 10% of the damage and has " + this.health + " hp left");
        }
    }
    @Override
    void attackHeroes(Hero hero){
        System.out.println(this.name + " is attacking " + hero.name + " and damages " + this.power + " hp");
        hero.takeDamage(power);
        if (hero.health < 0){
            power *= 0;
        }
    }

    void rebornZombie(){
        int randomReborn = (int) (Math.random() * 100);
        if (randomReborn > 90){
            health = newHealthAfterReborn;
            System.out.println("Zombie reborned and got new health " + this.health);
        }
    }
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
