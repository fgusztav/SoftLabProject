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
    private List<Kod> ismert_hatasok = new ArrayList<>();
    private List<Agens> rakenve = new ArrayList<>();
    private List<Agens> agens = new ArrayList<>();
    private List<Felszereles> felszereles= new ArrayList<>();
    private String userName;
    private boolean halott = false;

    //A virológus max anyag tárolási kapacitása (minden fajta anyagból külön-külön ugyanannyi) zsák kapacitását nem számolva:
    private int maxAnyag = 20; //Külön-külön limit a két anyagtípusra


    //Getterek-setterek:
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Mezo getMezo() {return mezo; }
    public void setMezo(Mezo mezo) {this.mezo = mezo; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }

    public List<Felszereles> getFelszereles() {return felszereles; }
    public List<Agens> getRakenve(){return rakenve;}

    public List<Agens> getAgens() {
        return agens;
    }
    public void setAgens(List<Agens> agens) {
        this.agens = agens;
    }

    public List<Kod> getIsmert_hatasok() { return ismert_hatasok; }
    public void setIsmert_hatasok(List<Kod> ismert_hatasok) { this.ismert_hatasok = ismert_hatasok; }

    public boolean isHalott() {return halott;}
    public void setHalott(boolean halott) {this.halott = halott;}

    /**
     * Virológus osztály konstruktora.
     * @param mezo Aktuális mező ahol a virológus tartózkodik.
     * @param tarolo A virológus által eltárolt anyag (nukleotid és aminosav).
     */

    public Virologus(Mezo mezo, Anyag tarolo) {
        this.mezo = mezo;
        this.tarolo = tarolo;
    }

    /**
     * A cél virológusra felkeni a kiválasztott ágenst.
     * @param cel Virologus akit kennek.
     * @param a Ágens, amivel kennek.
     */
    public void kenes(Virologus cel, Agens a) {
        //System.out.println("Virologus.kenes() -> Kenes.");
        agens.remove(a);

        if (a != null) {
            cel.megkenve(a);
        }
    }

    /**
     * Ha az adott virológust megkenik, akkor ez a függvény hívodik meg, és az adott ágens bekerül a "rakenve" listájába.
     * @param a Az ágens, amivel kenték a virológust.
     */
    public void megkenve(Agens a) {
        rakenve.add(a);

        for(int i = 0; i < felszereles.size();i++) {
            if (!getFelszereles().get(i).isAktiv()) {
                getFelszereles().get(i).felszerelesHatas(a.getVirologus(),this,a);
            }
        }

        //System.out.println("Virologus.megkenve() ->A kent hatasa hozzaadva.");
    }

    /**
     * új kódot ismer meg a virológus
     * @param k Letapogatott kód.
     */
    public void kod_hozzaad(Kod k) {
        ismert_hatasok.add(k);
        //System.out.println("Virologus. kod_hozzaad() ->Uj kod hozzaadva.");
    }

    /**
     * Új felszerelést vesz fel.
     * @param f Felvett felszerelés.
     */
    public void felszereles_hozzaad(Felszereles f) {
        felszereles.add(f);
        //System.out.println("Virologus.felszereles_hozzaad() -> Uj felszereles hozzaad.");
    }

    /**
     * A virológus leadja a felszerelést.
     * @param f Leadott felszerelés.
     */
    public void felszereles_leadas(Felszereles f) {
        //System.out.println("Virologus.felszereles_leadas() -> Felszereles leadva.");
        felszereles.remove(f);
        mezo.getFelszerelesek().add(f);
    }

    /**
     * A virológus új mezőre ugrik.
     * @param m Az a mező, amelyre a virológust áthelyezzük.
     */
    public void mozgas(Mezo m) {
        //System.out.println("Virologus.mozgas() -> Virologus elmozdul");
        mezo.eltavolit(this);
        m.elfogad(this);
        mezo = m;
    }

    /**
     *  A léptethető függvénye, minden körben lép a virológus/körönként meghívjuk.
     */
    public void lep() {
        //System.out.println("Virologus.lep() -> Virologus leptetese.");
        for (int i = 0; i < rakenve.size(); i++){
            rakenve.get(i).lep();
        }
        for (int i = 0; i < rakenve.size(); i++) {
            rakenve.get(i).hatas(this);
        }
    }

    /**
     * Felvesz anyagot a mezőről (amennyit tud)
     * Minden lépéskor meghívódik
     */
    public void anyag_felvesz() {
        //System.out.println("Virologus.anyag_felvesz() -> Anyag felveve");
        //((Raktar)mezo).getTarolo();
        //nem kellett mert nem hasznaltuk meg Szkeletonban
        if (getTarolo().getAminosav() <= maxAnyag || getTarolo().getNukleotid() <= maxAnyag) {//TODO: ezt a szamolast ellenorizni papiron Xd
            Anyag kulonbseg = new Anyag(maxAnyag-getTarolo().getNukleotid()-getMezo().getTarolo().getNukleotid(),
                    maxAnyag-getTarolo().getAminosav()-getMezo().getTarolo().getAminosav());
            getTarolo().increase(getMezo().getTarolo());
            getTarolo().increase(kulonbseg);
        }
    }

    /**
     * Visszaadja, hogy megvehető-e az ágens.
     * @param k Kód, amelynek az árát ellenőrizzük.
     * @return Megvehető-e az ágens (true/false).
     */
    public boolean check_ar(Kod k) {
        //System.out.println("Virologus.check_ar() -> Ar leellenorizve.");
        if (tarolo.getAminosav() >= k.getAr().getAminosav() && tarolo.getNukleotid() >= k.getAr().getAminosav()){
            return true;
        }
        return false;
    }

    /**
     * Ismert kódok (ismert_hatasok lista) alapján lérehozunk egy ágenst, a megfelelő anyagmennyiséget felhasználva.
     * @param k Kód, amelyből ágenst szeretnénk lélrehozni.
     */
    public void agens_letrehoz(Kod k) {
        Anyag ujTarolo = new Anyag(tarolo.getNukleotid()-k.getAr().getNukleotid(),tarolo.getAminosav()-k.getAr().getAminosav());

        if(check_ar(k)) {
            k.letrehoz();
            setTarolo(ujTarolo);
        }

    }

    /**
     * Egy adott virológus és zsákja anyagtároló kapacitása szerint a lehető maximális anyagmennyiséggel megtölti annak tárolóit,
     * a saját anyagmennyiséget annyival csökkentve (bénultság esetén lopásnál).
     * @param v Virológus, aki megkapja az anyagot.
     */
    public void megtolt_tarolo(Virologus v) {
        //TODO: Kell e ilyen ha van anyag_felvesz()
        System.out.println("Virologus.megtolt_tarolo() -> Tarolo megtoltve.");
    }

    /**
     * Átállítja halottra az áldozat virológust.
     * @param v
     */
    public void megol(Virologus v){
        v.setHalott(true);
        //TODO: GameManager feladatai ezzel kapcsolatban: Elmenti az áldozat virológus pontszámát (játék végére), majd törli a játékosok listájából
    }

    @Override
    public String toString() {
        return "Virologus{" +
                "mezo=" + mezo +
                ", tarolo=" + tarolo +
                ", maxAnyag=" + maxAnyag +
                ", ismert_hatasok=" + ismert_hatasok +
                ", rakenve=" + rakenve +
                ", agens=" + agens +
                ", felszereles=" + felszereles +
                ", userName='" + userName + '\'' +
                ", halott=" + halott +
                '}';
    }
}
