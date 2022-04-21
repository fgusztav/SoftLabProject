import java.util.List;
import java.util.Random;

public class Vitustanc extends Agens{

    public Vitustanc (Virologus v) {
        setIdotartam(3);
        setKenve(false);
        setVirologus(v);
    }

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Vitustanc.lep() ->Vitustanc hatas leptetese.");
    }

    /**
     * Vítustáncra kényszerít egy virológust.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas (Virologus v) {
        List<Mezo> mezok = v.getMezo().getSzomszedok();
        int rnd;
        if(mezok.size() > 0){

            rnd = new Random().nextInt(mezok.size());
            if(GameManager.rand == false){
                rnd = 0;
            }
            Mezo lep = mezok.get(rnd);
            v.mozgas(lep);
        }

        System.out.println("Vitustanc.hatas() ->Vitustanc hatasa.");
    }
}
