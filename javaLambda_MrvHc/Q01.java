package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01 {

	public static void main(String[] args) {
//      2) "Q01" olarak adlandýrýlan bir class oluþturun
//      3) 5 String öðesi içeren bir String list oluþturun.
//      4) 3 tanesi "A" harfi ile baþlayacak
//      5) Elemanlar "A" harfi ile baþlýyorsa ve elemanlarýn uzunluklarý
//      5'ten küçükse, konsolda list olarak buyuk harflerle yazdýrýn.
		
		List <String> list=new ArrayList(Arrays.asList("Ali","Ayse","Ahmet","Rosier","Ghezzal"));
		list.stream().filter(t->t.startsWith("A")&&t.length()<5).map(t->t.toUpperCase()).forEach(Methods::printStr);

	}

}
