public class Amnezia_kod extends Kod{

    /**
     * Ezzel a metódussal hozzuk létre az amnézia ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public Amnezia letrehoz (Anyag a){
        System.out.println("Létrehoz amnézia.");
        return new Amnezia();
    }
}
