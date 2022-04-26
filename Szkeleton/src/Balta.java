public class Balta extends Felszereles{
    /**
     * Balta instruktor
     */
    public Balta() {
        setLejarat(1);
        setAktiv(true);
    }

    /**
     * A felszerelés hatásba lép
     * @param forras
     * @param cel
     * @param a
     */
    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        forras.getFelszereles().remove(this);
        forras.megol(cel);

        getVirologus().getFelszereles().remove(this);
        setVirologus(null);

    }

    @Override
    public String toString() {
        return "Balta";
    }
}
