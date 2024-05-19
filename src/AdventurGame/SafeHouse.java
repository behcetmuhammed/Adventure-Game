package AdventurGame;

//Güvenli Ev
public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super("Güvenli Ev", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz! Canınız Yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}
