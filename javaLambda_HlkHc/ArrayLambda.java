package javaLambda_HlkHc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayLambda {
    public static void main(String[] args) {
        /*
        kullan�c�dan ald�g�n�z bir array'in en buyuk ve en kucuk elemanlar�n�n fark�n� hesaplay�n�z
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("arrayiniz icin eleman sayisi belirleyin:");
        int arrBoyutu = scan.nextInt();

        int arr[] = new int[arrBoyutu];

        for (int i = 0; i < arrBoyutu; i++) {
            System.out.println("Arrayin " + (i + 1) + ". elemanini giriniz");
            arr[i] = scan.nextInt();
        }
        System.out.println(Arrays.stream(arr).sorted().filter(t -> t < arr[1] || t > arr[arr.length - 2]).reduce((t, u) -> t - u));
    }
}
