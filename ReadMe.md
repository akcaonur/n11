Aşama 1 : Daha önce Selenium RC Server olarak bilinen Selenium'un resmi web sitesinden Selenium Server jar dosyasını indirin ve yerel diskteki herhangi bir yere kaydedin.

Selenium HQ URL'si: http://www.seleniumhq.org/download/

Adım 2 : Komut istemini açın ve sunucunun bulunduğu klasöre gidin. Aşağıdaki komutu kullanarak sunucuyu çalıştırın

java -jar selenyum-sunucu-bağımsız-2.41.0.jar -role hub

Hub varsayılan olarak 4444 numaralı bağlantı noktasını kullanacaktır. Bu bağlantı noktası, bağlantı noktasının açık olması ve bir görev atanmamış olması koşuluyla, komut isteminde farklı bağlantı noktası numarası geçirilerek değiştirilebilir.

Durum, web arayüzü kullanılarak kontrol edilebilir: http: // localhost: 4444 / grid / console

Aşama 3 : Düğümleri kurmayı düşündüğünüz diğer makineye gidin. Komut istemini açın ve aşağıdaki satırı çalıştırın.

java -jar selenium-server-standalone-2.41.0.jar -role node -hub http://localhost:4444/grid/register -port 5556
Düğümleri başlatmak için selenyum sunucusunu diğer makinelerde çalıştırın.