public class GameManager implements Leptetheto{
    private int kodok;

    /**
     * Minden körben új játékost léptet.
     */
    public void lep(){
        System.out.println("GameManeger léptetés.");
    }

    /**
     * A játék elején legenerálja a pályát.
     */
    public void palya_generalas(){
        System.out.println("Pálya generálva.");
    }

    /**
     * A játékosoktól lekérdezi a pontjaikat.
     */
    public void getScore(){
        System.out.println("Score getter.");
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
        System.out.println("Új játékos hozzáadás.");
    }

    /**
     * Elinditja a játékot a játékosokat elhelyezi a játéktéren.
     */
    public void startGame(){
        System.out.println("Játék indítása.");
    }
}
