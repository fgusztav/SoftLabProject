public class Kesztyu extends Felszereles {
    public Kesztyu() {
        setAktiv(false);
        setLejarat(3);
    }

    /**
     * A felkent ágenst visszadobja a kenő virológusra.
     *
     */
    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        this.getVirologus().kenes(forras,a);
        this.getVirologus().getRakenve().remove(a);
    }
}
