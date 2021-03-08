package Day1;

public class Piwo {
    private int wiekDozwolony = 18;
    protected double moc;
    protected String nazwa;

    public String czyPiwo(int wiek) {
        if (wiek >= wiekDozwolony) {
            return "Moze pic piwo "+nazwa+" o mocy "+moc+"%";
        } else {
            return "Nie moze pic piwa "+nazwa+" o mocy "+moc+"%";
        }
    }

    public Piwo(String nazwa,double moc){
        this.nazwa = nazwa;
        this.moc = moc;
    }

    @Override
    public String toString() {
        return "Piwo{" +
                "moc=" + moc +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
