package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q03 {

	public static void main(String[] args) {
		//String isimlerden olusan bir list olusturun
	    //Konsoldaki farkl� ��eleri uzunluklar�yla birlikte yazd�r�n.
	//Konsoldaki farkl� ��eleri yazd�r�n, uzunluklar�na g�re s�ralay�n.
	//Konsoldaki farkl� ��eleri yazd�r�n, son karakterlerine g�re s�ralay�n.
	//Konsoldaki farkl� ��eleri ters s�rada yazd�r�n.
	//Uzunlu�u 7'den k���k olan farkl� ��eleri ters s�rada konsolda b�y�k harflerle yazd�r�n.
		
		List <String> list=new ArrayList(Arrays.asList("Ali","Ayse","Ridvan","Ahmet","Rosier","Ghezzal","Pjanic"));
		 //Konsoldaki farkl� ��eleri uzunluklar�yla birlikte yazd�r�n.
		list.stream().map(t->t.length()).distinct().forEach(Methods::printInt); // 3 4 6 5 7 
		System.out.println();
		
		// Konsoldaki farkl� ��eleri yazd�r�n, uzunluklar�na g�re s�ralay�n.
		list.stream().map(t->t.length()).sorted().distinct().forEach(Methods::printInt);//3 4 5 6 7 
		System.out.println();
		
		// //Konsoldaki farkl� ��eleri yazd�r�n, son karakterlerine g�re s�ralay�n.
		list.stream().sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1))).forEach(Methods::printStr);
		//Pjanic Ayse Ali Ghezzal Ridvan Rosier Ahmet
		System.out.println();
		
		//Konsoldaki farkl� ��eleri ters s�rada yazd�r�n.
		list.stream().sorted(Comparator.reverseOrder()).forEach(Methods::printStr);
		// Rosier Ridvan Pjanic Ghezzal Ayse Ali Ahmet 
		System.out.println();
		
		// Uzunlu�u 7'den k���k olan farkl� ��eleri ters s�rada konsolda b�y�k harflerle yazd�r�n.
		list.stream().filter(t->t.length()<7).sorted(Comparator.reverseOrder()).forEach(Methods::printStr);
		//Rosier Ridvan Pjanic Ayse Ali Ahmet 
		
		
	}

}
