public class Amnezia extends Agens {

    public Amnezia(Virologus virologus){
        setIdotartam(5);
        setKenve(false);
        setVirologus(virologus);
    }

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() { //TODO: Balint, ezt h? 1.: keneskor hatas meghivodik? ugy emlékszem, hogy a// 2. ha a setIdotartam 1,akkor meg Agenskent nem jar le? hát legyen az hogy a hatas dobja ki magát és nem kell, hogy a lejárata 1 legyen.
        setIdotartam(getIdotartam()-1);
    }

    /**
     * A virológus elfelejti az összes addig ismert genetikai kódot, törli a paraméterként megadott virológus
     * ismert_hatasok listáját.
     * @param v Ez a virológus fogja elfelejteni a megtanult genetikai kódokat.
     */
    public void hatas (Virologus v) {
        v.getIsmert_hatasok().clear();
        v.getRakenve().remove(this);
        //System.out.println("Amnezia.hatas() -> Amnezia hatasa.");
    }

    @Override
    public String toString() {
        return "Amnezia";
    }
}
