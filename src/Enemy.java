public class Enemy implements Mortal{
    int health, power;
    protected String name;

    public Enemy(String name) {
        this.name = name;
    }

    Enemy(String name, int health, int power){
        this.health = health;
        this.power = power;
        this.name = name;
    }


    int GetHealth(){
        return health;
    }
    void SetHealth(int health){
        this.health = health;
    }
    void takeDamage(int damage){
        if (this.health < 0){
            damage *= 0;
        }
        health -= damage;
        System.out.println(name + " has " + this.health + " hp left");

    }
    void attackHeroes(Hero hero){
        System.out.println(name + " is attacking " + hero.name + " and damages " + this.power + " hp");
        if (hero.health < 0){
            power *= 0;
        }
        hero.takeDamage(power);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
