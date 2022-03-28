public class Kesztyu extends Felszereles {

    public Kesztyu() {}
    /**
     * A felkent ágenst visszadobja a kenő virológusra.
     * @param v Virológus akire hat a felszerelés hatás.
     */
    @Override
    public void felszerelesHatas(Virologus v) {
        System.out.println("Kesztyu.felszerelesHatas() -> Kesztyu hatas.");
    }
}
