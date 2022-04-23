public class Labor extends Mezo {
    private Kod kod;
    private Medvetanc m;

    public Labor() {}

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
    @Override
    public void elfogad(Virologus vir) {
        super.elfogad(vir);

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
