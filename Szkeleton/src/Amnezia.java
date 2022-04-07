public class Amnezia extends Agens {

    public Amnezia(Virologus virologus){
        setIdotartam(1);
        setKenve(false);
        setVirologus(virologus);
    }

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() { //TODO: Balint, ezt h? 1.: keneskor hatas meghivodik? 2. ha a setIdotartam 1,akkor meg Agenskent nem jar le?
        //System.out.println("Amnezia.lep() ->Amnezia hatas leptetese.")
    }

    /**
     * A virológus elfelejti az összes addig ismert genetikai kódot, törli a paraméterként megadott virológus
     * ismert_hatasok listáját.
     * @param v Ez a virológus fogja elfelejteni a megtanult genetikai kódokat.
     */
    public void hatas (Virologus v) {
        v.getIsmert_hatasok().clear();
        //System.out.println("Amnezia.hatas() -> Amnezia hatasa.");
    }
}
