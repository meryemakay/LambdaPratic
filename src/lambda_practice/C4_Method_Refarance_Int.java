package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        tekYaz(intL);
        System.out.println("***\n");
        System.out.println("ciftlerıCarp(intL) = " + ciftlerıCarp(intL));
        System.out.println("negatıflerınKareTop(intL) = " + negatıflerınKareTop(intL));
        System.out.println("maxPoztfKup(intL) = " + maxPoztfKup(intL));
    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
public static void tekYaz(List<Integer> l){
        l.stream().filter(Methods::tekMi).forEach(Methods::yazInteger);

}

    // S2: ciftlein carpimini bulalim
    public static Optional<Integer> ciftlerıCarp(List<Integer> l){
       return l.stream().filter(Methods::ciftMi).
               reduce(Math::multiplyExact); //yan yana sayıları carpar

    }


    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> negatıflerınKareTop(List<Integer> l){
        return l.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Methods::toplam);

    }

    // S4: poziflerin kuplerinden max olanı yazdiralim
    public static Optional<Integer> maxPoztfKup(List<Integer> l){
        return l.stream().filter(Methods::pozitifMi).
                map(Methods::kupBul).reduce(Math::max);
    }


}
