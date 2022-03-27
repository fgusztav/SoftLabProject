import java.util.List;
import java.util.Random;

public class Vitustanc extends Agens{

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Vitustanc hatas leptetese.");
    }

    /**
     * Vítustáncra kényszerít egy virológust.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas (Virologus v) {
        List<Mezo> mezok = v.getMezo().getMezok();
        int rnd = new Random().nextInt(mezok.size());
        Mezo lep = mezok.get(rnd);
        v.mozgas(lep);
        System.out.println("Vitustanc hatasa.");
    }
}
