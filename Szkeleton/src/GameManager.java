import java.util.ArrayList;
import java.util.Random;

public class GameManager implements Leptetheto {
    /**
     * Csak tesztelés céljából (determinisztukus teszteléshez):
     */
    public static boolean print_to_file = false;
    public static boolean rand = true;
    public static boolean kopeny_elfogad = false;
    private int kodok;
    private int jatekosszam;

    private ArrayList<Virologus> virologusok;

    public ArrayList<Virologus> getVirologusok() { return virologusok; }
    public void setVirologusok(ArrayList<Virologus> virologusok) {
        this.virologusok = virologusok;
    }

    private ArrayList<Mezo> mezok;
    public ArrayList<Mezo> getMezok() {
        return mezok;
    }
    public void setMezok(ArrayList<Mezo> mezok) {
        this.mezok = mezok;
    }

    // mindig a soros virológus van soron.
    private int soros;
    public String getSoros(){
        return virologusok.get(soros).getUserName();
    }

    public GameManager(int kodokszama) {
        this.kodok = kodokszama;
        this.virologusok  = new ArrayList<>();
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
        //System.out.println("GameManager.lep() -> GameManeger leptetes.");
        for (int i = 0; i < virologusok.size(); i++) {
            if (getScore(virologusok.get(i)) == 4)
                endGame();
        }
        // a soron kovetkezo virologus lep. Ha a virológusok lista végére értünk kezdjük elolrol.

        virologusok.get(soros).lep();
        if(virologusok.size()-1 == soros){
            soros = 0;
        }
        else {
            soros++;
        }
    }

    /**
     * A játék elején legenerálja a pályát.
     * Úgy függ a játékosok számától a pálya,hogy mindig 4x több mezőelem jön létre,
     * mint ahány játékos játszik.
     * Úgy döntődik el, hogy milyen típusú mező jön létre, hogy a mezők listában
     * létrejövő új mező indexének oszthatóságát vizsgáljuk, Így Üres mezőből
     * keletkezik a legtöbb, aztán raktár, labor és város, legkevesebb pedig óvóhelyből.
     */
    public void palya_generalas(int jatekosok)
    {
        if(!GameManager.rand) { //Random ki van kapcsolva
            mezok = new ArrayList<>();

            for (int j = 0; j < (4 * jatekosok); ++j) {

                if (j % 2 == 0) {
                    Mezo m = new Raktar();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));

                } else if (j % 3 == 0) {
                    Mezo m1 = new Labor();
                    mezok.add(m1);
                    for (int k = 0; k < mezok.size(); ++k)
                        m1.setSzomszedok(mezok.get(k));

                    Mezo m2 = new Varos();
                    mezok.add(m2);
                    for (int k = 0; k < mezok.size(); ++k)
                        m2.setSzomszedok(mezok.get(k));

                } else if (j % 4 == 0) {
                    Mezo m = new Ovohely();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));

                } else {
                    Mezo m = new Ures();
                    mezok.add(m);
                    for (int k = 0; k < mezok.size(); ++k)
                        m.setSzomszedok(mezok.get(k));
                    }
            }
        }else { //Random be van kapcsolva
            mezok = new ArrayList<>();
            Random rando=new Random();

            for (int j = 0; j < (4 * jatekosok); ++j) {

                if (j % (rando.nextInt(5)) == 0) {
                    Mezo m = new Raktar();
                    mezok.add(m);
                    for (int k = 0; k < (rando.nextInt(mezok.size())); ++k)
                        m.setSzomszedok(mezok.get(k));

                } else if (j % (rando.nextInt(10)) == 0) {
                    Mezo m1 = new Labor();
                    mezok.add(m1);
                    for (int k = 0; k < (rando.nextInt(mezok.size())); ++k)
                        m1.setSzomszedok(mezok.get(k));

                    Mezo m2 = new Varos();
                    mezok.add(m2);
                    for (int k = 0; k < (rando.nextInt(mezok.size())); ++k)
                        m2.setSzomszedok(mezok.get(k));

                } else if (j % (rando.nextInt(10)) == 0) {
                    Mezo m = new Ovohely();
                    mezok.add(m);
                    for (int k = 0; k < (rando.nextInt(mezok.size())); ++k)
                        m.setSzomszedok(mezok.get(k));

                } else {
                    Mezo m = new Ures();
                    mezok.add(m);
                    for (int k = 0; k < (rando.nextInt(mezok.size())); ++k)
                        m.setSzomszedok(mezok.get(k));
                }
            }
        }
    }

            //System.out.println("GameManager.palya_generalas() -> Palya generalva.");



    /**
     * A játékosoktól lekérdezi a pontjaikat.
     */
    public int getScore(Virologus v) {
        //System.out.println("GameManager.getScore() -> Score getter.");
        return v.getIsmert_hatasok().size();
    }

    /**
     * A játék végén hivódik meg.
     */
    public void endGame() { //TODO: Dokumetntumban beleirni modositasokban (kimeneti nyelv!), hogy a játék végén kiírja a konzolra a játékosok pontszámát.
        //System.out.println("GameManager.endGame() -> Game over!");
        for (int i = 0; i < virologusok.size(); i++) {
            System.out.println(virologusok.get(i).getUserName()+" "+getScore(virologusok.get(i)));
        }
    }

    /**
     * új játékost ad hozzá a játékhoz
     */
    public void addPlayer(String name) {
        System.out.println("GameManager.addPlayer() -> Uj jatekos hozzaadas.");
        Virologus vir = new Virologus(mezok.get(0), new Anyag(0,0), 20);
        jatekosszam=jatekosszam+1;
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame() {
        palya_generalas(jatekosszam);
        System.out.println("GameManager.startGame() -> Jatek inditasa.");
    }
}
