import static java.lang.Math.min;

public class Zsak extends Felszereles {
    private int plusAnyag;
    private Anyag tarolo;
    private boolean hozzaadva = false;
    public Zsak(){
        setAktiv(false);
    }

    public int getMaxAnyag() {return plusAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.plusAnyag = maxAnyag; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }



    /**
     * A virológus tárolójának méretét növeli.
     * @param cel Virológus akire hat a felszerelés hatás.
     */
    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        if(!hozzaadva){
            cel.setMaxAnyag(getMaxAnyag()+plusAnyag);
            hozzaadva = true;
        }

    }

    /**
     * Ha a felszerelések listából kidobjuk a zsákot akkor csökkenti a zsák méretét és eldobja a felesleges anyagokat.
     */
    @Override
    public void onRemove(){
        getVirologus().setMaxAnyag(getVirologus().getMaxAnyag()-plusAnyag);
        // Eldobja azokat az anyagokat amik nem férnek el a tárolóban
        if(getVirologus().getTarolo().getAminosav() > getVirologus().getMaxAnyag() || getVirologus().getTarolo().getNukleotid() > getVirologus().getMaxAnyag()){
            getVirologus().setTarolo(new Anyag(min(getVirologus().getTarolo().getNukleotid(),getVirologus().getMaxAnyag())
                    ,min(getVirologus().getMaxAnyag(),getVirologus().getTarolo().getAminosav())));

        }
    }
}
