package javaLambda_MrvHc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q08 {

	public static void main(String[] args) {
		 // 7 ile bolunebilen ilk 10 tamsayinin toplamini ekrana yazdiriniz.
	/*int toplam=0;
		for (int i = 1; i < 71; i++) {
		if(i%7==0) {
			System.out.print(i+ " ");
			toplam+=i;
		*/
		
		 // 7 ile bolunebilen ilk 10 tamsayinin toplamini ekrana yazdiriniz.
	   
	        //1.way
	        System.out.println(IntStream
	                .rangeClosed(1, 70)//1ile 70arasindaki sayilari yzdirmaya yarar
	                .filter(t -> 7 == 0)
	                .sum());
	        //2.way
	        System.out.println(IntStream
	                .iterate(7, t -> t + 7)//7den baslayip 7ser 7ser
	                .limit(10)
	                .sum());
	}

}
