package AdventurGame;

public class Inventory {
    private boolean water; //su
    private boolean food; //yiyecek
    private boolean firewood; //yakacak odun
    private String weaponName; //silah Adı
    private String armorName; //zırh Adı
    private int weaponDamage; //silah Hasar
    private int armorDefence; //zırh Savunma

    Inventory inventory;

    public Inventory(boolean water, boolean food, boolean firewood, String weaponName, String armorName, int weaponDamage, int armorDefence, Inventory inventory) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.weaponName = weaponName;
        this.armorName = armorName;
        this.weaponDamage = weaponDamage;
        this.armorDefence = armorDefence;
        this.inventory = inventory;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
