import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A virológus a karakter amit a játékos mozgat. Tárolja, hogy melyik mezőn
 * van éppen. Fel tud venni és le tud adni valamint lophat is védőfelszerelést és
 * anyagokat. Meg tud tanulni Hatásokat azaz kódokat. Minden körben lép. És le tud
 * bénulni ilyenkor nem mozog és a nála lévő anyagok elvehetőek.
 */
public class Virologus implements Serializable, Leptetheto {
    private Mezo mezo;
    private Anyag tarolo;
    private List<Kod> ismert_hatasok = new ArrayList<>();
    private List<Agens> rakenve = new ArrayList<>();
    private List<Agens> agens = new ArrayList<>();
    private List<Felszereles> felszereles = new ArrayList<>();
    private String userName;
    private boolean halott = false;
    private boolean benult = false;

    //A virológus max anyag tárolási kapacitása (minden fajta anyagból külön-külön ugyanannyi) zsák kapacitását nem számolva:
    private int maxAnyag = 20; //Külön-külön limit a két anyagtípusra


    /**
     * Getterek-Setterek
     *
     * @return
     */
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Mezo getMezo() {return mezo; }
    public void setMezo(Mezo mezo) {this.mezo = mezo; }

    public Anyag getTarolo() {return tarolo; }
    public void setTarolo(Anyag tarolo) {this.tarolo = tarolo; }

    public int getMaxAnyag() {return maxAnyag; }
    public void setMaxAnyag(int maxAnyag) {this.maxAnyag = maxAnyag; }

    public boolean isBenult() {return benult;}
    public void setBenult(boolean benult) {this.benult = benult;}

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
     *
     * @param mezo   Aktuális mező ahol a virológus tartózkodik.
     * @param tarolo A virológus által eltárolt anyag (nukleotid és aminosav).
     */

    public Virologus(Mezo mezo, Anyag tarolo) {
        this.mezo = mezo;
        this.tarolo = tarolo;
    }

    /**
     * A cél virológusra felkeni a kiválasztott ágenst.
     *
     * @param cel Virologus akit kennek.
     * @param a   Ágens, amivel kennek.
     */
    public void kenes(Virologus cel, Agens a) {
        agens.remove(a);

        if (a != null) {
            cel.megkenve(a);
        }
    }

    /**
     * Ha az adott virológust megkenik, akkor ez a függvény hívodik meg, és az adott ágens bekerül a "rakenve" listájába.
     *
     * @param a Az ágens, amivel kenték a virológust.
     */
    public void megkenve(Agens a) {
        rakenve.add(a);
        a.setVirologus(this);

        for (int i = 0; i < felszereles.size(); i++) {
            if (!getFelszereles().get(i).isAktiv()) {
                getFelszereles().get(i).felszerelesHatas(a.getVirologus(), this, a);
            }
        }
    }

    /**
     * új kódot ismer meg a virológus
     *
     * @param k Letapogatott kód.
     */
    public void kod_hozzaad(Kod k) {
        ismert_hatasok.add(k);
        //System.out.println("Virologus. kod_hozzaad() ->Uj kod hozzaadva.");
    }

    /**
     * Új felszerelést vesz fel.
     *
     * @param f Felvett felszerelés.
     */
    public void felszereles_hozzaad(Felszereles f) {
        felszereles.add(f);
        //System.out.println("Virologus.felszereles_hozzaad() -> Uj felszereles hozzaad.");
    }

    /**
     * A virológus leadja a felszerelést.
     *
     * @param f Leadott felszerelés.
     */
    public void felszereles_leadas(Felszereles f) {
        //System.out.println("Virologus.felszereles_leadas() -> Felszereles leadva.");
        felszereles.remove(f);
        mezo.getFelszerelesek().add(f);
    }

    /**
     * A virológus új mezőre ugrik.
     *
     * @param m Az a mező, amelyre a virológust áthelyezzük.
     */
    public void mozgas(Mezo m) {
        //System.out.println("Virologus.mozgas() -> Virologus elmozdul");
        mezo.eltavolit(this);
        m.elfogad(this);
        mezo = m;
    }

    /**
     * A léptethető függvénye, minden körben lép a virológus/körönként meghívjuk.
     */
    public void lep() {
        for (int i = 0; i < rakenve.size(); i++) {
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
        if (getTarolo().getAminosav() <= maxAnyag || getTarolo().getNukleotid() <= maxAnyag) {//TODO: ezt a szamolast ellenorizni papiron Xd
            Anyag kulonbseg = new Anyag(maxAnyag - getTarolo().getNukleotid() - getMezo().getTarolo().getNukleotid(),
                    maxAnyag - getTarolo().getAminosav() - getMezo().getTarolo().getAminosav());
            getTarolo().increase(getMezo().getTarolo());
            getTarolo().increase(kulonbseg);
        }
    }

    /**
     * Visszaadja, hogy megvehető-e az ágens.
     * * @param k Kód, amelynek az árát ellenőrizzük.
     * * @return Megvehető-e az ágens (true/false).
     */
    public boolean check_ar(Kod k) {
        if (tarolo.getAminosav() >= k.getAr().getAminosav() && tarolo.getNukleotid() >= k.getAr().getAminosav()) {
            return true;
        }
        return false;
    }

    /**
     * Ismert kódok (ismert_hatasok lista) alapján lérehozunk egy ágenst, a megfelelő anyagmennyiséget felhasználva.
     *
     * @param k Kód, amelyből ágenst szeretnénk lélrehozni.
     */
    public void agens_letrehoz(Kod k) {
        if(check_ar(k)) {
            Anyag ujTarolo = new Anyag(tarolo.getNukleotid()-k.getAr().getNukleotid(),
                    tarolo.getAminosav()-k.getAr().getAminosav());
            agens.add(k.letrehoz());
            setTarolo(ujTarolo);
        }
        else{
            System.out.println("Nincs eleg anyag az agens elkeszitesehez.");
        }
    }

    /**
     * Egy adott virológus és zsákja anyagtároló kapacitása szerint a lehető maximális anyagmennyiséggel megtölti annak tárolóit,
     * a saját anyagmennyiséget annyival csökkentve (bénultság esetén lopásnál).
     *
     * @param v Virológus, aki megkapja az anyagot.
     */
    public void megtolt_tarolo(Virologus v) {
        //TODO: Kell e ilyen ha van anyag_felvesz()
        System.out.println("Virologus.megtolt_tarolo() -> Tarolo megtoltve.");
    }

    /**
     * Átállítja halottra az áldozat virológust.
     *
     * @param v
     */
    public void megol(Virologus v) {
        v.setHalott(true);
        for (int i = 0; i < v.getFelszereles().size(); i++) {
            v.felszereles_leadas(v.getFelszereles().get(i));
        }
        v.getIsmert_hatasok().clear();
        v.getAgens().clear();
        v.getMezo().getTarolo().increase(v.getTarolo());
        v.setTarolo(new Anyag(0, 0));

        //TODO: GameManager feladatai ezzel kapcsolatban: Elmenti az áldozat virológus pontszámát (játék végére), majd törli a játékosok listájából
    }

    @Override
    public String toString() {

        String mezo = "Mezo: " + Main.gm.getMezok() +getMezo()+ " \n"; //TODO: nem tudom, hogy kérjem le az
        // indexét a virologus mezojenek elvileg a Main.gm.getMezok()-keresztül kéne
        String anyag = "Aminosav: " + getTarolo().getAminosav() + " Nukleotid: " + getTarolo().getNukleotid() + "\n";

        StringBuilder hatas_lista = new StringBuilder();
        if (getIsmert_hatasok().size() > 0) {
            hatas_lista.append("Ismert hatasok:\n");
            hatas_lista.append(getIsmert_hatasok().get(0));
            Kod k;
            for (int i = 1; i < getIsmert_hatasok().size(); i++) {
                k = getIsmert_hatasok().get(i);
                hatas_lista.append(", " + k.toString());
            }
            hatas_lista.append("\n");
        }
            StringBuilder kenve_lista = new StringBuilder();
            if (getRakenve().size() > 0) {
                kenve_lista.append("Rakenve:\n");
                kenve_lista.append(getRakenve().get(0));
                Agens a;
                for (int i = 1; i < getRakenve().size(); i++) {
                    a = getRakenve().get(i);
                    kenve_lista.append(", " + a.toString());
                }
                kenve_lista.append("\n");
            }
            StringBuilder agens_lista = new StringBuilder();
            if (getAgens().size() > 0) {
                agens_lista.append("Agensek:\n");
                agens_lista.append(getAgens().get(0));
                Agens a;
                for (int i = 1; i < getAgens().size(); i++) {
                    a = getAgens().get(i);
                    agens_lista.append(", " + a.toString());
                }
                agens_lista.append("\n");
            }

            StringBuilder felsz_lista = new StringBuilder();
            if (getFelszereles().size() > 0) {
                felsz_lista.append("Felszerelesek:\n");
                felsz_lista.append(getFelszereles().get(0)+ " " + getFelszereles().get(0).getLejarat());
                Felszereles f;
                for (int i = 1; i < getFelszereles().size(); i++) {
                    f = getFelszereles().get(i);
                    felsz_lista.append(", " + f.toString() + " " + f.getLejarat());
                }
                felsz_lista.append("\n");
            }
            String usernam = "Felhasznalonev: " + getUserName() + " \n";
            String halott = "Halott: " + isHalott() + "\n";
            return usernam +mezo + anyag + felsz_lista.toString() + hatas_lista.toString() + agens_lista.toString() + kenve_lista.toString()  + halott;

        }

    }



