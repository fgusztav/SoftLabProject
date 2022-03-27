public abstract class Agens implements Leptetheto{
    protected int idotartam;
    protected boolean kenve;
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
