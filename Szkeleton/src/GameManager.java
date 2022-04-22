import java.util.ArrayList;

public class GameManager implements Leptetheto {
    /**
     * Csak tesztelés céljából (determinisztukus teszteléshez):
     */
    public static boolean rand = true;
    public static boolean kopeny_elfogad = false;
    private int kodok;

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

    public GameManager(int kodokszama) {
        this.kodok = kodokszama;
        this.virologusok  = new ArrayList<>();
        this.mezok = new ArrayList<>();
        soros = 0;

        virologusok.add(new Virologus(new Ures(), new Anyag(0, 0), 40));
        virologusok.get(0).setUserName("Guszti");
        mezok.add(new Ures());
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
        // a soron kovetkezo virologus lep.
        if(virologusok.size()-1 > soros){

        }

    }

    /**
     * A játék elején legenerálja a pályát.
     */
    public void palya_generalas() {
        System.out.println("GameManager.palya_generalas() -> Palya generalva.");
    }

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
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame() {
        palya_generalas();
        System.out.println("GameManager.startGame() -> Jatek inditasa.");
    }
}
