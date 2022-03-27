public class GameManager implements Leptetheto{
    private int kodok;

    public GameManager(int kodok) {
        this.kodok = kodok;
    }

    /**
     * Minden körben új játékost léptet.
     */
    public void lep(){
        System.out.println("GameManeger leptetes.");
        if(getScore() == 4)
            endGame();


    }

    /**
     * A játék elején legenerálja a pályát.
     */
    public void palya_generalas(){
        System.out.println("Palya generalva.");
    }

    /**
     * A játékosoktól lekérdezi a pontjaikat.
     */
    public int getScore(){

        System.out.println("Score getter.");
        return 4;
    }

    /**
     * A játék végén hivódik meg.
     */
    public void endGame(){
        System.out.println("Game over!");
    }

    /**
     * új játékost ad hozzá a játékhoz
     */
    public void addPlayer(){
        System.out.println("Uj jatekos hozzaadas.");
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame(){
        palya_generalas();

        System.out.println("Jatek inditasa.");
    }
}
