package lambda_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglencelidi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");
        System.out.println("ilk harfı d ve c olan " + ılkHarfdVeyCoLAN(list));
        System.out.println("\n");
        yıldızlıyaz(list);
        System.out.println("alfabetık sıra "+ alfabetıkSıra(list));
        llerıSıl(list);
        System.out.println("e olanların kıstesı " +eOlnlarınLıstesı(list));
        ılkHrfıucKreYaz(list);
        ılkbuyukSonraKucuk(list);
        System.out.println("uzunluk 4 ve 6 harıc : "+ uzunluk4ve6Harıc(list));
    }
    // S1: ilk harfi d ve ya c olanlari listeleyelim
public static List<String> ılkHarfdVeyCoLAN(List<String> l){
     return l.stream().filter(t->t.startsWith("d")||t.startsWith("c")).
             collect(Collectors.toList());
}

    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void yıldızlıyaz(List<String> l){
         l.stream().map(t->"*"+ t+"*").forEach(t-> System.out.println(t +" "));
    }

    //S3: alfabedik  gore siralayalim list olarak
    public static List<String> alfabetıkSıra(List<String> l) {
        return l.stream().sorted().collect(Collectors.toList());
    }
    //S4: tum 'l' leri silelim yazdiralim
    public static void llerıSıl(List<String> l){
        System.out.println();
        l.stream().
                map(t->t.replaceAll("l","")).
                forEach(t->System.out.println(t+ " "));
    }

    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static List<String> eOlnlarınLıstesı(List<String> l) {
        return l.stream().filter(t->t.contains("e")).collect(Collectors.toList());
    }


    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi

    public static void ılkHrfıucKreYaz(List<String> l) {
        System.out.println();
        l.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(0,1).toLowerCase()+t.toLowerCase()).
                forEach(t-> System.out.println(t));
    }

    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static void ılkbuyukSonraKucuk(List<String> l) {
        System.out.println();
        l.stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                forEach(t-> System.out.println(t));
    }



    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz

    public static List<String> uzunluk4ve6Harıc(List<String> l) {
        return l.stream().filter(t->t.length()!=4 && t.length()!=6).collect(Collectors.toList());
    }

}
