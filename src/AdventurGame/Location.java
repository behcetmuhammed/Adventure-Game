package AdventurGame;

import java.util.Scanner;

public abstract class Location {
    private String name;
    Player player;

    public Location(String name, Player player) {
        this.name = name;
        this.player = player;
    }

    public static Scanner input = new Scanner(System.in);

    public abstract boolean onLocation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
