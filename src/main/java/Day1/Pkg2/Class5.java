package Day1.Pkg2;

import Day1.Pkg1.Class1;

public class Class5 {

    Class1 class1 = new Class1();

    public void metoda3(){
        //class1.protektowana = 3; - tu juz nie
        class1.publiczna = 2;
        // class1.zadna = 1; tu juz nie
        class1.setZadna(1);
        //class1.prywatna ??? - ta nie
    }

}
