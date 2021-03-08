package Day1;

public class Wyjatki {


    public static void main(String[] args) {
        m2();
    }

    public static void m2(){
        m1();
    }

    public static void m1(){
        int x = 10;
        int y = 0;

        try {
            System.out.println("Start");
            double z = x / y;
            System.out.println("Udalo sie");
        }catch (ArithmeticException e) {
            System.out.println("Wyjatek!!!");
            e.printStackTrace(); // gdzies zalogowac -> miec na pozniej
            throw new ArithmeticException("dzielil przez zero jelop!");
        }
        System.out.println("Juz po");
    }
}
