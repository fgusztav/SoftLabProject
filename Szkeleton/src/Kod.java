import java.io.Serializable;

public abstract class Kod implements Serializable {
    private Anyag ar;
    private Virologus v;

    /**
     * Setterek- Getterek V-nek
     *
     * @return
     */
    public Virologus getV() {
        return v;
    }

    public void setV(Virologus v) {
        this.v = v;
    }

    /**
     * get -set ár
     *
     * @return
     */
    public Anyag getAr() {
        return ar;
    }

    public void setAr(Anyag ar) {
        this.ar = ar;
    }

    /**
     * 4
     * kod konstruktora
     */
    public Kod() {
    }

    /**
     * Kod konstruktor
     *
     * @param v
     */
    public Kod(Virologus v) {
        this.v = v;
    }

    /**
     * Ezzel a metódussal hozunk létre egy ágenst.
     */
    public abstract Agens letrehoz();

}
