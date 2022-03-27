public class Kesztyu extends Felszereles {

    /**
     * A felkent ágenst visszadobja a kenő virológusra.
     * @param v Virológus akire hat a felszerelés hatás.
     */
    @Override
    public void felszerelesHatas(Virologus v) {
        System.out.println("Kesztyű hatás.");
    }
}
