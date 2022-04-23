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
        setIdotartam(getIdotartam()-1);
        //System.out.println("Vedettseg.lep() ->Védettség hatás léptetése.");
    }

    /**
     * Védett lesz a virológus az ágensekkel szemben.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas(Virologus v) {
        for(int i = 0; i < v.getRakenve().size(); i++){
            if(!v.getRakenve().get(i).getKenve()){
                v.getRakenve().remove(v.getRakenve().get(i));
            }
        }

    }

    @Override
    public String toString() {
        return "Vedettseg";
    }
}
