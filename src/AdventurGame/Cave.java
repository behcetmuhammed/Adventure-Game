package AdventurGame;

//Mağara
public class Cave extends BattleLoc{

    public Cave(Player player) {
        super("Mağara", player, new Zombie(), "Yemek", 3);
    }
}
