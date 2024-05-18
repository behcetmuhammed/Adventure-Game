package AdventurGame;

import java.util.Locale;
import java.util.Random;

//Savaş lokasiyonu (yeri)
public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(String name, Player player, Obstacle obstacle, String award, int maxObstacle) {
        super(name, player);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obstacleNum = this.randomObstacleNumber();

        System.out.println("Şu An Buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obstacleNum + " Tane " + this.getObstacle().getName() + " Yaşıyor");
        System.out.println("-------------------");
        System.out.print("<S>avaş veya <K>aç: ");
        String selecetCase = input.next();
        selecetCase = selecetCase.toUpperCase();
        if (selecetCase.equals("S") && combat(obstacleNum)) {
            //Savaşın başladığı blok
            System.out.println(this.getName() + " Tüm Duşmanları Yendiniz!");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNum) {
        for (int i = 1; i <= obstacleNum; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStatistics();
            ObstacleStatistics(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("-------------------");
                System.out.print("<V>ur veya <K>aç: \n");
                String selectCombat = input.next();
                selectCombat = selectCombat.toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("[[[[[[ Siz Vurdunuz! ]]]]]]");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("[[[[[[ Canavar Size Vurdu! ]]]]]]");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Duşmanı Yendiniz!");
                System.out.println(this.getObstacle().getAward() + " Para Kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }


    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStatistics() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Oyuncu Değerleri: ");
        System.out.println();
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println();
    }

    public void ObstacleStatistics(int i) {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(i + "." + " <" + this.getObstacle().getName() + "> Canavarının Değerleri: ");
        System.out.println();
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
        System.out.println();
    }


    public int randomObstacleNumber() {
        Random rand = new Random();
        return rand.nextInt(this.getMaxObstacle()) + 1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
