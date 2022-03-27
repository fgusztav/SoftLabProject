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
        System.out.println("Vitustanc hatasa.");
    }
}
