package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q05 {

	public static void main(String[] args) {
//      {"A", "B", "D", "C", "B", "A", "A", "B", "B"} gibi bir array olu�turun;
//      Tekrarlanan ��eleri konsolda yazd�r�n

 String arr[] = {"A", "B", "C", "B", "D", "A", "B", "B"};
 List<String> list = Arrays.asList(arr);
 list.stream()
         .filter(t-> Collections.frequency(list,t)>1) // Collections.frequency-> collectionsta list te ki t elemanlar�n�n say�s�n� d�nd�r�r
         .collect(Collectors.toSet())
         .forEach(t-> System.out.println(t));
	}

}
