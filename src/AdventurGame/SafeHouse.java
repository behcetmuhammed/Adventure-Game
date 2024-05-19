package AdventurGame;

//Güvenli Ev
public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super("Güvenli Ev", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli Evdesiniz! Canınız Yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());

        if (player.getInventory().hasAward("Yemek") && player.getInventory().hasAward("Su") && player.getInventory().hasAward("Odun")) {
            System.out.println("Tebrikler! Tüm Ödülleri Toplayıp Oyunu Kazandınız!");
            return false;
        }

        return true;
    }
}
