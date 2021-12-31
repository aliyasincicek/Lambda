package javaLambda_HlkHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

	public static void main(String[] args) {
		List<String>list=new ArrayList<>(Arrays.asList("mehmet", "kokorec", "nilgun", "yildiz", "kader",
                "emine", "islam", "islam", "emre"));
		bykHrfTekrarsizSira(list); //EMRE EMÝNE KADER MEHMET NÝLGUN YÝLDÝZ ÝSLAM 
		System.out.println();
		karakterSayisiTekrarsizTersSirali(list);//6 5 4 
		System.out.println();
		karakterSayisiSiraliEl(list);//emre emre kader emine islam islam mehmet nilgun yildiz 
		System.out.println();
		sonHarfTersSiraliEl(list);// yildiz mehmet kader nilgun islam islam emre emine emre 
		System.out.println();
		ciftKareTekrarsizTersSira(list); //36 16 
		System.out.println();
		harfSayisi7Kontrol(list); // list elemanlari 7 harfden buyuk degil
		System.out.println();
		wBaslamaKontrol(list); // w ile baslayan isim kimse ayaga kalksin
		System.out.println();
		xbitmeKontrol(list); // AGAM x ile biten isim oluuuurrr 
		System.out.println();
		karakteriEnBuyukEl(list);// Optional[kokorec]
		System.out.println();
		karakteriEnBuyukEl2(list);// [kokorec]
		System.out.println();
		ilkElemanHarisSonHarfSirali(list); // emine emre islam islam nilgun kader mehmet yildiz 

	}
	
	//List elemanlarini alafabetik buyuk harf ve  tekrarsiz yazdiriniz
    public static void bykHrfTekrarsizSira(List<String> list) {
    	list.stream().// akýþa girdi
        //map(String::toUpperCase)
    	map(t->t.toUpperCase()).// elemanlar buyuk harf oldu
    	sorted().//alfabetik sira
    	distinct().//tekrarsiz  yapildi....cooook onmeli ahanda TRICk....
    	//forEach(System.out::println);
    	forEach(t->System.out.print(t+" "));
    }
  
    //list elelmanlarinin character sayisini ters sirali olarak tekrarsiz yazdiriniz
    public static void karakterSayisiTekrarsizTersSirali(List<String> list) {
    	list.stream().map(t->t.length()).// String data character sayisina update edild
    	sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);
    }
  
    //List elemanlarini character sayisina gore kckten byk e gore yazdiriniz.
    public static void karakterSayisiSiraliEl(List<String> list) {
        list.stream().
        sorted(Comparator.comparing(t->t.toString().length())).// Comparator classýndan karþýlaþtýrma yapýldý
        forEach(t -> System.out.print(t + " "));
    
    }  
 
    //list elemanlarinin son harfine gore ters sirali yazdiriniz
    public static void sonHarfTersSiraliEl(List<String> list) {
    	list.stream().sorted(Comparator.comparing(t -> t.toString().
                        charAt(t.toString().length() - 1)).//elemanin length()-1)-->son inedx'inin karakterini alir
                        reversed()).//elemanin length()-1)-->son inedx'inin karakterini ters siralar z->a
        forEach(t -> System.out.print(t + " "));
}
    
    // //listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve 
    //karelerini tekrarsiz buyukten kucuge sirali  yaziniz.
    public static void ciftKareTekrarsizTersSira(List<String> list) {
    	list.stream().map(t->t.length()*t.length()).filter(Lambda01::ciftBul).
   //filter(t->t.length()%2==0) 	
    	distinct().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t + " "));
    }
    
    //List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz
    public static void harfSayisi7Kontrol(List<String> list) {
    	// boolean  kontrol=  list.stream().
        //     allMatch(t->t.length()<=7);//her bir elemaný harf syisini <=7 ye eslesmesine bakti
     //    if (kontrol ) {
     //        System.out.println("list elemanlari 7 harfden buyuk degil");
 //
     //    }else{
     //        System.out.println("AGAM list elemanlari 7 harfden BUYUK ");
     //    }
    	//   allMatch her bir elemaný eþleþtir. java risk görmediði için optional üretmedi.
         //System.out.println(kontrol);
         System.out.println(list.stream().allMatch(t -> t.length() <= 7)?"list elemanlari 7 harfden buyuk degil":"AGAM list elemanlari 7 harfden BUYUK ");
    }
  //List elelmanlarinin "W" ile baslamasýný kontrol ediniz
    public static void wBaslamaKontrol(List<String> list){
    	  System.out.println(list.
                  stream().
                  noneMatch(t -> t.startsWith("w"))?"w ile baslayan isim kimse ayaga kalksin":"AGAM w ile baslayan isim oluuuurrr ");
    	  // noneMatch hiç eþleþmez.
    	  // allMatch hep eþleþir
    }
    //List elelmanlarinin "x" ile biten en az bir elemaý kontrol ediniz
    
    public static void xbitmeKontrol(List<String> list){
        System.out.println(list.
                stream().
                anyMatch(t -> t.endsWith("x"))?"x ile biten isim kimse ayaga kalksin":"AGAM x ile biten isim oluuuurrr ");
//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    }
    
  //Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakteriEnBuyukEl(List<String> list){
        System.out.println(list.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
                        reversed()).//ters sirlad b->k
                findFirst());//ilk elelmani aldi
    
}
    public static void karakteriEnBuyukEl2(List<String> list) {
    	
    	
    	Stream<String> sonIsim=list.stream().
    	sorted(Comparator.comparing(t->t.toString().length()).//lenght karakter uzunluguna gore siraladi k->b
    			reversed()).//ters sirlad buyukten kucuge. dogal sýra kucuk->buyuk
    	limit(1); //limit(a) akýsdan cýkan elemanlarý a parametresine gore ilk a elamaný alýr
    	System.out.println(Arrays.toString(sonIsim.toArray())); // sonisimi önce array e cevirdik. sonra stringe cevirip yazdýrdýk
    															// tolist e de cevirip yazdýrabiliridk
    }

    //list elemanlarini son harfine göre siralayýp ilk eleman hariç kalan elemanlari yazdiriniz
    
    public static void ilkElemanHarisSonHarfSirali (List<String> list) {
    	list.stream().
    	sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1))).
    	skip(1).//akýstan cikaln elelmanlarin 1. parametreyi atlar
    	forEach(t->System.out.print(t+" "));
    }





















}


