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

        //System.out.print("Oyuncu Adını Gir: ");
        //String playerGame = input.next();

        Player player = new Player("Emir");
        System.out.println("\n" + player.getName() + "! Çok Dikkatli Olman Gerek! Hadi Git ve Onlara Kim Olduğunu Göster!");
        //Player player = new Player(playerName);
        player.selectChar();

        Location location = null;

        while (true) {
            System.out.println("---------------------------------------------------------------------------------------------\n\n######## Bölgeler ########");
            System.out.println();
            System.out.println("1- Güvenli Ev  -->  Güvenlli Ev'de Duşman Yoktur ve Canınızı Yenilenir");
            System.out.println("2- Mağaza      -->  Mağaza'dan Silah ve Zırh Satın Alabilirsin");
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçin: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Toolstrore(player);
                    break;
                default:
                    System.out.println("Yanlış Seçim. Varsayılan Olarak Güvenli Ev'e Gidiyorsunuz!");
                    location = new SafeHouse(player); //daha sonra burayı düzelt
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
            }
        }

    }
}
