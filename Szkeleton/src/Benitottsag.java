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
        setIdotartam(getIdotartam()-1);
        if(getIdotartam() <= 0){
            getVirologus().getRakenve().remove(this);
        }
    }

    /**
     * Megatehetetlenné teszi a virológust, a felszereléseit és az anyagait el lehet venni tőle.
     * @param v Ez a virológus lesz magetehetetlen.
     */
    public void hatas (Virologus v) {
        //Virológus körének vége
        //System.out.println("Benitottsag.hatas() -> Benitottsag hatasa.");
        //Felszerelést leadó ciklus:
        if(getKenve()){
            for (int i = 0; i < v.getFelszereles().size(); i++) {
                Felszereles f = v.getFelszereles().get(i);
                v.getMezo().getFelszerelesek().add(f);
                v.getFelszereles().remove(f);
                f.onRemove();
            }
            v.getMezo().getTarolo().increase(v.getTarolo());
            v.setTarolo(new Anyag(0,0));
        }


        //TODO: Itt véget kéne vetni a virológus körének esetleg ha a virológusnak lenne next függvénye és a virológus ismerné a game managert.

    }

    @Override
    public String toString() {
        return "Benitottsag";
    }
}
