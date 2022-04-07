public class Zsak extends Felszereles {
    private int maxAnyag;
    private Anyag tarolo;

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    /**
     * A virológus tárolójának méretét növeli.
     * @param cel Virológus akire hat a felszerelés hatás.
     */
    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        //System.out.println("Zsak.felszerelesHatas() -> Zsak hatas.");
    }
}
