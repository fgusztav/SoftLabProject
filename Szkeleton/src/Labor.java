public class Labor extends Mezo {
    private Agens h;

    public Agens getH() {return h;}
    public void setAgens(Agens h) {this.h = h;}

    /**
     * Elfogadja a megadott virologust a mezőre
     *
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virológus belépett a laborba.");
    }

    /**
     * Eltávolitja az adott virologust a mezőről
     *
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Virológus kilépett a laborból.");
    }
}
