public class Benitottsag extends Agens {

    public Benitottsag(Virologus v){
        setIdotartam(3);
        setKenve(false);
        setVirologus(v);
    }

    /**
     * Körönként csökkenti a hatás időtartamát úgy,
     * hogy az abstract ősosztály időtartam függvényét csökkenti mindig eggyel;
     */
    public void lep() {
        //System.out.println("Benitottsag.lep() -> Bénítottság hatás léptetése.");
        int ido = getIdotartam();
        setIdotartam(ido--);
    }

    /**
     * Megatehetetlenné teszi a virológust, a felszereléseit és az anyagait el lehet venni tőle.
     * @param v Ez a virológus lesz magetehetetlen.
     */
    public void hatas (Virologus v) {
        // Virológus körének vége
        //System.out.println("Benitottsag.hatas() -> Benitottsag hatasa.");

    }
}
