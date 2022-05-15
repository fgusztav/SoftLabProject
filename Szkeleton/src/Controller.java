import java.io.*;
import java.util.ArrayList;

public class Controller {
    GameManager gameManager;

    public Controller(){
        gameManager = new GameManager();
    }
    /**
     * Meghívásával a virológust mozgatjuk egyik mezőről a másikra.
     */
    void mozgas() {

    }

    /**
     * Meghívásával egy virológust ütünk le egy a baltával, akinek ezzel a játék befejeződött.
     */
    void gyilkol() {

    }

    /**
     * Egy kiválasztott virológust helyezünk ágens hatása alá.
     */
    void ken() {

    }

    /**
     * Kimentjük a játékot egy fájlba.
     */
    void ment() {
        try {
            FileOutputStream f = new FileOutputStream("GameManager");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(gameManager);
            out.close();
        }
        catch(IOException ex) {
            System.out.println("HIBA");
        }
    }

    /**
     * Játék megkezdése.
     */
    public boolean startGame() {
        int jatekosokSzama = gameManager.getVirologusok().size();
        if (jatekosokSzama < 1) return false;
        gameManager.palya_generalas(jatekosokSzama);
        return true;
    }

    /**
     * Játék vége.
     */
    void endGame() {

    }

    /**
     * A félbehagyott játékot tudjuk betölteni egy fájlból
     */
    void load() throws FileNotFoundException {
        try {
            FileInputStream f = new FileInputStream("GameManager");
            ObjectInputStream in = new ObjectInputStream(f);
            GameManager gm = (GameManager) in.readObject();
            in.close();
            gameManager = gm;
            //Test
            System.out.println(gameManager.getVirologusok().get(0).getUserName());
        }
        catch(FileNotFoundException fe){
            throw fe;
        }
        catch(IOException | ClassNotFoundException ex) {
            System.out.println("HIBA");
            return;
        }
    }
    public void ujJatekos(String jatekos){ gameManager.addPlayer(jatekos); }

    public String getSorosNev() {
        return gameManager.getVirologusok().get(gameManager.getSoros()).getUserName();
    }
}
