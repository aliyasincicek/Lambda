package javaLambda_Notlar;

public class Summary {
	/*
	 * BİR STREAM NASIL OLUŞTURULUR? •
Her hangi List, Set gibi bir Collection .stream() metodu Stream’ler ile çalışabilir hale gelir.
List <Integer>liste = new ArrayList<>(); 
liste.stream()
Integer[] dizi = { 3, 1, 4, 1, 5, 9 }; 
Stream <Integer>streamDizi =Stream.of(dizi);
Stream<String>kişiler = Stream.of("Ahmet", "Mahmet", "John"); 
Stream<Integer> rakamlar = Stream.of(3, 1, 4, 1, 5, 9);

İşlemlerin sırası özellikle büyük miktardaki veriler için önem arz eder. Önce filtreleme (filter), sonra sıralama (sort) ve değiştirme (map)
Yaygın kullanılan ara işlemlerden bazısı •filter() map() sorted() distinct() limit() •findFirst() skip() flatMap()gibi stream

Terminal işlemi Stream nesnesini alır ve tüketir. (eager) 
•Sadece tek terminal işlemi kullanılabilir.  •Yaygın kullanılan terminal işlemlerinden bazısı
•forEach() reduce() collect () max() min() count()

kaynak:  (collection, list, set,array,file)
ara işlem: (filter, Map, sort, distinct, limit , •döndüren metotlar)
terminal :(forEach, collect, reduce, min ,count gibi void veya stream döndürmeyen metotlar)

--METOTLAR--
filter() : Streamdeki verileri içerisinde çağırılan fonksiyona göre filtreyen Ara işlem metodudur. 

forEach(): Gelen verilerin tamamı işlenene (verilen metoda göre) veya bir exception oluşana kadar iterasyona devam eder. Terminal işlemdir. Stream’i kapatır.         
                                                                                                   Classname      methodname                                                               
list.stream().filter(t->t%2==0).forEach(Lambda01_01::printer);

map() : Stream’deki verileri verilen metoda göre değiştiren (transformasyon) ara işlem metodudur.
private static void kareAl2(List list){    Classname    methodname  list.stream().filter(Stream01::tekMi). map(Stream01 ::kareAl). forEach(Stream01 ::yazdır); } 
private static boolean tekMi(int a){ return (a % 2 != 0);} private static int kareAl(int a){ return a*a;}

reduce ():Kendi indirgeme işlemlerimizi tanımlayabileceğimiz genel amaçlı bir metottur

• İndirgeme (reduction) bir stream’in bir türe veya bir primitive‘e dönüştürülmesini sağlayan bir terminal işlemdir. 
• Java 8 Stream API’de average(), sum(), min(), max() ve count() gibi tanımlanmış bir çok indirgeme metodu bulunmaktadır. 
• Bu metotlar ilgili işlemleri gerçekleştirip tek bir değer döndürmektedir.
Bir listeyi parametre olarak alan ve listedeki tek sayıların karelerinin toplamını hesaplayan metodu yazınız
private static Integer tekKareToplamı1(List<Integer> liste){
return liste.stream().filter(t->t%2!=0).map(t->t*t).
reduce(0, (x,y)->x+y);}  ya da
private static Optional tekKareToplamı2(List liste){ 
return liste.stream(). filter(Stream01::tekMi).map(Stream01 ::kareAl). reduce(Integer::sum); // reduce(Math::addExact);
Listedeki tek elemanların karelerini sıralayan ve sonucu bir liste olarak döndüren metodu yazınız. 
NOT: Tekrar eden elamanlar bir kere yazdırılmalı. 
• Tekrar eden elemanlar nasıl engellenebilir?  Distinc() 

• Sıralama nasıl yapılır?  Sorted() 

• Stream’in sonucu bir listeye nasıl saklanabilir?   Collect() 
•
 collect() Stream API’deki terminal işlemlerinden birisidir. 
• Streamdeki elemanların çeşitli veri yapılarına döndürülmesi ve bazı ek işlemlerin uygulanmasını sağlamaktadır. 

• collect() işlemindeki strateji Collector arayüzleri (interface) yardımıyla gerçekleştirilir
public static List<Integer> tekKareAlSıralı(List<Integer> list){
return list.stream().filter(Stream01::tekMi).distinct().map(Stream01::kareAl).
sorted().collect(Collectors.toList())	

anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır
findFirst() ilk elelmani aldi
skip(1).//ilk elelamı atlatildi

	 */

}
