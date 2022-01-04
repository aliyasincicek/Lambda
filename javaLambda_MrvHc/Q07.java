package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q07 {

	public static void main(String[] args) {
		//String isimlerden olusan bir list olusturnuz
	    //List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
	    //List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin
		
		List <String> list=new ArrayList(Arrays.asList("ali","ayse","ridvan","ahmet","rosier","ghezzal","pjanic"));
		
		//List'deki isimlerden "a" ve "n" icerenlerin harf sayilarinin toplamini ekrana yazdiriniz
	    // List<Integer> a=list.stream().filter(t-> t.contains("a") && t.contains("n")).map(t->t.valueOf(t.length())).reduce((x,y)->x+y)
		
		
		//List'deki isimlerden ilk harfi son harfinden alfabetik olarak onde olan isimleri ekrana yazdirin
	Collection<String> str1=list.stream().filter(t->t.codePointAt(0)<t.codePointAt(t.length()-1)).collect (Collectors.toList());
	System.out.println(str1);
		

	}

}
