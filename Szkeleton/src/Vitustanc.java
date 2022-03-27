public class Vitustanc extends Agens{

    /**
     * Körönként csökkenti a hatás időtartamát.
     */
    public void lep() {
        System.out.println("Vítustánc hatás léptetése.");
    }

    /**
     * Vítustáncra kényszerít egy virológust.
     * @param v A vítustáncra kényszerített virológus.
     */
    public void hatas (Virologus v) {
        System.out.println("Vítustánc hatása.");
    }
}
