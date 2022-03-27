public class Benitottsag extends Agens{
    
    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Bénítottság hatás léptetése.");
    }

    /**
     * Megatehetetlenné teszi a virológust, a felszereléseit és az anyagait el lehet venni tőle.
     * @param v Ez a virológus lesz magetehetetlen.
     */
    public void hatas (Virologus v) {
        // Virológus körének vége


        System.out.println("Benitottsag hatasa.");
    }
}
