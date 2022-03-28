public class GameManager implements Leptetheto {
    private int kodok;

    public GameManager(int kodok) {
        this.kodok = kodok;
    }

    /**
     * Minden körben új játékost léptet.
     */
    public void lep() {
        System.out.println("GameManager.lep() -> GameManeger leptetes.");
        if (getScore() == 4)
            endGame();
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
    public int getScore() {
        System.out.println("GameManager.getScore() -> Score getter.");
        return 3;
    }

    /**
     * A játék végén hivódik meg.
     */
    public void endGame() {
        System.out.println("GameManager.endGame() -> Game over!");
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
