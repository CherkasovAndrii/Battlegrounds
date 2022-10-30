import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleground {
    public static void main(String[] args) {
        //Hero hero = new Hero("Gnida");
        Warrior warrior = new Warrior("Warrior", 10, 100);
        Archer archer = new Archer("Archer", 200, 10);
        Mage mage = new Mage("Mage", 200, 10);
        Enemy enemySkeleton = new Enemy("Skeleton" ,100, 20);
        Zombie zombie = new Zombie("Zombie", 12, 150);

        Scanner in = new Scanner(System.in);

        int userIn = -1, userInput1v1Menu = -1, userInput1v2Menu = -1;

        System.out.println("Choose an action, if you want to: ");
        System.out.println("Enter 1 if you want to have 1v1 fight");
        System.out.println("Enter 2 if you want to have 1v2 or 1v3 fight");

        try {
            userIn = in.nextInt();
        }

        catch (InputMismatchException a) {
            System.out.print("Problem");
        }

        switch(userIn) {
            case -1:
                //You didn't have a valid input
                break;
            case 1:
                System.out.println("Welcome to 1v1 menu! Choose the type of fight please ");
                System.out.println("(1) " + mage.name + " vs " + zombie.name);
                System.out.println("(2) " + mage.name + " vs " + enemySkeleton.name);
                System.out.println("(3) " + warrior.name + " vs " + zombie.name);
                System.out.println("(4) " + warrior.name + " vs " + enemySkeleton.name);

                try {
                    userInput1v1Menu = in.nextInt();
                } catch (InputMismatchException a) {
                    System.out.print("Problem");
                }
                switch (userInput1v1Menu) {
                    case 1 -> {
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while (mage.isAlive() && zombie.isAlive()) {
                                mage.attackEnemy(zombie);
                                zombie.attackHeroes(mage);
                                zombie.rebornZombie();

                        }
                        if (!zombie.isAlive()) {
                            System.out.println(mage.name + " wins");
                        }
                        if (!mage.isAlive()) {
                            System.out.println(zombie.name + " wins");
                        }
                        if (!zombie.isAlive() && !mage.isAlive()){
                            System.out.println("Draw! ");
                        }
                    }
                    case 2 -> {
                        // mage and skeleton
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while (mage.isAlive() && enemySkeleton.isAlive()) {
                            mage.attackEnemy(enemySkeleton);
                            enemySkeleton.attackHeroes(mage);

                        }
                        if (!enemySkeleton.isAlive()) {
                            System.out.println(mage.name + " wins");
                        }
                        if (!mage.isAlive()) {
                            System.out.println(enemySkeleton.name + " wins");
                        }
                        if (!enemySkeleton.isAlive() && !mage.isAlive()){
                            System.out.println("Draw!");
                        }
                    }
                    case 3 -> {
                        //warrior and zombie
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while (warrior.isAlive() && zombie.isAlive()) {
                            warrior.attackEnemy(zombie);
                            zombie.attackHeroes(warrior);
                            zombie.rebornZombie();
                        }
                        if (!zombie.isAlive()) {
                            System.out.println(warrior.name + " wins");
                        }
                        if (!warrior.isAlive()) {
                            System.out.println( zombie.name + " wins");
                        }
                        if (!zombie.isAlive() && !warrior.isAlive()){
                            System.out.println("Draw!");
                        }
                    }
                    case 4 -> {
                        //warrior and skeleton
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while (warrior.isAlive() && enemySkeleton.isAlive()) {
                            warrior.attackEnemy(enemySkeleton);
                            enemySkeleton.attackHeroes(warrior);

                        }
                        if (!enemySkeleton.isAlive()) {
                            System.out.println(warrior.name + " wins");
                        }
                        if (!warrior.isAlive()) {
                            System.out.println( enemySkeleton.name + " wins");
                        }
                        if (!enemySkeleton.isAlive() && !warrior.isAlive()){
                            System.out.println("Draw!");
                        }
                    }
                    default -> System.out.print("Problem");
                }
                break;
            case 2:
                System.out.println("Welcome to multi-fight menu! Choose the type of fight please ");

                System.out.println("(1) " + enemySkeleton.name + " vs " + mage.name + " and " + archer.name);

                System.out.println("(2) " + zombie.name + " vs " + archer.name + " and " + warrior.name);

                try {
                    userInput1v2Menu = in.nextInt();
                } catch (InputMismatchException a) {
                    System.out.print("Problem");
                }
                switch (userInput1v2Menu) {
                    case 1 -> {
                        //Enemy-robot  vs Mage and Archer
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while ((enemySkeleton.isAlive()) || (mage.isAlive() && archer.isAlive())) {
                            enemySkeleton.attackHeroes(mage);
                            mage.attackEnemy(enemySkeleton);
                            enemySkeleton.attackHeroes(archer);
                            archer.attackEnemy(enemySkeleton);

                        }
                        if (!enemySkeleton.isAlive()) {
                            System.out.println(mage.name + " and " +  archer.name + " wins");
                        }
                        if (!archer.isAlive()) {
                            System.out.println(archer.name + " is dead");
                        }
                        if (!mage.isAlive()) {
                            System.out.println(mage.name + " is dead");
                        }
                        if (!archer.isAlive() && !mage.isAlive()) {
                            System.out.println(enemySkeleton.name + " wins");
                        }
                        if (!archer.isAlive() && !mage.isAlive() && !enemySkeleton.isAlive()){
                            System.out.println("Draw!");
                        }
                    }
                    case 2 -> {
                        for (int clear = 0; clear < 50; clear++) {
                            System.out.println("\b");
                        }
                        while ((zombie.isAlive()) || (archer.isAlive() && warrior.isAlive())) {
                            zombie.attackHeroes(archer);
                            archer.attackEnemy(zombie);
                            zombie.attackHeroes(warrior);
                            warrior.attackEnemy(zombie);
                            zombie.rebornZombie();
                        }
                        if (!archer.isAlive()) {
                            System.out.println(archer.name + " is dead");
                        }
                        if (!warrior.isAlive()) {
                            System.out.println(warrior.name + " is dead");
                        }
                        if (!zombie.isAlive()) {
                            System.out.println(zombie.name + " is dead");
                        }
                        if (!zombie.isAlive()) {
                            System.out.println(archer.name + " and " + warrior.name +" wins");

                        }
                        if (!archer.isAlive() && !warrior.isAlive()) {
                            System.out.println(zombie.name +" wins");
                        }
                        if (!archer.isAlive() && !warrior.isAlive() && zombie.isAlive()){
                            System.out.println("Draw!");
                        }
                    }
                    default -> System.out.print("Problem");
                }

                break;
            default:
                System.out.print("Problem");
                break;


        }
    }
}
