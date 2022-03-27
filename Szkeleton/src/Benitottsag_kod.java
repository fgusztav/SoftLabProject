public class Benitottsag_kod extends Kod{

    /**
     * Ezzel a metódussal hozzuk létre az bénítottság ágenst.
     * @param a Az ágens elkészítéséhez szükséges anyagmennyiség.
     */
    public Benitottsag letrehoz (Anyag a){
        System.out.println("Letrehoz benitottsag.");
        return new Benitottsag();
    }
}
