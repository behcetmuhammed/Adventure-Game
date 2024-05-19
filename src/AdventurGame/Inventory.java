package AdventurGame;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    Weapon weapon;
    Armor armor;

    private List<String> awards;

    public Inventory() {
        this.weapon = new Weapon("Yok", -1, 0, 0);
        this.armor = new Armor("Yok", -1, 0, 0);
        this.awards = new ArrayList<>();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    //////////////////


    public boolean hasAward(String award) {
        return awards.contains(award);
    }

    // Ödül ekleme
    public void addAwards(String award) {
        awards.add(award);
    }

    // Ödül kaldırma
    public void removeAward(String award) {
        awards.remove(award);
    }
    // Ödül listesini alma
    public List<String> getAwards() {
        return awards;
    }

}

