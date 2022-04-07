public class Amnezia_kod extends Kod{
    public Amnezia_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }

    /**
     * Ezzel a metódussal hozzuk létre az amnézia ágenst.
     */
    public Amnezia letrehoz (){
        //System.out.println("Amnezia_kod.letrehoz() -> Letrehoz amnezia.");
        return new Amnezia(getV());
    }
}
