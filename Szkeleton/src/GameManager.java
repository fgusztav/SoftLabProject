import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class GameManager implements Serializable, Leptetheto {
    /**
     * Csak tesztelés céljából (determinisztukus teszteléshez):
     */
    public static boolean rand = true;
    public static boolean kopeny_elfogad = false;


    private int jatekosszam;
    private ArrayList<Virologus> virologusok;

    /**
     * get -set virologus
     *
     * @return visszaadja/beállítja a játékban lévő virológusok listáját
     */
    public ArrayList<Virologus> getVirologusok() {
        return virologusok;
    }

    public void setVirologusok(ArrayList<Virologus> virologusok) {
        this.virologusok = virologusok;
    }

    private ArrayList<Mezo> mezok;
    private int soros;

    /**
     * get -set mezok lista
     *
     * @return visszaadja/beállítja a játékban lévő mezők listáját
     */
    public ArrayList<Mezo> getMezok() {
        return mezok;
    }

    public void setMezok(ArrayList<Mezo> mezok) {
        this.mezok = mezok;
    }

    /**
     * set - set soros
     * mindig ez az indexu virologus van soron:
     *
     * @return visszaadja/beállítva a játékban soron lévő virologus sorszámát
     */

    public int getSoros() {
        return soros;
    }

    public void setSoros(int soros) {
        this.soros = soros;
    }

    /**
     * GameMangaer konstruktora
     */
    public GameManager() {
        this.virologusok = new ArrayList<>();
        this.mezok = new ArrayList<>();
        soros = 0;

        /**
         virologusok.add(new Virologus(new Ures(), new Anyag(0, 0), 40));
         virologusok.get(0).setUserName("Guszti");
         mezok.add(new Ures());
         */
    }

    /**
     * Minden körben új játékost léptet.
     */
    public void lep() {
        //IFio.print("GameManager.lep() -> GameManeger leptetes.");
        checkEnd();
        // a soron kovetkezo virologus lep. Ha a virológusok lista végére értünk kezdjük elolrol.

        virologusok.get(soros).lep();
        if (virologusok.size() - 1 == soros) {
            soros = 0;
        } else {
            soros++;
        }
    }

    /**
     * * A játék elején legenerálja a pályát.
     * * Úgy függ a játékosok számától a pálya,hogy mindig 4x több mezőelem jön létre,
     * * mint ahány játékos játszik, de minimum 12.
     * * Úgy döntődik el, hogy milyen típusú mező jön létre, hogy a mezők listában
     * * létrejövő új mező indexének oszthatóságát vizsgáljuk, Így Üres mezőből
     * * keletkezik a legtöbb, aztán raktár, labor és város, legkevesebb pedig óvóhelyből.
     *
     * @param jatekosok a játékban részt vevő játékosok száma
     */
    public void palya_generalas(int jatekosok) {
        //palya minimum mérete legyen 12:
        int meret = (jatekosok <= 3) ? 12 : jatekosok * 4;
        if (!GameManager.rand) { //Random ki van kapcsolva
            mezok = new ArrayList<>();

            for (int j = 0; j < meret; ++j) {
                if (j % 3 == 0) {
                    Mezo m = new Raktar();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));

                } else if (j % 2 == 0) {
                    Mezo m1 = new Labor();
                    mezok.add(m1);
                    for (int k = 0; k < mezok.size(); ++k)
                        m1.setSzomszedok(mezok.get(k));

                    Mezo m2 = new Varos();
                    mezok.add(m2);
                    for (int k = 0; k < mezok.size(); ++k)
                        m2.setSzomszedok(mezok.get(k));

                } else {
                    Mezo m = new Ures();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));
                }
                if (j % 5 == 0) {
                    Mezo m = new Ovohely();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));

                }
            }
        } else { //Random be van kapcsolva
            mezok = new ArrayList<>();
            Random rando = new Random();

            for (int j = 0; j < meret; ++j) {
                int innen = rando.nextInt(mezok.size());
                int eddig = Integer.min(innen + rando.nextInt(mezok.size()), mezok.size() - 1) + 1;

                if (j % (rando.nextInt(4) + 1) == 0) {
                    Mezo m = new Raktar();
                    mezok.add(m);
                    for (int k = innen; k < eddig; ++k)
                        m.setSzomszedok(mezok.get(k));

                } else if (j % (rando.nextInt(4) + 1) == 0) {
                    Mezo m1 = new Labor();
                    mezok.add(m1);
                    for (int k = innen; k < eddig; ++k)
                        m1.setSzomszedok(mezok.get(k));

                    Mezo m2 = new Varos();
                    mezok.add(m2);
                    for (int k = innen; k < eddig; ++k)
                        m2.setSzomszedok(mezok.get(k));

                } else if (j % (rando.nextInt(5) + 1) == 0) {
                    Mezo m = new Ovohely();
                    mezok.add(m);
                    for (int k = innen; k < eddig; ++k)
                        m.setSzomszedok(mezok.get(k));

                } else {
                    Mezo m = new Ures();
                    mezok.add(m);
                    for (int k = innen; k < eddig; ++k)
                        m.setSzomszedok(mezok.get(k));
                }
            }
        }
    }

    /**
     * A játékosoktól lekérdezi a pontjaikat.
     *
     * @param v virologus, akinek le szeretnénk kérdezni a pontját
     * @return visszaadja a paraméterül kapott játékos pontszámát
     */

    public int getScore(Virologus v) {
        //IFio.print("GameManager.getScore() -> Score getter.");
        return v.getIsmert_hatasok().size();
    }

    /**
     * Ellenőrzi, hogy vége van-e a játéknak
     */
    public void checkEnd() {
        for (int i = 0; i < virologusok.size(); i++)
            if (getScore(virologusok.get(i)) == 4)
                endGame();
    }

    /**
     * A játék végén hívódik meg.
     */
    public void endGame() {
        IFio.print("Játéknak vége van!");
        for (int i = 0; i < virologusok.size(); i++) {
            IFio.print(virologusok.get(i).getUserName() + " " + getScore(virologusok.get(i)));
        }
    }

    /**
     * új játékost ad hozzá a játékhoz
     *
     * @param name a virologus neve, aki hozzá akarunk adni a játékhoz
     */
    public void addPlayer(String name) {
        Virologus vir = new Virologus(mezok.get(0), new Anyag(0, 0));
        jatekosszam += 1;
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame() {
        palya_generalas(jatekosszam);
        IFio.print("GameManager.startGame() -> Jatek inditasa.");
    }
}


