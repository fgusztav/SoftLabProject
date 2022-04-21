public class Varos extends Mezo {
    private boolean ures;

    public Varos(){}; //leironyelvhez
    public Varos(Felszereles felszereles, boolean ures) {
        getFelszerelesek().add(felszereles);
        this.ures = ures;
    }
    public Varos(Felszereles felszereles) {
        getFelszerelesek().add(felszereles);
        this.ures = false;
    }

    public boolean getUres() {return ures;}
    public void setUres(boolean ures) {this.ures = ures;}

    /**
     * Elfogadja a megadott virologust a mezőre
     *
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public void elfogad(Virologus vir) {
        System.out.println("Varos.elfogad() ->Virologus belepett a varosba.");
    }

    /**
     * Eltávolitja az adott virologust a mezőről
     *
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Varos.eltavolit() ->Virologus kilepett a varosbol.");
    }
}
