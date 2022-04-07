import java.util.ArrayList;

public class GameManager implements Leptetheto {
    private int kodok;
    private ArrayList<Virologus> virologusok;

    public GameManager(int kodokszama) {
        this.kodok = kodokszama;
        this.virologusok  = new ArrayList<>();
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
    public void endGame() {
        //System.out.println("GameManager.endGame() -> Game over!");

    }

    /**
     * új játékost ad hozzá a játékhoz
     */
    public void addPlayer() {
        System.out.println("GameManager.addPlayer() -> Uj jatekos hozzaadas.");
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame() {
        palya_generalas();

        System.out.println("GameManager.startGame() -> Jatek inditasa.");
    }
}
