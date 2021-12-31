package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Q02 {

	
	public static void main(String[] args) {
		//2) Bir class olu�turun, 'Q03' olarak adland�r�n
//  3) 5 elemanl� bir tamsay� listesi olu�turun
//  4) Elemanlari do�al s�raya koyun
//  5)Konsoldaki son 3 eleman�n karelerinin toplam�n� bulun.
//  6) Konsoldaki toplam� yazd�r�n
//  7) 'Fonksiyonel Programlama' kullan�n
		
	
		List <Integer> list=new ArrayList(Arrays.asList(78,56,3,2,99));
		OptionalInt kareTopla=list.stream().sorted().skip(2).mapToInt(t->t*t).reduce(Integer::sum);
		System.out.println(kareTopla); // OptionalInt[19021]

	}

}
