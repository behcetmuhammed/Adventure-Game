package AdventurGame;

import java.util.Scanner;

public class Game {


    public static String addSpaces(String message) {
        StringBuilder spacedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            spacedMessage.append(currentChar);
            if (currentChar != ' ' && i != message.length() - 1) {
                spacedMessage.append(' ');
            }
            if (currentChar == ' ' && i != message.length() - 1) {
                spacedMessage.append(' ');
            }
        }
        return spacedMessage.toString();
    }


    public void start() {
        Scanner input = new Scanner(System.in);
        String welcomeMessage = "------------------------\nMACERA OYUNUNA HOŞGELDİN\n------------------------";
        System.out.println(addSpaces(welcomeMessage));

        System.out.print("Oyuncu Adını Gir: ");
        String playerGame = input.next();

        Player player = new Player(playerGame);
        System.out.println("\n" + player.getName() + "! Çok Dikkatli Olman Gerek! Hadi Git ve Onlara Kim Olduğunu Göster!");
        //Player player = new Player(playerName);
        player.selectChar();

        Location location = null;

        while (true) {
            player.printInfoPlayer();
            System.out.println("---------------------------------------------------------------------------------------------\n\n######## Bölgeler ########");
            System.out.println();
            System.out.println("1- Güvenli Ev     -->  Güvenlli Ev'de Duşman Yoktur ve Canınızı Yenilenir");
            System.out.println("2- Mağaza         -->  Mağaza'dan Silah ve Zırh Satın Alabilirsin");
            System.out.println();
            System.out.println("3- Mağara         -->  <YEMEK> Kazanmak İçin Mağaraya Gir. Dikkatli Ol! Mağarada Vahşi Zombiler Dolaşıyor");
            System.out.println("4- Orman          -->  <ODUN> Kazanmak İçin Orman'a Gir. Dikkatli Ol! Orman'da Kan Emici Vampirler Yaşıyor");
            System.out.println("5- Nehir          -->  <SU> Kazanmak İçin Nehir'e Gir. Dikkatli Ol! Nehir'de Aç Ayılar Dolaşıyor");
            System.out.println();
            System.out.println("0- Çıkış Yap      -->  Oyunu Sonlandır.");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçin: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Toolstrore(player);
                    break;
                case 3:
                    if (!player.getInventory().hasAward("Yemek")) {
                        location = new Cave(player);
                        break;
                    }
                    System.out.println("Daha Önce Buradaki Duşmanları Yendin. Tekrar Giremezsin!");
                    continue;
                case 4:
                    if (!player.getInventory().hasAward("Su")) {
                        location = new Forest(player);
                        break;
                    }
                    System.out.println("Daha Önce Buradaki Duşmanları Yendin. Tekrar Giremezsin!");
                    continue;

                case 5:
                    if (!player.getInventory().hasAward("Odun")) {
                        location = new River(player);
                        break;
                    }
                    System.out.println("Daha Önce Buradaki Duşmanları Yendin. Tekrar Giremezsin!");
                    continue;
                default:
                    System.out.println("Yanlış Seçim. Varsayılan Olarak Güvenli Ev'e Gidiyorsunuz!");
                    location = new SafeHouse(player); //daha sonra burayı düzelt
                    //Continue ekle ??
            }

            if (location == null) {
                System.out.println("Oyun Sonlandırılıyor...");
                break;
            }

            if (!location.onLocation()) {
                if (player.getHealth() <= 0) {
                    System.out.println("Game Over!");
                }
                break;
            }

        }

    }
}
