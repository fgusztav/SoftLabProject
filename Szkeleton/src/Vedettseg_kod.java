public class Vedettseg_kod extends  Kod {

    public Vedettseg_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }

    /**
     * Ezzel a metódussal hozzuk létre az védettség ágenst.
     */
    public Vedettseg letrehoz (){
        //System.out.println("Vedettseg_kod.letrehoz() ->Letrehoz vedettseg.");
        return new Vedettseg(this.getV());
    }
}
