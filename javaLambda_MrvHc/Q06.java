package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q06 {

	public static void main(String[] args) {
		//Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayýlarý yazdýrýn
	    //6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
	    //Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
		
		List<Integer> list=new ArrayList<>(Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15));
		
		//Fonksiyonel Programlama ile [12, 9, 13, 4, 6, 2, 4, 12, 15] listesindeki tüm tek sayýlarý yazdýrýn
		list.stream().filter(t->t%2==1).forEach(Methods::printInt); // 9 13 15
		System.out.println();
		
		//6 ile 14 arasindaki tum sayilarin karesini ekrana yazdiriniz
		
		list.stream().filter(t->t>=6 && t<=14).map(t->t*t).forEach(Methods::printInt); // 144 81 169 36 144 
		System.out.println();
		//Listteki tek tamsayilarin karekoklerinin toplamini ekrana yazdiriniz
		list.stream().filter(t->t%2==1).mapToDouble(Math::sqrt).forEach(t->System.out.print(t+ " ")); // 3.0 3.605551275463989 3.872983346207417 
		
		
		
		
		

	}

}
