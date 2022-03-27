public class Ures extends Mezo{

    /**
     * Elfogadja a megadott virologust a mezõre
     *
     * @param vir Ezt a virológust fogadja el az adott mezõre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virológus üres mezõre lép.");
    }

    /**
     * Eltávolitja az adott virologust a mezõrõl
     *
     * @param vir Ezt a virológust távolítja el az adott mezõrõl
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Virológus elhagyja az üres mezõt");
    }
}
