import java.util.concurrent.atomic.AtomicLongArray;

public abstract class Agens implements Leptetheto {
    private int idotartam;
    private boolean kenve;
    private Virologus virologus;



    public int getIdotartam() {return idotartam; }
    public void setIdotartam(int idotartam) {this.idotartam = idotartam; }

    public boolean getKenve() {return kenve; }
    public void setKenve(boolean kenve) {this.kenve = kenve; }

    public Virologus getVirologus() {
        return virologus;
    }
    public void setVirologus(Virologus virologus) {
        this.virologus = virologus;
    }

    public Agens() {
        kenve = false;
    }

    public Agens(Virologus v){
        kenve = false;
        virologus = v;
    }

    /**
     * Körönként csökkenti az Ágens objektum időtartamát.
     */
    public abstract void lep();

    /**
     * Az Ágens objektum speciális hatását valósítja meg.
     * @param v Erre a virológusra hat a hatás.
     */
    public abstract void hatas (Virologus v);


}
