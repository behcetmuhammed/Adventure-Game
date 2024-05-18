package AdventurGame;

public class Armur {
    private String name;
    private int id;
    private int block;
    private int price;

    public Armur(String name, int id, int block, int price) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    public static Armur[] armurs(){
        Armur[] armursList = new Armur[3];
        armursList[0] = new Armur("Hafif", 1 ,1 , 15);
        armursList[1] = new Armur("Orta", 2 ,3 , 25);
        armursList[2] = new Armur("Ağır", 3 ,5 , 40);
        return armursList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
