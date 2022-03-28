public class Raktar extends Mezo {
    private Anyag tarolo;
    private boolean ures;

    public Anyag getTarolo() {return tarolo;}
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo;}

    public boolean getUres() {return ures;}
    public void setUres(boolean ures) {this.ures = ures;}

    public Raktar (Anyag a, boolean ures){
        tarolo = a;
        this.ures = ures;
    }

    /**
     * Elfogadja a megadott virologust a mez�re
     *
     * @param vir Ezt a virol�gust fogadja el az adott mez�re
     */
    public void elfogad(Virologus vir) {
        System.out.println("Raktar.elfogad() -> Virologus belepett a raktarba.");
    }

    /**
     * Elt�volitja az adott virologust a mez�r�l
     *
     * @param vir Ezt a virol�gust t�vol�tja el az adott mez�r�l.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Raktar.eltavolit() -> Virologus kilepett a raktarbol.");
    }
}
