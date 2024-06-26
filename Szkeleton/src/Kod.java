import java.io.Serializable;

public abstract class Kod implements Serializable {
    private Anyag ar;
    private Virologus v;

    /**
     * Setterek- Getterek virologusnak
     *
     * @return  visszaadja/beállítja melyik virologus ismeri
     */
    public Virologus getV() { return v; }
    public void setV(Virologus v) { this.v = v; }
    /**
     * Setterek- Getterek kód árának
     *
     * @return  visszaadja/beállítja mennyibe anyagba kerül az ágens elkészítése a kódból
     */
    public Anyag getAr() {return ar; }
    public void setAr(Anyag ar) {this.ar = ar;}

    public Kod () {}

    /**
     * Ezzel a metódussal hozunk létre egy ágenst.
     */
    public abstract Agens letrehoz ();

    /**
     * Lekéri az objektum adatait
     */
    void observe(){}
}
