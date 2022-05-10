package lambda_practice;
//multi arrayleri cevirirken flatMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        System.out.println("list(arr) = " + list(arr));
        System.out.print("e ıle baslaynlar : ");
        doubleYaz(arr);
        System.out.println("eıleBaslayanYazListe(arr) = " + eıleBaslayanYazListe(arr));
        kıleBıtenlereyıldız(arr);

    }
    // S1 : tum elemanlari list yapalim
public static List<String>list(String[][] str){
        return Arrays.stream(str).flatMap(t->Arrays.stream(t)).collect(Collectors.toList());
}


    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim

    public static void doubleYaz(String[][] str){
         Arrays.stream(str).
                 flatMap(t->Arrays.stream(t)).
                 filter(t->t.toLowerCase().startsWith("e")).
                 map(t->t+t).
                forEach(t->System.out.println(t +" "));
    }


    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> eıleBaslayanYazListe(String[][] str){


    return    Arrays.stream(str).
    flatMap(t->Arrays.stream(t)).
    filter(t->t.toLowerCase().startsWith("e")).
            collect(Collectors.toList());

}



    //S4 : k ile bitenlerin sonuna '*' ekleyelim
public static void kıleBıtenlereyıldız(String [][] arr){

        Arrays.stream(arr).
                flatMap(t->Arrays.stream(t)).
                filter(t->t.toLowerCase().startsWith("k")).
                map(t->t+"*").
                forEach(t->System.out.println(t + " "));
}

}
