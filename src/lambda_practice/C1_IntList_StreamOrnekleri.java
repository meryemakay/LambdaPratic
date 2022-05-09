package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        hepsiniYaz(list);
        negatifleriYaz(list);
        System.out.println("poztıflıst" + pozitifList(list));
        System.out.println("karelerı lıst" + kareleriList(list));
        System.out.println("karelerı tekrarsız" + kareleriTekrarsızList(list));
        Sırala(list);
        System.out.println("***");
        tersSırala(list);
        System.out.println("***");
        System.out.println("kupler"+ kuplerList(list));
        System.out.println("son basamagı 5 olmayan" + sonBasamagıbesOLMAYANKARELERList(list));
        System.out.println("eleman toplamı:" +elemnToplam(list));
        System.out.println("negatflrın karesı :" + negatıflerınKrelerı(list));
        System.out.println("besten buyk sayılar Var mı :"+bestenBuyukVarMı(list));
        System.out.println("sıfırdan kucukMU: " +sıfırdanKuuckMu(list));


    }
    // S1:listi aralarinda bosluk birakarak yazdiriniz //
public static void hepsiniYaz( List<Integer> l ){
     l.stream().forEach(t->System.out.print(t + " "));



}


    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYaz( List<Integer> l ) {
        System.out.println();
l.stream().filter(t->t<0).forEach(t->System.out.print(t + " "));
    }
    //S3: pozitif olanlardan yeni bir liste olustur
    public static List<Integer> pozitifList( List<Integer> l ) {
        System.out.println();
      return  l.stream().filter(t->t>0).collect(Collectors.toList());
    }



    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> kareleriList( List<Integer> l ) {
        System.out.println();
        return  l.stream().map(t->t*t).collect(Collectors.toList());
    }


    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> kareleriTekrarsızList( List<Integer> l ) {
        System.out.println();
        return  l.stream().map(t->t*t).
                distinct().
                collect(Collectors.toList());
    }


    //S6: listin elemanlarini kucukten buyuge siralayalim

    public static void Sırala( List<Integer> l ){
        l.stream().sorted().forEach(t->System.out.print(t + " "));

    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void tersSırala( List<Integer> l ){
        l.stream().sorted(Comparator.reverseOrder()).forEach(t->System.out.print(t + " "));

    }



    // S8: list pozitif elemanlari icin kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> kuplerList( List<Integer> l ) {
        System.out.println();
        return  l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).
                collect(Collectors.toList());//yenı lıst olsuturmk ıcın kullnılır

    }



    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> sonBasamagıbesOLMAYANKARELERList( List<Integer> l ) {
        System.out.println();
        return  l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).
                collect(Collectors.toList());//yenı lıst olsuturmk ıcın kullnılır

    }



    // S10 :list elemanlarini toplamini bulalim
public static int elemnToplam(List<Integer> l ) {
    return l.stream().
            reduce(0,(x,y)->x+y); //map ara ıslem reduce termınal ıslemdır . reduce tek sonuc dondurur
}
    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim

    public static List<Integer> negatıflerınKrelerı( List<Integer> l ) {
        System.out.println();
        return  l.stream().filter(t->t<0).
                peek(t-> System.out.println("negatıfler :" + t)).//ara ıslem negatıflerın hepsını aldı mı
                map(t->t*t).
                peek(t-> System.out.println("karelerı :" +t)).//denetlemek ıstedıgımz methoddn once koyuyoruz
                collect(Collectors.toList());//yenı lıst olsuturmk ıcın kullnılır

    }

    // S12 : listeden 5 den buyuk  sayi var mi?
public static boolean bestenBuyukVarMı( List<Integer> l ){
        return l.stream().anyMatch(t->t>5); //1 tane eslesme varsa true doner
}



    // S13 : listenin tum elemanlari sifirdan kucuk mu?

    public static boolean sıfırdanKuuckMu( List<Integer> l ){
        return l.stream().allMatch(t->t<0);//allmatch tum elemnlar sartı saglarsa true doner. bır tane de farklı olsa false olur
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsıtEleman( List<Integer> l ){
        return l.stream().noneMatch(t->t<0);//allmatch tum elemnlar sartı saglarsa true doner. bır tane de farklı olsa false olur
    }

//nommatch

    // S15: listenin sifira esit elemani yok mu?

//

    // S16:  listenin ilk 5 elemanini topla?

//lımıt

    //S17: listenin son bes elemaninin  listele

//System.out.println(list.stream().skip(list.size()-5).collect(Collectors.toList()));
}