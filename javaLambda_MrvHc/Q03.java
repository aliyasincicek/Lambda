package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q03 {

	public static void main(String[] args) {
		//String isimlerden olusan bir list olusturun
	    //Konsoldaki farklý öðeleri uzunluklarýyla birlikte yazdýrýn.
	//Konsoldaki farklý öðeleri yazdýrýn, uzunluklarýna göre sýralayýn.
	//Konsoldaki farklý öðeleri yazdýrýn, son karakterlerine göre sýralayýn.
	//Konsoldaki farklý öðeleri ters sýrada yazdýrýn.
	//Uzunluðu 7'den küçük olan farklý öðeleri ters sýrada konsolda büyük harflerle yazdýrýn.
		
		List <String> list=new ArrayList(Arrays.asList("Ali","Ayse","Ridvan","Ahmet","Rosier","Ghezzal","Pjanic"));
		 //Konsoldaki farklý öðeleri uzunluklarýyla birlikte yazdýrýn.
		list.stream().map(t->t.length()).distinct().forEach(Methods::printInt); // 3 4 6 5 7 
		System.out.println();
		
		// Konsoldaki farklý öðeleri yazdýrýn, uzunluklarýna göre sýralayýn.
		list.stream().map(t->t.length()).sorted().distinct().forEach(Methods::printInt);//3 4 5 6 7 
		System.out.println();
		
		// //Konsoldaki farklý öðeleri yazdýrýn, son karakterlerine göre sýralayýn.
		list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1))).forEach(Methods::printStr);
		//Pjanic Ayse Ali Ghezzal Ridvan Rosier Ahmet
		System.out.println();
		
		//Konsoldaki farklý öðeleri ters sýrada yazdýrýn.
		list.stream().sorted(Comparator.reverseOrder()).forEach(Methods::printStr);
		// Rosier Ridvan Pjanic Ghezzal Ayse Ali Ahmet 
		System.out.println();
		
		// Uzunluðu 7'den küçük olan farklý öðeleri ters sýrada konsolda büyük harflerle yazdýrýn.
		list.stream().filter(t->t.length()<7).sorted(Comparator.reverseOrder()).forEach(Methods::printStr);
		//Rosier Ridvan Pjanic Ayse Ali Ahmet 
		
		
	}

}
