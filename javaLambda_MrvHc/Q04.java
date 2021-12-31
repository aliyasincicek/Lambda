package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04 {

	public static void main(String[] args) {
		 //        3) "Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson" öðelerini içeren bir Dize listesi oluþturun
//      4)  "J" ile baslayin olan öðeleri almayýn
//      5) Farklý öðeleri seçin
//      6)Karakter sayýsýna göre doðal sýraya koyun
//      7) Tüm öðeleri büyük harfe dönüþtürün
//      8) Konsoldaki öðeleri yazdýrýn
//      9)Fonksiyonel Programlama'yý kullanýn
//      */

		List <String> list=new ArrayList(Arrays.asList("Ali","John","Ali","Alexander","Taylor","Ali","Jackson"));
		list.stream().filter(t->!t.startsWith("J")).sorted().map(t->t.toUpperCase()).distinct().forEach(Methods::printStr);
		// ALEXANDER ALÝ TAYLOR
	}

}
