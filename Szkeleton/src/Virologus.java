import java.util.ArrayList;
import java.util.List;

/**
 * A virológus a karakter amit a játékos mozgat. Tárolja, hogy melyik mezőn
 * van éppen. Fel tud venni és le tud adni valamint lophat is védőfelszerelést és
 * anyagokat. Meg tud tanulni Hatásokat azaz kódokat. Minden körben lép. És le tud
 * bénulni ilyenkor nem mozog és a nála lévő anyagok elvehetőek.
 */
public class Virologus implements Leptetheto{
    private Mezo mezo;
    private Anyag tarolo;
    private int maxAnyag;
    private List<Kod> ismert_hatasok = new ArrayList<>();
    private List<Agens> rakenve = new ArrayList<>();
    private List<Agens> agens = new ArrayList<>();

    /**
     * Virológus osztály konstruktora.
     * @param mezo Aktuális mező ahol a virológus tartózkodik.
     * @param tarolo A virológus által eltárolt anyag (nukleotid és aminosav).
     * @param maxAnyag A virológus max anyag tárolási kapacitása (minden fajta anyagból külön-külön ugyanannyi) zsák kapacitását nem számolva.
     */
    public Virologus(Mezo mezo, Anyag tarolo, int maxAnyag) {
        this.mezo = mezo;
        this.tarolo = tarolo;
        this.maxAnyag = maxAnyag;
    }

    /**
     * A cél virológusra felkeni a kiválasztott ágenst.
     * @param cel Virologus akit kennek.
     * @param agens Ágens, amivel kennek.
     */
    public void kenes(Virologus cel, Agens agens) {

    }

    /**
     * Ha az adott virológust megkenik, akkor ez a függvény hívodik meg, és az adott ágens bekerül a "rakenve" listájába.
     * @param agens Az ágens, amivel kenték a virológust.
     */
    public void megkenve(Agens agens) {

    }

    /**
     * új kódot ismer meg a virológus
     * @param k Letapogatott kód.
     */
    public void kod_hozzaad(Kod k) {

    }

    /**
     * Új felszerelést vesz fel.
     * @param f Felvett felszerelés.
     */
    public void felszereles_hozzaad(Felszereles f) {

    }

    /**
     * A virológus leadja a felszerelést.
     * @param f Leadott felszerelés.
     */
    public void felszereles_leadas(Felszereles f) {

    }

    /**
     * A virológus új mezőre ugrik.
     * @param m Az a mező, amelyre a virológust áthelyezzük.
     */
    public void mozgas(Mezo m) {

    }

    /**
     *  A léptethető függvénye, minden körben lép a virológus/körönként meghívjuk.
     */
    public void lep() {

    }

    /**
     * Felvesz anyagot a raktárból (amennyit tud).
     */
    public void anyag_felvesz() {

    }

    /**
     * Visszaadja, hogy megvehető-e az ágens.
     * @param k Kód, amelynek az árát ellenőrizzük.
     * @return Megvehető-e az ágens (true/false).
     */
    public boolean check_ar(Kod k) {

        return false;
    }

    /**
     * Ismert kódok (ismert_hatasok lista) alapján lérehozunk egy ágenst, a megfelelő anyagmennyiséget felhasználva.
     * @param k Kód, amelyből ágenst szeretnénk lélrehozni.
     */
    public void agens_letrehoz(Kod k) {

    }

    /**
     * Egy adott virológus és zsákja anyagtároló kapacitása szerint a lehető maximális anyagmennyiséggel megtölti annak tárolóit,
     * a saját anyagmennyiséget annyival csökkentve (bénultság esetén lopásnál).
     * @param v Virológus, aki megkapja az anyagot.
     */
    public void megtolt_tarolo(Virologus v) {

    }



    //Getterek-setterek:
    public Mezo getMezo() {return mezo; }
    public void setMezo(Mezo mezo) {this.mezo = mezo; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }


}
