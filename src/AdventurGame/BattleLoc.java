//BattleLoc

package AdventurGame;

import java.util.List;
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
            System.out.println("< " + this.getName() + " > : Buradaki Tüm Duşmanları Yendiniz!");
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }

        return true;
    }

    Random rand = new Random();

    public boolean combat(int obstacleNum) {
        for (int i = 1; i <= obstacleNum; i++) {

            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth()); //Sonraki canavarın canının tekrardan fulluyor

            playerStatistics(); //oyuncu değerleri
            ObstacleStatistics(i); //canavar değerleri


            boolean isPlayerTurn = rand.nextBoolean(); //Kimin ilk vuracağını belirleyen variable;

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                //savaşın başladığı blok
                System.out.println("-------------------");
                System.out.print("<V>ur veya <K>aç: ");
                System.out.println();

                String selectCombat = input.next();
                selectCombat = selectCombat.toUpperCase();

                //Günceleme
                if (selectCombat.equals("V")) {
                    if (isPlayerTurn) {
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
                        System.out.println("[[[[[[ Canavar Size Vurdunuz! ]]]]]]");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);

                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("[[[[[[ Siz Vurdunuz! ]]]]]]");
                            this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
            System.out.println("Duşmanı Yendiniz!");
            System.out.println(this.getObstacle().getAward() + " Para Kazandınız!");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
            System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
            System.out.println("Kazandığın Ödül: " + this.award);

            if (!getPlayer().getInventory().hasAward(this.award)) {
                getPlayer().getInventory().addAwards(this.award);
            }

            System.out.println("Güncel Ödül Listesiniz: " + getPlayer().getInventory().getAwards());

            /////***********///////
                /*
                    1-15 gelirse: Silah Kazanma İhtimali : 15%
                                -- Tüfek Kazanma İhtimali : 20%
                                -- Kılıç Kazanma İhtimali : 30%
                                -- Tabanca Kazanma İhtimali : 50%
                    16-30 gelirse: Zırh Kazanma İhtimali : 15%
                                -- Ağır Zırh Kazanma İhtimali : 20%
                                -- Orta Zırh Kazanma İhtimali : 30%
                                -- Hafif Zırh Kazanma İhtimali : 50%
                    31-45 gelirse: Para Kazanma İhtimali : 25%
                                -- 10 Para Kazanma İhtimali: 20%
                                -- 5 Para Kazanma İhtimali: 30%
                                -- 1 Para Kazanma İhtimali: 50%
                    46-100 gelirse: Ödül Yok
                                -- Hiç birşey kazanamama ihtimali : 45%
                 */
            //Game game = new Game();
            if (isEnteredMiningMap) { //Daha önce Maden Haritasına girmediysen

                int rewardRate = rand.nextInt(1, 101); //1 ile 101 arasında rasgtele sayı üretir

                Toolstrore randomReward = new Toolstrore(player);
                System.out.println("Rastgele Bir Hediye Seçiliyor... [Silah : %15, Zırh : %15, Para : %25, Ödül Yol : %45]");
                if (rewardRate <= 15) {
                    randomReward.randomGiftWeapon();
                } else if (rewardRate <= 30) {
                    randomReward.randomGiftArmor();
                } else if (rewardRate <= 45) {

                    int randomMoney = rand.nextInt(100); // 0 ile 99 arasında bir sayı üretir

                    if (randomMoney < 50) { //%50 ihtimal => 1 Para
                        System.out.println("Tebrikler ! 1 Para Kazandınız !");
                    } else if (randomMoney < 80) { // %30 ihtimal => 5 Para
                        System.out.println("Tebrikler ! 5 Para Kazandınız !");
                    } else { // %20 ihtimal => 10 Para
                        System.out.println("Tebrikler ! 10 Para Kazandınız !");
                    }

                } else if (rewardRate <= 101) {
                    System.out.println("Maalesef ! Hiç Bir Ödül Kazanamadınız !");
                }

            }
            /////***********///////


        } else {
            return false;

        }
        return true;
    }


    //Maden haritasındaki ödül bloğuna girip girmemeye karar veren metod
    private static boolean isEnteredMiningMap = false;

    public static void setEnteredMiningMap(boolean value) {
        isEnteredMiningMap = value;   //gameClass'dan TRUE/FALSE geliyor
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
