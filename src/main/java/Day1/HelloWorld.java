package Day1;

public class HelloWorld {
    public static String wiadomosc = "Hello";
    public static int ile_razy_wyswietlic = 6;

    public static void wypisz() {
        for (int i = 0; i < ile_razy_wyswietlic; i++) {
            System.out.println(wiadomosc);
            if(i==8)return;
        }

        int counter = 0;
        while (counter < ile_razy_wyswietlic) {     // wykona sie 0 lub wiecej
            System.out.println(wiadomosc);
            counter++;
        }

        counter = 0;
        do {                                //wykona sie 1 lub wiecej razy

        } while (counter < ile_razy_wyswietlic);
    }


    public static void main(String[] args) {
        wypisz();
//        String message = "Hello world";
//
//        String message2 = new String("Hello world");
//
//        String number = "123.245.234";
//
//        System.out.println(123245234==Integer.
//                parseInt(number.replace(".","")));
//
//        System.out.println(message.equals(message2));
//
//        System.out.println( "Hello World" );
    }
}
