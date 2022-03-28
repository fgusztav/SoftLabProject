public class Amnezia extends Agens {
    public Amnezia() {}

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Amnezia.lep() ->Amnezia hatas leptetese.");
    }

    /**
     * A virológus elfelejti az összes addig ismert genetikai kódot.
     * @param v Ez a virológus fogja elfelejteni a megtanult genetikai kódokat.
     */
    public void hatas (Virologus v) {
        v.getIsmert_hatasok().clear();
        System.out.println("Amnezia.hatas() -> Amnezia hatasa.");
    }
}
