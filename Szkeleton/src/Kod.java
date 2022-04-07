public abstract class Kod {
    private Anyag ar;
    private Virologus v;

    public Virologus getV() { return v; }
    public void setV(Virologus v) { this.v = v; }

    public Anyag getAr() {return ar; }
    public void setAr(Anyag ar) {this.ar = ar;}

    public Kod () {}

    public Kod(Virologus v){
        this.v = v;
    }

    /**
     * Ezzel a metódussal hozunk létre egy ágenst.
     * @param v
     */
    public abstract Agens letrehoz (Virologus v);
}
