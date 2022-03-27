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
    private List<Felszereles> felszereles= new ArrayList<>();

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
     * @param a Ágens, amivel kennek.
     */
    public void kenes(Virologus cel, Agens a) {
        agens.remove(a);

        for (int i = 0; i < cel.getFelszereles().size(); i++){
        cel.getFelszereles().get(i).felszerelesHatas(cel);
        /**TODO: oké hogy itt végig megy az összes felszerelés hatás de utána még meglesz kenve
         * és lehet mar késö van de hirtelen nem tom hogy kell megoldani
            */
             }
        megkenve(a);
        a.hatas(cel);
        System.out.println("Kenes.");
    }

    /**
     * Ha az adott virológust megkenik, akkor ez a függvény hívodik meg, és az adott ágens bekerül a "rakenve" listájába.
     * @param agens Az ágens, amivel kenték a virológust.
     */
    public void megkenve(Agens agens) {
        rakenve.add(agens);
        System.out.println("A kent hatasa hozzaadva.");
    }

    /**
     * új kódot ismer meg a virológus
     * @param k Letapogatott kód.
     */
    public void kod_hozzaad(Kod k) {
        System.out.println("Uj kod hozzaadva.");
    }

    /**
     * Új felszerelést vesz fel.
     * @param f Felvett felszerelés.
     */
    public void felszereles_hozzaad(Felszereles f) {
        System.out.println("Uj felszereles hozzaad.");
    }

    /**
     * A virológus leadja a felszerelést.
     * @param f Leadott felszerelés.
     */
    public void felszereles_leadas(Felszereles f) {
        System.out.println("Felszereles leadva.");
    }

    /**
     * A virológus új mezőre ugrik.
     * @param m Az a mező, amelyre a virológust áthelyezzük.
     */
    public void mozgas(Mezo m) {
        mezo.eltavolit(this);
        m.elfogad(this);
        mezo = m;
        System.out.println("Virologus elmozdult");
    }

    /**
     *  A léptethető függvénye, minden körben lép a virológus/körönként meghívjuk.
     */
    public void lep() {
        agens.add(new Amnezia());
        for (int i = 0; i < agens.size(); i++){
            agens.get(i).lep();
        }
        System.out.println("Virologus leptetese.");
    }

    /**
     * Felvesz anyagot a raktárból (amennyit tud).
     */
    public void anyag_felvesz() {
        System.out.println("Anyag felveve");
        //((Raktar)mezo).getTarolo();
    }

    /**
     * Visszaadja, hogy megvehető-e az ágens.
     * @param k Kód, amelynek az árát ellenőrizzük.
     * @return Megvehető-e az ágens (true/false).
     */
    public boolean check_ar(Kod k) {
        System.out.println("Ar leellenorizve.");
        return true;
    }

    /**
     * Ismert kódok (ismert_hatasok lista) alapján lérehozunk egy ágenst, a megfelelő anyagmennyiséget felhasználva.
     * @param k Kód, amelyből ágenst szeretnénk lélrehozni.
     */
    public void agens_letrehoz(Kod k) {
        Anyag a = new Anyag(5, 2);
        if(check_ar(k) ){
        k.letrehoz(a);
        setTarolo(a);
        System.out.println("Agens letrehozva");}
    }

    /**
     * Egy adott virológus és zsákja anyagtároló kapacitása szerint a lehető maximális anyagmennyiséggel megtölti annak tárolóit,
     * a saját anyagmennyiséget annyival csökkentve (bénultság esetén lopásnál).
     * @param v Virológus, aki megkapja az anyagot.
     */
    public void megtolt_tarolo(Virologus v) {
        System.out.println("Tarolo megtoltve.");
    }

    //Getterek-setterek:
    public Mezo getMezo() {return mezo; }
    public void setMezo(Mezo mezo) {this.mezo = mezo; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }

    public List<Felszereles> getFelszereles() {return felszereles; }


}
