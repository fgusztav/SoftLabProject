public class Kesztyu extends Felszereles {
    /**
     * Kesztyu kosntruktor
     */
    public Kesztyu() {
        setAktiv(false);
        setLejarat(3);
    }

    /**
     * A felkent ágenst visszadobja a kenő virológusra.
     *
     * @param forras
     * @param cel
     * @param a
     */
    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        //this.getVirologus().kenes(forras,a);
        forras.megkenve(a);
        cel.getRakenve().remove(a);
        setLejarat(getLejarat() - 1);


        if (getLejarat() <= 0) {
            getVirologus().getFelszereles().remove(this);
        }

        // this.getVirologus().getRakenve().remove(a);
    }

    /**
     * Vissza adj a kesztyu tipusát stringbe
     *
     * @return
     */
    @Override
    public String toString() {
        return "Kesztyu";
    }
}
