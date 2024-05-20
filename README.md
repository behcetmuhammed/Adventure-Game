# Macera Oyunu

Bu proje, basit bir macera oyunu simülasyonunu Java programlama dili kullanarak oluşturulmuştur. Oyuncular, farklı
bölgelere seyahat edebilir, savaşabilir, silahlar satın alabilir ve daha fazlasını yapabilir. Proje metin tabanlıdır

## Nasıl Çalıştırılır

1. Java'nın bilgisayarınızda yüklü olduğundan emin olun.
2. Proje klasörüne gidin.
3. Terminal veya komut istemcisini açın.
4. `javac Main.java` komutunu kullanarak Java dosyalarını derleyin.
5. Derlenmiş dosyaları çalıştırmak için `java Main` komutunu kullanın.

## Oyun Akışı

- Oyuncu, oyunu başlattığında bir karakter seçer.

~~~~~~
        - Samurai
        - Okçu
        - Şovalye
~~~~~~

- Oyuncu, farklı bölgelere (güvenli ev, mağaza vb.) seyahat eder.
- Mağazaya gittiğinde, silah ve zırh satın alabilir.
- Savaş bölgelerinde düşmanlarla savaşır.

~~~~~~
        - Mağara
        - Orman
        - Nehir
        - Maden
~~~~~~

- Oyuncunun sağlık puanı sıfıra düştüğünde veya diğer belirli koşullar gerçekleştiğinde oyun sona erer.

## Dosya ve Sınıf Yapısı

- `Main.java`: Oyunun başlangıç noktası, `Game` sınıfını başlatır.
- `Archer.java`: Okçu karakterini tanımlandığı sınıf.
- `Armor.java`: Zırhların özelliklerini ve listesini tanımlar.
- `BattleLoc.java`: Savaş bölgelerinin özelliklerini belirtir.
- `Bear.java`: Ayı canavarının tanımlandığı sınıf.
- `Cave.java`: Mağara haritasının tanımlandığı sınıf.
- `Forest.java`: Orman canavarının tanımlandığı sınıf.
- `Game.java`: Oyun akışını yönetir ve farklı bölgelere seyahat etmeyi sağlar.
- `GameChar.java`: Oyun karakterlerinin temel sınıfını oluşturur.
- `Inventory.java`: Envanteri tutan sınıf.
- `Knight.java`: Şovalye karakterini tanımlandığı sınıf.
- `Location.java`: Farklı bölgelerin temel sınıfını oluşturur.
- `Mine.java`: Maden haritasının tanımlandığı sınıf.
- `NormalLoc.java`: Normal Map.
- `Obstacle.java`: Canavarlar sınıfı.
- `Player.java`: Oyuncu özelliklerini ve davranışlarını tanımlar.
- `River.java`: Nehir haritasının tanımlandığı sınıf.
- `SafeHouse.java`: Güvenli ev bölgesinin özelliklerini belirtir.
- `Samurai.java`, `Archer.java`, `Knight.java`: Farklı oyun karakterlerini temsil eder.
- `Snake.java`: Yılan canavarının tanımlandığı sınıf.
- `Toolstore.java`: Mağaza bölgesinin özelliklerini belirtir.
- `Vampire.java`: Vampir canavarının tanımlandığı sınıf.
- `Weapon.java`: Silahların özelliklerini ve listesini tanımlar.
- `Zombie.java`: Zombi canavarının tanımlandığı sınıf.

## Katkıda Bulunma

1. Fork yapın (https://github.com/behcetmuhammed/adventure-game/fork)
2. Özellik dalı oluşturun (`git checkout -b özellik/deneme`)
3. Değişikliklerinizi işleyin (`git commit -am 'Yeni özellik ekle'`)
4. Dalınıza itin (`git push origin özellik/deneme`)
5. Bir Birleştirme İsteği oluşturun

## Lisans

Bu proje `behcetmuhammed` tarafından hazırlanmıştır ve MIT lisansı altında lisanslanmıştır. Daha fazla bilgi
için `LICENSE` dosyasına bakın.
