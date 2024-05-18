package AdventurGame;

//Alet deposu
public class Toolstrore extends NormalLoc {

    public Toolstrore(Player player) {
        super("Mağaza", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("####   Mağazaya Hoşgeldiniz!   ####");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silah Satın Al");
            System.out.println("2- Zırh Satın Al");
            System.out.println("3- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectItem = input.nextInt();
            while (selectItem < 1 || selectItem > 3) {
                System.out.print("Geçersiz İşlem. Lütfen Yeniden Seçiniz: ");
                selectItem = input.nextInt();
            }
            switch (selectItem) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                default:
                    System.out.println("Mağazadan Çıkış Yapılıyor...");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("***********   SİLAHLAR   ***********");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "- " + w.getName() + " < Para: " + w.getPrice() + ", Hasar: " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.print("Geçersiz İşlem. Lütfen Yeniden Seçiniz: ");
            selectWeaponId = input.nextInt();
        }

        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("OOPS! Paran Yok Adamım");
                } else {
                    //Satın alma işlemi...
                    System.out.println(selectedWeapon.getName() + " Silahı Satın Alındı");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız: " + getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }


    public void printArmor() {
        System.out.println("***********   ZIRHLAR   ***********");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "- " + a.getName() + " < Para: " + a.getPrice() + ", Zırh Gücü: " + a.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }


    public void buyArmor() {
        System.out.print("Bir Zırh Seçiniz: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.print("Geçersiz İşlem. Lütfen Yeniden Seçiniz: ");
            selectArmorId = input.nextInt();
        }

        if (selectArmorId != 0) {

            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("OOPS! Paran Yok Adamım");
                } else {
                    //Satın alma işlemi...
                    System.out.println(selectedArmor.getName() + " Zırhı Satın Alındı");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Zırhın: " + getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhın: " + getPlayer().getInventory().getArmor().getName());
                }
            }
        }
    }

}
