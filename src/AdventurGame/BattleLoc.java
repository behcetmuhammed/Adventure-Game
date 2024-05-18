package AdventurGame;

//Savaş lokasiyonu (yeri)
public class BattleLoc extends Location{

    public BattleLoc(String name, Player player) {
        super(name, player);
    }

    @Override
    public boolean onLocation() {
        return false;
    }
}
