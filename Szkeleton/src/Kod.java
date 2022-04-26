import java.io.Serializable;

public abstract class Kod implements Serializable {
    private Anyag ar;
    private Virologus v;

    /**
     * Setterek- Getterek
     */
    public Virologus getV() { return v; }
    public void setV(Virologus v) { this.v = v; }

    public Anyag getAr() {return ar; }
    public void setAr(Anyag ar) {this.ar = ar;}

    public Kod () {}

    /**
     * Ezzel a metódussal hozunk létre egy ágenst.
     */
    public abstract Agens letrehoz ();

}
