import java.io.Serializable;

public abstract class Felszereles implements Serializable {
    private int lejarat;
    private Virologus vir;
    private boolean aktiv;

    /**
     * Felszereles konstruktor
     */
    public Felszereles() {
        vir = null;
    }

    /**
     * Getterek-Setterek
     * @return
     */
    public int getLejarat() {
        return lejarat;
    }
    public void setLejarat(int lejarat) {
        this.lejarat = lejarat;
    }

    /**
     * A felszerelések hatásainak absztrakt függvénye.
     *
     */
    public abstract void felszerelesHatas(Virologus forras, Virologus cel, Agens a);

    /**
     * set - get Virologus
     * @param virologus
     */
    public void setVirologus( Virologus virologus) { this.vir = virologus; }
    public Virologus getVirologus() { return vir; }

    /**
     * Set-get aktiv
     * @return
     */
    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
    public  void onRemove(){}
}