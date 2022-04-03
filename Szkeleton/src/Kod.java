public abstract class Kod {
    private Anyag ar;

    public Anyag getAr() {return ar; }
    public void setAr(Anyag ar) {this.ar = ar;}

    /**
     * Ezzel a metódussal hozunk létre egy ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public abstract Agens letrehoz (Anyag a);
}
