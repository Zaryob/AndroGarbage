AndroGarbage
------------

Bütün çöp kodlarımı topladığım bir depo.
Tamamen öğrenmek için olan örnekleri içeriyor.


İçeridekiler
------------

* [HelloWorld](https://github.com/Zaryob/AndroGarbage/tree/master/Helloworld): Süleyman Stili bir Merhaba Dünya çağrısı
* [FrameLayoutTest](https://github.com/Zaryob/AndroGarbage/tree/master/FrameLayoutTest): Bunun amaci ana çervenin rengini ve çerçeve içerisinde yer alan verilerin tıklamaya bağlı olarak değiştrilmesini sağlan bir kod dökümüdür. Bu programla tıklama (onClickListener) için bir örnek oluşturulmuştur.
* [LinearLayoutTest](https://github.com/Zaryob/AndroGarbage/tree/master/LinearLayoutTest): LinearLayout formunun horizontal ve vertical formlarda button objelerinin listelenmesi ve buttonların listenlerinin dinlenmesine ait örnek uygulama
* [ImageViewTest](https://github.com/Zaryob/AndroGarbage/tree/master/ImageViewTest): ImageView formunun butona bağlanıp değiştirilmesinin amaçlayan uygulama. Yavaş yavaş listener bağlamaları anladım sanırım.
* [ToastMakerTest](https://github.com/Zaryob/AndroGarbage/tree/master/ToastMakerTest): Toast olarak adlandırılan bildirim baloncuklarını kullanmakla alakalı uygulama örneklerini içerir. 3 tane toast ard arda gelmektedir. İlk toast bildirimi öntanımlı pozisyon ve görünüm ile yapılmıştır. İkincisi öntanımlı bildirimi pozisyonu değiştirilmiş halidir. Sonuncu ise hem pozisyonu hem de görünümü değiştirilmiş custom bildirimdir.
* [TextViewTest](https://github.com/Zaryob/AndroGarbage/tree/master/TextViewTest): TextView formunun butona bağlanıp değiştirilmesinin amaçlayan uygulama. Dokununca Toast oluşturuyor ve görünür text değiştiriliyor.
* [ButtonTest](https://github.com/Zaryob/AndroGarbage/tree/master/ButtonTest): Bu uygulama ile Buttona basılmaya bağlı olarak belirli bir web sitesine girmeyi sağlayan bir uygulama yazıldı. Intent objesinin kullanımı için basit bir örnek niteliğinde.

Notlar
------

## Bir Öğrenicinin Yaşadığı Sık Rastlanılan Hatalar

* error running app: default activity not found hatası: Çözümü aslında basit. Şu [linkte](https://stackoverflow.com/a/15825326) anlatılmış. Ana fikri ise AndroidManifest dosyasında application tagı içeriğini doldurmakla alakalı
