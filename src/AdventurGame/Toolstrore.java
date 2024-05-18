package AdventurGame;

//Alet deposu
public class Toolstrore extends NormalLoc {

    public Toolstrore(Player player) {
        super("Mağaza", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("####   Mağazaya Hoşgeldiniz!   ####");
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
                buyWeapon();
                break;
            default:
                System.out.println("Mağazadan Çıkış Yapılıyor...");
                return true;
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("***********   SİLAHLAR   ***********");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "- " + w.getName() + " < Para: " + w.getPrice() + ", Hasar: " + w.getDamage() + " >");
        }
    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length) {
            System.out.print("Geçersiz İşlem. Lütfen Yeniden Seçiniz: ");
            selectWeaponId = input.nextInt();
        }

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

    public void printArmor() {
        System.out.println("***********   ZIRHLAR   ***********");
        System.out.println();
        for (Armur a : Armur.armurs()) {
            System.out.println(a.getId() + "- " + a.getName() + " < Para: " + a.getPrice() + ", Hasar: " + a.getBlock() + " >");
        }
    }

}
