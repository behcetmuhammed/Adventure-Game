package AdventurGame;

import java.util.Random;

//Maden
public class Mine extends BattleLoc {

    public Mine(Player player) {
        super("Maden", player, new Snake(), "Süpriz Kutu!", randObstacle());
    }

    public static int randObstacle() {
        Random rand = new Random();

        int randObstacleNum = rand.nextInt(1, 6); //1 ile 5 arasında rastgele Yılan sayısı
        return randObstacleNum;
    }

}
