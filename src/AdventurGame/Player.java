package AdventurGame;

import java.util.Scanner;

public class Player{
    private String name;
    private String charName;
    private int damage; //hasar
    private int health; //sağlık
    private int money; //para
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    Scanner input = new Scanner(System.in);

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }




    public void selectChar(){
        System.out.println("Ama İlk Önce Karakterini Seçme Zamanı!");
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("****************************");
        System.out.println("Karakterler: ");
        for (GameChar gameChar : charList) {
            System.out.println("İd: " + gameChar.getId() +
                    ", Karakter: " + gameChar.getName() +
                    ", Hasar: " + gameChar.getDamage() +
                    ", Para: " + gameChar.getMoney());
        }
        System.out.println("****************************");
        System.out.print("Lütfen Bir Karakter Seçin: ");
        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Yanlış Değer Girdiniz. Karakter Otomatik Olarak Samuray Seçildi");
                initPlayer(new Samurai());
        }
        System.out.println(this.getCharName() + " Karakteri Seçildi. \t[Karakter özellikleri --> Hasar: " + this.getDamage() + ", Sağlık: " + this.getHealth() + ", Para: " + this.getMoney() + "]");
    }




    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setMoney(gameChar.getMoney());
        this.setHealth(gameChar.getHealth());
        this.setCharName(gameChar.getName());
    }


}
