public class Amnezia_kod extends Kod{
    public Amnezia_kod() {}

    /**
     * Ezzel a metódussal hozzuk létre az amnézia ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public Amnezia letrehoz (Anyag a){
        System.out.println("Amnezia_kod.letrehoz() -> Letrehoz amnezia.");
        return new Amnezia();
    }
}
