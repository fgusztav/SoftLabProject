public class Benitottsag_kod extends Kod{

    public Benitottsag_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }
    /**
     * Ezzel a metódussal hozzuk létre az bénítottság ágenst.
     * @param v
     */
    public Benitottsag letrehoz (Virologus v){
        //System.out.println("Benitottsag_kod.letrehoz() ->Letrehoz benitottsag.");
        return new Benitottsag(v);
    }
}
