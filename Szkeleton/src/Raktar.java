public class Raktar extends Mezo {
    private Anyag tarolo;
    private boolean ures;

    public Anyag getTarolo() {return tarolo;}
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo;}

    public boolean getUres() {return ures;}
    public void setUres(boolean ures) {this.ures = ures;}

    /**
     * Elfogadja a megadott virologust a mezõre
     *
     * @param vir Ezt a virológust fogadja el az adott mezõre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virológus belépett a raktárba.");
    }

    /**
     * Eltávolitja az adott virologust a mezõrõl
     *
     * @param vir Ezt a virológust távolítja el az adott mezõrõl.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Virológus kilépett a raktárból.");
    }
}
