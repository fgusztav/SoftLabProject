public class Amnezia_kod extends Kod{
    /**
     * Amnezia_kod instruktor
     */
    public Amnezia_kod(Virologus v) {
        setV(v);
        setAr(new Anyag(10, 10));
    }
    /**
     * Amnezia_kod instruktor
     */
    public Amnezia_kod() {
        setV(null);
        setAr(new Anyag(10, 10));
    }

    /**
     * Ezzel a metódussal hozzuk létre az amnézia ágenst.
     */
    public Amnezia letrehoz (){
        //System.out.println("Amnezia_kod.letrehoz() -> Letrehoz amnezia.");
        return new Amnezia(getV());
    }

    @Override
    public String toString() {
        return "Amnezia";
    }

}
