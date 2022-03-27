public class Vedettseg extends Agens {


    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Védettség hatás léptetése.");
    }

    /**
     * Védett lesz a virológus az ágensekkel szemben.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas(Virologus v) {
        v.getRakenve().clear();
        System.out.println("Vedettseg hatasa.");
    }
}
