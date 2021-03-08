package Day1.Pkg1;

public class Class1 {
    public int publiczna;
    protected int protektowana;
    int zadna;
    private int prywatna;

    public void metoda(){
        prywatna=1;
    }

    public int getPubliczna() {
        return publiczna;
    }

    public int getProtektowana() {
        return protektowana;
    }

    public int getZadna() {
        return zadna;
    }

    public int getPrywatna() {
        return prywatna;
    }

    public void setZadna(int zadna) {
        this.zadna = zadna;
    }



    //Class2 - ten sam pkg, dziedziczy po 1 - do ktorych mziennych dostep?
    //Class3 - ten sam pkg, nie dzidziczy, tylko tworzy obiekt klasy 1
    // - do ktorych pol dostep
    //Class4 - inny pkg, dziedziczy po 1 - do ktorych pol dostep
    //Class5 - inny pkg, nie dziedziczy, tworzy obiekt klasy 1
    // do ktorych pol dostep
}
