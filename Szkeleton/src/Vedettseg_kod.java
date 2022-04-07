public class Vedettseg_kod extends  Kod {

    public Vedettseg_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }

    /**
     * Ezzel a metódussal hozzuk létre az védettség ágenst.
     * @param v
     */
    public Vedettseg letrehoz (Virologus v){
        System.out.println("Vedettseg_kod.letrehoz() ->Letrehoz vedettseg.");
        return new Vedettseg(v);
    }
}
