package Day1;

import java.util.ArrayList;
import java.util.List;

public class Bar {

    public static void main(String[] args) {
        Piwo piwo = new Piwo("Harnas", 8.6);
        List<Piwo> menu = new ArrayList<>();

        menu.add(piwo);
        menu.add(new Piwo("Tyskie", 4.4));

        // System.out.println(menu.size());
        //System.out.println(menu.get(1));   //indeksy od 0!!

//        menu.remove(0);
//        System.out.println(menu.get(1));

//        System.out.println(piwo.czyPiwo(22));
        menu.add(new Piwo("Krolewskie", 5.0));
        menu.add(new Piwo("Carlsberg", 6.2));

//        System.out.println(menu);
        
        for (Piwo p : menu) {
            System.out.println(menu.indexOf(p)+" "+p);
        }

        IPA ipa = new IPA("Crazy Mike",8.0,100);
        Piwo ipa2 = new IPA("Tatra",40.0,0);

        System.out.println(ipa);
        System.out.println(ipa2);

        menu.add(ipa);

    }

}
