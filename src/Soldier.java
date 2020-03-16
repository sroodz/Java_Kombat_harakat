import java.util.Random;

public class Soldier {
    Random random = new Random();

    private int health = 20;
    private int attack = random.nextInt(3) + 1;
    private int defence = random.nextInt(3) + 1;
    private String name;
    private String motto;

    public Soldier(String name, String motto) {
        this.name = name;
        this.motto = motto;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health < 1) {
            System.out.println(this.name + " knocked out--------------------------");
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getName() {
        return name;
    }

    public String getMotto() {
        return motto;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}