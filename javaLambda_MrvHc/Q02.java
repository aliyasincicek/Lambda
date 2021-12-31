package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Q02 {

	
	public static void main(String[] args) {
		//2) Bir class oluþturun, 'Q03' olarak adlandýrýn
//  3) 5 elemanlý bir tamsayý listesi oluþturun
//  4) Elemanlari doðal sýraya koyun
//  5)Konsoldaki son 3 elemanýn karelerinin toplamýný bulun.
//  6) Konsoldaki toplamý yazdýrýn
//  7) 'Fonksiyonel Programlama' kullanýn
		
	
		List <Integer> list=new ArrayList(Arrays.asList(78,56,3,2,99));
		OptionalInt kareTopla=list.stream().sorted().skip(2).mapToInt(t->t*t).reduce(Integer::sum);
		System.out.println(kareTopla); // OptionalInt[19021]

	}

}
