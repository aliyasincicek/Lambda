package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01 {

	public static void main(String[] args) {
//      2) "Q01" olarak adland�r�lan bir class olu�turun
//      3) 5 String ��esi i�eren bir String list olu�turun.
//      4) 3 tanesi "A" harfi ile ba�layacak
//      5) Elemanlar "A" harfi ile ba�l�yorsa ve elemanlar�n uzunluklar�
//      5'ten k���kse, konsolda list olarak buyuk harflerle yazd�r�n.
		
		List <String> list=new ArrayList(Arrays.asList("Ali","Ayse","Ahmet","Rosier","Ghezzal"));
		list.stream().filter(t->t.startsWith("A")&&t.length()<5).map(t->t.toUpperCase()).forEach(Methods::printStr);

	}

}
