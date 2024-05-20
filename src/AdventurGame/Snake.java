package AdventurGame;

import java.util.Random;

//Yılan
public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", randDamage(), 12, 0);
    }


    public static int randDamage() {
        Random rand = new Random();

        int damageNew = rand.nextInt(3, 7);     //3 ile 6 arasında rastgele damage
        return damageNew;
    }

}
