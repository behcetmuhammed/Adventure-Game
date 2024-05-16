package AdventurGame;

public class Game extends Player {
    Player player;
    Location location;

    public Game(boolean water, boolean food, boolean fireword, String weaponName, String armorName, int weaponDamage, int armorDefence, Inventory inventory, int money, int healthy, int damage, String name, Player player, Location location) {
        super(water, food, fireword, weaponName, armorName, weaponDamage, armorDefence, inventory, money, healthy, damage, name);
        this.player = player;
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void start(){

    }
}
