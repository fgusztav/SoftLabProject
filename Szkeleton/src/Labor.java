public class Labor extends Mezo {
    private Kod kod;
    public Labor(){};

    public Labor(Kod kod) {
        this.kod = kod;
    }

    public Kod getKod() {return kod;}
    public void setKod(Kod k) {this.kod = kod;}

    /**
     * Elfogadja a megadott virologust a mezőre
     *
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Labor.elfogad() -> Virolegus belepett a laborba.");
    }

    /**
     * Eltávolitja az adott virologust a mezőről
     *
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public void eltavolit(Virologus vir) {

        System.out.println("Labor.eltavolit() -> Virolegus kilépett a laborbol.");
    }
}
