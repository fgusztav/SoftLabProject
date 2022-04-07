public class Vitustanc_kod extends Kod {

    public Vitustanc_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }
    /**
     * Ezzel a metódussal hozzuk létre az vítustánc ágenst.
     * @param v
     */
    public Vitustanc letrehoz (Virologus v){
        System.out.println("Vitustanc_kod.letrehoz() ->Letrehoz vitustanc.");
        return new Vitustanc(v);
    }
}
