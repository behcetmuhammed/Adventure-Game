package AdventurGame;

public class Player extends Inventory{
    private int money; //para
    private int healthy; //sağlıklı (sağlam)
    private int damage; //hasar
    private String name;

    public Player(boolean water, boolean food, boolean fireword, String weaponName, String armorName, int weaponDamage, int armorDefence, Inventory inventory, int money, int healthy, int damage, String name) {
        super(water, food, fireword, weaponName, armorName, weaponDamage, armorDefence, inventory);
        this.money = money;
        this.healthy = healthy;
        this.damage = damage;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
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

    public void selectChar(){

    }
}
