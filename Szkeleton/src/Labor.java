public class Labor extends Mezo {
    private Kod k;

    public Labor(Kod h) {
        this.k = h;
    }

    public Kod getH() {return k;}
    public void setAgens(Kod h) {this.k = h;}

    /**
     * Elfogadja a megadott virologust a mezőre
     *
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virolegus belepett a laborba.");
    }

    /**
     * Eltávolitja az adott virologust a mezőről
     *
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public void eltavolit(Virologus vir) {

        System.out.println("Virolegus kilépett a laborbol.");
    }
}
