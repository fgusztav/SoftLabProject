public class Vedettseg_kod extends  Kod {

    /**
     * Ezzel a metódussal hozzuk létre az védettség ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public Vedettseg letrehoz (Anyag a){
        System.out.println("Letrehoz vedettseg.");
        return new Vedettseg();
    }
}
