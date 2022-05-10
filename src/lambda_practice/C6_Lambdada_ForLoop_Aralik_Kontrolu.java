package lambda_practice;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        ılk30(30);
        System.out.println("**\n");
        ılk30dahil(30);
        System.out.println("**\n");
        System.out.println("top(10,20) = " + top(10, 20));
        System.out.println("ort(20,30) = " + ort(20, 30));
        System.out.println("sekızeBolunenkacSayı(325,468) = " + sekızeBolunenkacSayı(325, 468));
        sekızeBolunenkacSayıYaz(325, 468);
        System.out.println("**\n");
        System.out.println("sekızeBolunenkacSayıTop(325,468) = " + sekızeBolunenkacSayıTop(325, 468));
        System.out.println("**\n");
        System.out.println("Teksayıcarp(7,15) = " + Teksayıcarp(7, 15));
        System.out.println("**\n");
        ılk10Yaz(10);




    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ılk30(int a) {


        IntStream.range(1, a).
                forEach(t -> System.out.print(t + ","));
    }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void ılk30dahil(int a) {


        IntStream.rangeClosed(1, a).
                forEach(t -> System.out.print(t + ","));
    }

    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static int top(int bas, int bit) {
        return IntStream.rangeClosed(bas, bit).sum();
        //        return IntStream.range(bas, bit+1).sum();
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static OptionalDouble ort(int bas, int bit) {
        return IntStream.rangeClosed(bas, bit).average();
    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static long sekızeBolunenkacSayı(int bas, int bit) {

        return IntStream.rangeClosed(bas, bit).filter(t -> t % 8 == 0).
                count();

    }

    //S6: 325 ile 468 arasinda 8 e bolunen sayilari yazdiralim
    public static void sekızeBolunenkacSayıYaz(int bas, int bit) {

        IntStream.rangeClosed(bas, bit).filter(t -> t % 8 == 0).
                forEach(t -> System.out.print(t + " "));

    }

    // S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim
    public static int sekızeBolunenkacSayıTop(int bas, int bit) {

        return IntStream.rangeClosed(bas, bit).
                filter(t -> t % 8 == 0).sum();


    }

    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static double Teksayıcarp(int bas, int bit) {
        return IntStream.rangeClosed(bas, bit).
                filter(Methods::tekMi).reduce(1, (x, y) -> (x * y));


    }

    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void ılk10Yaz(int a) {

        // IntStream.rangeClosed(1,a).limit(10).filter(Methods::pozitifMi).
        // filter(Methods::tekMi).  YANLIS SONUC VERECEK 1,3,5,7,9 U VERECEK


        IntStream.iterate(1, t -> t + 2).limit(10).
                forEach(Methods::yazInteger);
    }
    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim


    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belirliyoruz