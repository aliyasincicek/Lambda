package javaLambda_MrvHc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04 {

	public static void main(String[] args) {
		 //        3) "Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson" ��elerini i�eren bir Dize listesi olu�turun
//      4)  "J" ile baslayin olan ��eleri almay�n
//      5) Farkl� ��eleri se�in
//      6)Karakter say�s�na g�re do�al s�raya koyun
//      7) T�m ��eleri b�y�k harfe d�n��t�r�n
//      8) Konsoldaki ��eleri yazd�r�n
//      9)Fonksiyonel Programlama'y� kullan�n
//      */

		List <String> list=new ArrayList(Arrays.asList("Ali","John","Ali","Alexander","Taylor","Ali","Jackson"));
		list.stream().filter(t->!t.startsWith("J")).sorted().map(t->t.toUpperCase()).distinct().forEach(Methods::printStr);
		// ALEXANDER AL� TAYLOR
	}

}
