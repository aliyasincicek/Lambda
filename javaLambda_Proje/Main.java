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
	    
	    
	    
	    //��rencileri cinsiyetlerine g�re yazd�ran
	    //listeyi yazd�r�rken i�inde veri var m� diye kontrol edin
	    //reduce metoduyla ortalama hesaplayin
	    // Girilen ogrenci ismini sil
	    //Test ama�l� ��renci nesneleri olu�turun.
		
		testOgrenciOlustur();
		notaGoreSirala(3,6);
		yasaGoreSirala();
		yasaVeCinsiyeteGoreSirala(20, "erkek"); // 20 ya��ndann kucuk erkekleri getirir
		yasaVeCinsiyeteGoreSirala(30, "kad�n"); // 30 yasindan kucuk kad�nlari getirir
		ismeGoreListele("Ahmet");
		soyIsmeGoreListele("Can");
		cinsiyeteGoreListele("erkek");
		System.out.println(ortalamaHesaplama1());
		System.out.println();
		System.out.println(ortalamaHesaplama2());
		System.out.println();
		ortalamaHesaplama3();
		ismeGoreOgrcSil("Ay�e"); // Ay�e  isimli ogrenci silindi
		
		
	}
	//Test ama�l� ��renci nesneleri olu�turur.
    private static void testOgrenciOlustur() {
        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ay�e", "Can", 21, 82.3, "kad�n"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ay�e", "Y�lmaz", 40, 45, "kad�n"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "�zt�rk", 20, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Selim", "Ya�", 21, 95.5, "erkek"));
    }

  //��renci notlar�n� alt ve �st limitlere g�re s�ralayarak  yazd�ran metot (�nr: 3-6. s�radakileri g�ster.)
    private static void notaGoreSirala(int alt, int ust) {
    	
    	System.out.println("\n============ NOTA G�RE SIRALAMA ============");
        System.out.println("----- " + alt + "-" + ust + ". siradakileri goster ----");
        ogrListesi.stream().
        sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed()).
        skip(alt - 1). // alt=3.. 3-1=2 ilk 2'yi atlad�k
        limit(ust - alt + 1). // ust=6.. 6-3+1=4 ilk 2 yi atlad�ktan sonta ki ilk 4 � ald�k
       forEach(System.out::println); 
    }
    
    //��rencileri ya�lar�na g�re s�ralayark yazd�rin
    public static void yasaGoreSirala(){
    	System.out.println("\n============ YASA G�RE SIRALAMA ============");
       
    	 ogrListesi.stream().
    	 sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
    	 forEach(System.out::println);
    }
  //��rencileri belirli bir ya�a ve cinsiyete g�re s�ralayarak listeleyin
    private static void yasaVeCinsiyeteGoreSirala(int yas, String cinsiyet){
        System.out.println("\n============ YAS VE C�NS�YETE G�RE SIRALA-L�STELE ============");
        ogrListesi.stream().
        filter(t->t.getYas()<yas).
        filter(t-> t.getCinsiyet().equals(cinsiyet)).
        sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
        forEach(System.out::println);
    }
  //��rencileri isimlerine g�re yazd�r�n
    private static void ismeGoreListele(String isim){
    	 System.out.println("\n============ "+ isim.toUpperCase() + " ADINDAK� ��RENC�LER ============");
    	 List<Ogrenci> liste=  ogrListesi.stream().filter(t->t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList());
    	 listeYazdir(liste);
    }
     private static void listeYazdir(List<Ogrenci> liste) {
	
	if ((liste.isEmpty())) {
        System.out.print("Aran�lan ��renci Bulunamad�");
    } else {
        liste.forEach(System.out::println);
    }
	
}
//��rencileri soyisimlerine g�re yazd�r

    private static void soyIsmeGoreListele(String soyIsim){
    System.out.println("\n============ "+ soyIsim.toUpperCase() + " SOYADINDAK� ��RENC�LER ============");
    List<Ogrenci> liste =ogrListesi.stream().filter(t->t.getSoyAd().equalsIgnoreCase(soyIsim)).collect(Collectors.toList());
    listeYazdir(liste);
    }
    //��rencileri cinsiyetlerine g�re yazd�ran metot.
    private static void cinsiyeteGoreListele(String cinsiyet){
        System.out.println("\n============ "+ cinsiyet.toUpperCase() + " ===============");
        List<Ogrenci> liste =ogrListesi.stream().filter(t->t.getCinsiyet().equalsIgnoreCase(cinsiyet)).collect(Collectors.toList());
        listeYazdir(liste);
    }
  //reduce metoduyla ortalama hesaplama y�ntemi
    private static double ortalamaHesaplama1(){
    	double toplam= ogrListesi.stream().map(t->t.getDiplomaNotu()).reduce(0.0, Double::sum);
    	 return toplam/ ogrListesi.size();
    }
    private static double ortalamaHesaplama2(){
    	return ogrListesi.stream().mapToDouble(t->t.getDiplomaNotu()).average().orElse(Double.NaN);
    }
    private static void ortalamaHesaplama3(){
    	DoubleSummaryStatistics istatistik = ogrListesi. // DoubleSummaryStatistics Say�, min, maks, toplam ve ortalama gibi 
                stream().//istatistikleri toplamak i�in bir durum nesnesi.Bu s�n�f, (gerekli olmasa da) streamlerle �al��mak �zere tasarlanm��t�r.
                mapToDouble(Ogrenci::getDiplomaNotu).
                summaryStatistics();
        System.out.println("========= SINIF D�PLOMA NOT �STAT�ST�KLER� ===========");
        System.out.println("SINIF ORTALAMASI:"+ istatistik.getAverage()); // SINIF ORTALAMASI:76.85
        System.out.println("K��� SAYISI:"+ istatistik.getCount());// K��� SAYISI:8
        System.out.println("MAKS ORTALAMA:"+ istatistik.getMax());// MAKS ORTALAMA:95.5
        System.out.println("M�N ORTALAMA:"+ istatistik.getMin());// M�N ORTALAMA:35.5
    }
    //    // Bir Collection'daki veriler stream'e �evirmeksizin removeIf() metoduyla silinebilir.
//    // removeIf bir lambda fonksiyonunu parametre olarak alabilir.
//    // removeIf bir ArrayList metodudur ve listeyi kal�c� olarak g�nceler.
    public static void ismeGoreOgrcSil(String isim){
    	boolean silindiMi=ogrListesi.removeIf(t->t.getAd().contains(isim));
    	if (silindiMi==true) {
    		System.out.println(isim+ "  isimli ogrenci silindi");
			
		} else {
			System.out.println(isim + "  isimli ogrenciler silinemedi");

		}
    }
    
    
    
    
    
    
    
    
}
