public class Vitustanc_kod extends Kod {

    /**
     * Ezzel a metódussal hozzuk létre az vítustánc ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public Vitustanc letrehoz (Anyag a){
        System.out.println("Vitustanc_kod.letrehoz() ->Letrehoz vitustanc.");
        return new Vitustanc();
    }
}
