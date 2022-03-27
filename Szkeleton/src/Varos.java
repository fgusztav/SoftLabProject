public class Varos extends Mezo {
    private Felszereles felszereles;
    private boolean ures;

    public Varos(Felszereles felszereles, boolean ures) {
        this.felszereles = felszereles;
        this.ures = ures;
    }

    public Felszereles getFelszereles() {return felszereles;}
    public void setFelszereles(Felszereles tarolo) {felszereles = tarolo;}

    public boolean getUres() {return ures;}
    public void setUres(boolean ures) {this.ures = ures;}

    /**
     * Elfogadja a megadott virologust a mezőre
     *
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virologus belepett a varosba.");
    }

    /**
     * Eltávolitja az adott virologust a mezőről
     *
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Virologus kilepett a varosbol.");
    }
}
