package AdventurGame;

//Samuray, Şovalye ve Okçu
public abstract class GameChar{
    private int id;
    private String name;
    private int health;
    private int money;
    private int damage;

    public GameChar(int id, int health, int money, int damage, String name) {
        this.id = id;
        this.health = health;
        this.money = money;
        this.damage = damage;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
