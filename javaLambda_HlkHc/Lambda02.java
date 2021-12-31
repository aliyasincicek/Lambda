package javaLambda_HlkHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
		 System.out.println();
	     System.out.println("   ***   ");
		toplaEl1(list);
		 System.out.println();
	     System.out.println("   ***   ");
		toplaEl2(list);
		 System.out.println();
	     System.out.println("   ***   ");
		carpCiftEl1(list);
		 System.out.println();
	     System.out.println("   ***   ");
	     carpCiftEl2(list);
	     System.out.println();
	     System.out.println("   ***   ");
	     min1(list);
	     min2(list);
	     min3(list);
	     min4(list); 
	     System.out.println();
	     System.out.println("   ***   ");
	     onbestenBykKckTekSayi(list) ; //Optional[65]
	     System.out.println();
	     System.out.println("   ***   ");
	     ciftKareKckByg(list); //144 484 1156 1764 3600 
	     System.out.println();
	     System.out.println("   ***   ");
	     tekKareBygKck(list); // 4225 225 49 9 9 
 
	}
	 //list'in tek  elemanlarinin kareleri ni buykten kucuge  yazdiriniz
	public static void tekKareBygKck(List<Integer> list){
		list.stream().
		filter(t->t%2!=0).
		map(t->t*t).
		sorted(Comparator.reverseOrder()).//Comparator(karsilaþtirma) classýndan reverse order metodunu kulllandýk. akýsa giren elelmanlar ters siralanir
		forEach(Lambda01::printEl); 
	}
	
	//  //list'in cift  elemanlarinin kareleri ni  kucukten buyuge yazdiriniz
	
	public static void ciftKareKckByg(List<Integer> list) {
		list.
		stream().
		filter(Lambda01::ciftBul).
		map(t->t*t).
		sorted(). //akýsa giren elelmanlar naturel order'e gore siralanir
		forEach(Lambda01::printEl);
		
		
	}
	
	  //List'teki 15'ten buyuk en kucvuk tek sayiyi yazdiriniz
	
	 public static void onbestenBykKckTekSayi(List<Integer> list) {
		System.out.println(list.
				stream().// akiþa girdi
				filter(t->t%2==1).filter(t->t>15).//þart saglandý
				reduce(Integer::min)); //min deger reduce eildi
		//Optional[65] optional hata ihtimalini ortadan kaldýrýr. 
		// cunku benim listimde 15 ten buyuk baska bir tek sayi yok
		 //  list.stream().filter(t->t%2==1 & t>15).reduce(Integer::min); bu þekilde de olur
	 
	 }
	
	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
    //4. yontem Method Reference -->  //Lambda expression...
	public static void min4(List<Integer> list) {
		Integer min=list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y); // en küçük sayi
	// Integer min=list.stream().reduce(Integer.MIN_VALUE,(x,y)->x<y?y:x); // en büyük sayi
	System.out.println(min);
	
	
	
	}
	
	
	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
    //3. yontem Method Reference --> Haluk class
	  
	public static int minBul(int x, int y) {
  		return x<y ?x:y; // ternary
  	}
  	public static void min3(List<Integer> list) {
		Optional<Integer> min=list.stream().reduce(Lambda02::minBul );
		System.out.println(min);
	}
  	
  	
	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
    //2. yontem Method Reference --> math class
	public static void min2(List<Integer> list) {
		Optional<Integer> min=list.stream().reduce(Math::min);
		System.out.println(min);
	}

	//List'teki elemanlardan en kucugunu 4 farklý yontem ile yazdiriniz
    //1. yontem Method Reference --> Integer class
	public static void min1(List<Integer> list) {
		Optional<Integer> min=list.stream().reduce(Integer::min);	
		System.out.println(min);
	}
	
	
	//List'teki cift elemanlarin carpimini yazdiriniz.
    //Lambda expression...
	 public static void carpCiftEl2(List<Integer> list) {
		 Integer carp=list.stream().filter(Lambda01::ciftBul).reduce(1, (x,y)-> x*y);
		 //pozitif deger uretiniz
		 Integer carpPoz=list.stream().filter(Lambda01::ciftBul).reduce(-1, (x,y)-> x*y);
			System.out.println(carp);	
			System.out.println(carpPoz);	
		
	}
	
	//List'teki cift elemanlarin carpimini  yazdiriniz.
    //Method Reference...
	private static void carpCiftEl1(List<Integer> list) {
		Optional<Integer> carp=list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);
		System.out.println(carp);	
	}
	
	
	//List'teki tum elemanlarin toplamini yazdiriniz.
    //Method Reference...
	public static void toplaEl2(List<Integer> list) {
		 Optional<Integer> toplam = list.stream().reduce(Math::addExact);
	        // Optional<Integer> toplam = list.stream().reduce(Integer::sum);
	System.out.println(toplam);
		
	}
	
	
	
	//List'teki tum elemanlarin toplamini yazdiriniz.
        //LAmbda Expression...
	 public static void toplaEl1(List<Integer> list) {
        	
		 int toplam = list.stream().reduce(0, (x, y) -> x + y);
	      /*
	        x  her zaman ilk degerini atanan degerden (0) alýr
	        y her zaman degerini list.stream()'den alýr(akis)
	        x ilk degerden sonraki degerlerini islemden alir
	       */
	        System.out.println(toplam);
	        // System.out.println(list.stream().reduce(0,(x, y) -> x + y));
        	
        }
	//List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
	public static void ciftKareMax(List<Integer> list) {
		  // Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
        //reduce(Math::max) da kullanilabilir ancak reduce(Integer::max); daha specific  oldugu icin hzili calisir

        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
        // reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
        //Optional class' sart kosuyor
        System.out.println(maxEl);
		
     
      
        
       
        
        
        
		
	}

}
