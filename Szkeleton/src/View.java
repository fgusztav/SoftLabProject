import java.io.IOException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;

public class View extends JFrame implements Serializable {

    private JButton StartJB1, StartJB2, StartJB3;
    private JPanel Startpanel1;
    private JTextField StartNev;


    /**
     * Java Swing metódusok használatával kirajzolja az adott objektumot.
     */
    void rajzol() {

    }

    /**
     * Körönként és/vagy felhasználói input esetén változtatja a kinézetet.
     */
    void frissit() {

    }

    /**
     * Kiírja a játék befejezésével járó információkat (helyezések, nyertes stb…)
     */
    void gameOver() {

    }

    /**
     * A játék elindításával járó információkat jeleníti meg a képernyőn
     * és bekéri a szükséges inputokat (pl.: játékosok nevei).
     */
    void startGame() {
        try {
            initialize();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void initialize() throws IOException, ClassNotFoundException {
        //TODO: Vissza rakni a Start fg-be
        //TODO: elrendezés megnézése
        //TODO név bekérése
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("StartGAme");
        setSize(600, 240);
        setLocationRelativeTo(null);
        GridLayout a = new GridLayout(3, 7);
        setLayout(a);
        Startpanel1 = new JPanel();

        add(Startpanel1);
        Startpanel1.add(new JLabel("Új játékos neve:"));
        StartJB3 = new JButton();
        StartJB3.setText("hozzáad");
        StartJB1 = new JButton();
        StartJB1.setText("Start");
        StartJB2 = new JButton();
        StartJB2.setText("Elöző játék betöltése");
        StartNev = new JTextField();

        Startpanel1.add(StartJB1);
        Startpanel1.add(StartJB2);
        Startpanel1.add(StartJB3);
        Startpanel1.add(StartNev);

    }

    /**
     * A félbehagyott játékot tudunk betölteni fájlból.
     */
    void loadGame() {

    }

    /**
     * Kirajzol egy adott objektumhoz szükséges gombot, amit a felhasználó megnyomhat (JButton használatával)
     */
    void gombRajzol() {

    }

}
