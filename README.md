AndroGarbage
------------

Bütün çöp kodlarımı topladığım bir depo.
Tamamen öğrenmek için olan örnekleri içeriyor.


İçeridekiler
------------

* [HelloWorld](https://github.com/Zaryob/AndroGarbage/tree/master/Helloworld) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/Helloworld.apk): Süleyman Stili bir Merhaba Dünya çağrısı
* [FrameLayoutTest](https://github.com/Zaryob/AndroGarbage/tree/master/FrameLayoutTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/FrameLayoutTest.apk): Bunun amaci ana çervenin rengini ve çerçeve içerisinde yer alan verilerin tıklamaya bağlı olarak değiştrilmesini sağlan bir kod dökümüdür. Bu programla tıklama (onClickListener) için bir örnek oluşturulmuştur.
* [LinearLayoutTest](https://github.com/Zaryob/AndroGarbage/tree/master/LinearLayoutTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/LinearLayoutTest.apk): LinearLayout formunun horizontal ve vertical formlarda button objelerinin listelenmesi ve buttonların listenlerinin dinlenmesine ait örnek uygulama
* [ImageViewTest](https://github.com/Zaryob/AndroGarbage/tree/master/ImageViewTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/ImageViewTest.apk): ImageView formunun butona bağlanıp değiştirilmesinin amaçlayan uygulama. Yavaş yavaş listener bağlamaları anladım sanırım.
* [ToastMakerTest](https://github.com/Zaryob/AndroGarbage/tree/master/ToastMakerTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/ToastMakerTest.apk): Toast olarak adlandırılan bildirim baloncuklarını kullanmakla alakalı uygulama örneklerini içerir. 3 tane toast ard arda gelmektedir. İlk toast bildirimi öntanımlı pozisyon ve görünüm ile yapılmıştır. İkincisi öntanımlı bildirimi pozisyonu değiştirilmiş halidir. Sonuncu ise hem pozisyonu hem de görünümü değiştirilmiş custom bildirimdir.
* [TextViewTest](https://github.com/Zaryob/AndroGarbage/tree/master/TextViewTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/TextViewTest.apk): TextView formunun butona bağlanıp değiştirilmesinin amaçlayan uygulama. Dokununca Toast oluşturuyor ve görünür text değiştiriliyor.
* [ButtonTest](https://github.com/Zaryob/AndroGarbage/tree/master/ButtonTest) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/ButtonTest.apk): Bu uygulama ile Buttona basılmaya bağlı olarak belirli bir web sitesine girmeyi sağlayan bir uygulama yazıldı. Intent objesinin kullanımı için basit bir örnek niteliğinde.
* [IntentExample](https://github.com/Zaryob/AndroGarbage/tree/master/IntentExample) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/IntentExample.apk): Bu uygulama ile Intent veri tipinin url ile kullanılmasını sağlayan bir application yazdım. Basitce anlatmak gerekirse bir EditText kısmı var ve bu EditText objesinin (kullanımı TextView ile çok yakın bir objedir) içerisine girilen url'yi alıp o sayfayı açmak için tarayıcılara yönlendirme yapıyor. Buradaki tek sıkıntı ise hata oluşması anında uygulamanın çökmesi idi. Intent objesi eğer belirtilen türe uygun bir path bulamazsa (mesela url verisi için https:// ile başlaya link) uygulama çakılıyordu. Bir try catch ve toast eklemesi ile bu sıkıntı tatlıya bağlandı :joy:
* [SimpleTimer](https://github.com/Zaryob/AndroGarbage/tree/master/SimpleTimer) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/SimpleTimer.apk): SimpleTimer uygulaması içerisinde geri sayım için bir uygulamadır. countdowntimer sınıfından türetilmiş bir timer içeriyor. Uri sınıfını kullanarak zamanın bitmesine mütakip notification sound da çaldırmayı bu uygulama ile öğrenebilirsiniz.
* [TipCalculator](https://github.com/Zaryob/AndroGarbage/tree/master/TipCalculator) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/SimpleTimer.apk): Biraz Komplex bir hesaplama uygulaması içerisinde aşağıdaki stiller kullanılmaktadır.
	* TableLayout:  View layoutunun Tablo şeklindeki layout formudur
	* TableRow: TableLayout içerisinde satır belirler
	* EditText: View layoutuna Text girilmesi için bir altyapı.
	* RadioGroup: RadioButton için kullanılan group yapısı.
	* RadioButton: RadioButton uzun bir çubuk boyunca seçili noktanın hareketine bağlı olarak değer atanmasını sağlar.
Uygulamanın amacı bir restoranta gidenlerin hesap bölüşmesi için kolay bir uygulama oluşturmaktır.
* [DonunaKadar](ihttps://github.com/Zaryob/AndroGarbage/tree/master/TipCalculator) [apk](https://github.com/Zaryob/AndroGarbage/releases/download/apklar/DonunaKadar.apk): DonunaKadar uygulaması sayesinde permission granted yaparak her türlü izini alır izin aldığınız kişinin donuna kadar almanızı sağlar.



Notlar
------

## Bir Öğrenicinin Yaşadığı Sık Rastlanılan Hatalar

* error running app: default activity not found hatası: Çözümü aslında basit. Şu [linkte](https://stackoverflow.com/a/15825326) anlatılmış. Ana fikri ise AndroidManifest dosyasında application tagı içeriğini doldurmakla alakalı
