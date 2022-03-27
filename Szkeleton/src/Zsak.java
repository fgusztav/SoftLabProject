public class Zsak extends Felszereles {
    private int maxAnyag;
    private Anyag tarolo;

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    /**
     * A virológus tárolójának méretét növeli.
     * @param v Virológus akire hat a felszerelés hatás.
     */
    public void felszerelesHatas(Virologus v) {

    }
}
