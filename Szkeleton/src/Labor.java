import java.util.Random;

public class Labor extends Mezo {
    private Kod kod;
    private Medvetanc m;

    public Labor() {
        if (GameManager.rand == true) {
            Random ra = new Random();
            int r = (int) ra.nextInt(100);
            m = (r < 25) ? (new Medvetanc()) : null;
        }
        else {
            m = null;
        }
    }

    public Kod getKod() {return kod;}
    public void setKod(Kod k) {this.kod = kod;}

    public Medvetanc getM() {
        return m;
    }

    public void setM(Medvetanc m) {
        this.m = m;
    }

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
