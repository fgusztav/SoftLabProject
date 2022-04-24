public class Anyag {
    private int nukleotid;
    private int aminosav;
    /**
     * Anyag instruktor
     */
    public Anyag(int nuk, int ami) {
        nukleotid = nuk;
        aminosav = ami;
    }

    public int getAminosav() {
        return aminosav;
    }

    public void setAminosav(int aminosav) {
        this.aminosav = aminosav;
    }

    public int getNukleotid() {
        return nukleotid;
    }

    public void setNukleotid(int nukleotid) {
        this.nukleotid = nukleotid;
    }

    /**
     * Nőveli az anyag nukleodidját és aminosavját, a megadott Anyag alapján
     * @param a
     */

    public void increase(Anyag a) {
        nukleotid += a.getNukleotid();
        aminosav += a.getAminosav();
    }

    /**
     * Csokkenti az anyag nukleodidját és aminosavját, a megadott Anyag alapján
     * @param a
     */

    public void decrease(Anyag a) {
        nukleotid -= a.getNukleotid();
        aminosav -= a.getAminosav();
    }
}
