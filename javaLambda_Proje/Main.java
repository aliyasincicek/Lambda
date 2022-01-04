package javaLambda_Proje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Main {
	 
	
	public static List<Ogrenci> ogrListesi = new ArrayList<>();

	public static void main(String[] args) {
	    
	    
	    
	    //Öðrencileri cinsiyetlerine göre yazdýran
	    //listeyi yazdýrýrken içinde veri var mý diye kontrol edin
	    //reduce metoduyla ortalama hesaplayin
	    // Girilen ogrenci ismini sil
	    //Test amaçlý Öðrenci nesneleri oluþturun.
		
		testOgrenciOlustur();
		notaGoreSirala(3,6);
		yasaGoreSirala();
		yasaVeCinsiyeteGoreSirala(20, "erkek"); // 20 yaþýndann kucuk erkekleri getirir
		yasaVeCinsiyeteGoreSirala(30, "kadýn"); // 30 yasindan kucuk kadýnlari getirir
		ismeGoreListele("Ahmet");
		soyIsmeGoreListele("Can");
		cinsiyeteGoreListele("erkek");
		System.out.println(ortalamaHesaplama1());
		System.out.println();
		System.out.println(ortalamaHesaplama2());
		System.out.println();
		ortalamaHesaplama3();
		ismeGoreOgrcSil("Ayþe"); // Ayþe  isimli ogrenci silindi
		
		
	}
	//Test amaçlý Öðrenci nesneleri oluþturur.
    private static void testOgrenciOlustur() {
        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayþe", "Can", 21, 82.3, "kadýn"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayþe", "Yýlmaz", 40, 45, "kadýn"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Öztürk", 20, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Selim", "Yaþ", 21, 95.5, "erkek"));
    }

  //Öðrenci notlarýný alt ve üst limitlere göre sýralayarak  yazdýran metot (Önr: 3-6. sýradakileri göster.)
    private static void notaGoreSirala(int alt, int ust) {
    	
    	System.out.println("\n============ NOTA GÖRE SIRALAMA ============");
        System.out.println("----- " + alt + "-" + ust + ". siradakileri goster ----");
        ogrListesi.stream().
        sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
        skip(alt - 1). // alt=3.. 3-1=2 ilk 2'yi atladýk
        limit(ust - alt + 1). // ust=6.. 6-3+1=4 ilk 2 yi atladýktan sonta ki ilk 4 ü aldýk
       forEach(System.out::println); 
    }
    
    //Öðrencileri yaþlarýna göre sýralayark yazdýrin
    public static void yasaGoreSirala(){
    	System.out.println("\n============ YASA GÖRE SIRALAMA ============");
       
    	 ogrListesi.stream().
    	 sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
    	 forEach(System.out::println);
    }
  //Öðrencileri belirli bir yaþa ve cinsiyete göre sýralayarak listeleyin
    private static void yasaVeCinsiyeteGoreSirala(int yas, String cinsiyet){
        System.out.println("\n============ YAS VE CÝNSÝYETE GÖRE SIRALA-LÝSTELE ============");
        ogrListesi.stream().
        filter(t->t.getYas()<yas).
        filter(t-> t.getCinsiyet().equals(cinsiyet)).
        sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
        forEach(System.out::println);
    }
  //Öðrencileri isimlerine göre yazdýrýn
    private static void ismeGoreListele(String isim){
    	 System.out.println("\n============ "+ isim.toUpperCase() + " ADINDAKÝ ÖÐRENCÝLER ============");
    	 List<Ogrenci> liste=  ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList());
    	 listeYazdir(liste);
    }
     private static void listeYazdir(List<Ogrenci> liste) {
	
	if ((liste.isEmpty())) {
        System.out.print("Aranýlan Öðrenci Bulunamadý");
    } else {
        liste.forEach(System.out::println);
    }
	
}
//Öðrencileri soyisimlerine göre yazdýr

    private static void soyIsmeGoreListele(String soyIsim){
    System.out.println("\n============ "+ soyIsim.toUpperCase() + " SOYADINDAKÝ ÖÐRENCÝLER ============");
    List<Ogrenci> liste =ogrListesi.stream().filter(t->t.getSoyAd().equalsIgnoreCase(soyIsim)).collect(Collectors.toList());
    listeYazdir(liste);
    }
    //Öðrencileri cinsiyetlerine göre yazdýran metot.
    private static void cinsiyeteGoreListele(String cinsiyet){
        System.out.println("\n============ "+ cinsiyet.toUpperCase() + " ===============");
        List<Ogrenci> liste =ogrListesi.stream().filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).collect(Collectors.toList());
        listeYazdir(liste);
    }
  //reduce metoduyla ortalama hesaplama yöntemi
    private static double ortalamaHesaplama1(){
    	double toplam= ogrListesi.stream().map(t->t.getDiplomaNotu()).reduce(0.0, Double::sum);
    	 return toplam/ ogrListesi.size();
    }
    private static double ortalamaHesaplama2(){
    	return ogrListesi.stream().mapToDouble(t->t.getDiplomaNotu()).average().orElse(Double.NaN);
    }
    private static void ortalamaHesaplama3(){
    	DoubleSummaryStatistics istatistik = ogrListesi. // DoubleSummaryStatistics Sayý, min, maks, toplam ve ortalama gibi 
                stream().//istatistikleri toplamak için bir durum nesnesi.Bu sýnýf, (gerekli olmasa da) streamlerle çalýþmak üzere tasarlanmýþtýr.
                mapToDouble(Ogrenci::getDiplomaNotu).
                summaryStatistics();
        System.out.println("========= SINIF DÝPLOMA NOT ÝSTATÝSTÝKLERÝ ===========");
        System.out.println("SINIF ORTALAMASI:"+ istatistik.getAverage()); // SINIF ORTALAMASI:76.85
        System.out.println("KÝÞÝ SAYISI:"+ istatistik.getCount());// KÝÞÝ SAYISI:8
        System.out.println("MAKS ORTALAMA:"+ istatistik.getMax());// MAKS ORTALAMA:95.5
        System.out.println("MÝN ORTALAMA:"+ istatistik.getMin());// MÝN ORTALAMA:35.5
    }
    //    // Bir Collection'daki veriler stream'e çevirmeksizin removeIf() metoduyla silinebilir.
//    // removeIf bir lambda fonksiyonunu parametre olarak alabilir.
//    // removeIf bir ArrayList metodudur ve listeyi kalýcý olarak günceler.
    public static void ismeGoreOgrcSil(String isim){
    	boolean silindiMi=ogrListesi.removeIf(t->t.getAd().contains(isim));
    	if (silindiMi==true) {
    		System.out.println(isim+ "  isimli ogrenci silindi");
			
		} else {
			System.out.println(isim + "  isimli ogrenciler silinemedi");

		}
    }
    
    
    
    
    
    
    
    
}
