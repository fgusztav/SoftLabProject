public class Vedettseg extends Agens {

    public Vedettseg (Virologus v){
        setIdotartam(3);
        setKenve(false);
        setVirologus(v);
    }

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Vedettseg.lep() ->Védettség hatás léptetése.");
    }

    /**
     * Védett lesz a virológus az ágensekkel szemben.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas(Virologus v) {
        v.getRakenve().clear();
        System.out.println("Vedettseg.hatas() ->Vedettseg hatasa.");
    }

    @Override
    public String toString() {
        return "Vedettseg";
    }
}
