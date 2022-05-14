import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class View extends JFrame implements Serializable {

    private Controller controller;
    private JButton JbStart, JbLoad, JbAdd, JbSave;
    private JPanel JpTextInput, JpAdd, JpStart, JpLoad;
    private JPanel JGamePanel, JPanelNorth, JPanelEast, JPanelWest, JPanelCenter;
    private JTextField JtNameInput;


    public View(Controller controller){ this.controller = controller; }

    /**
     * Új játékos felvétele listener.
     */
    class UjJatekosListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            controller.ujJatekos(JtNameInput.getText());
            JtNameInput.setText("");
        }
    }

    private void GamePanelInit(){
        JpTextInput.setVisible(false);
        JpAdd.setVisible(false);
        JpStart.setVisible(false);
        JpLoad.setVisible(false);
        JGamePanel = new JPanel();
        setSize(600, 600);
        JMenu menu;
        JMenuItem JMenuItemSave, JMenuItemExit;
        JMenuBar mb = new JMenuBar();
        menu = new JMenu("Menu");
        JMenuItemSave = new JMenuItem("Save");
        JMenuItemExit = new JMenuItem("Exit");
        menu.add(JMenuItemSave);
        menu.add(JMenuItemExit);
        mb.add(menu);
        setJMenuBar(mb);
        JPanelNorth = new JPanel();
        JPanelEast = new JPanel();
        JPanelWest = new JPanel();
        JPanelCenter = new JPanel();

    }

    //Javítandó
    class StartGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            controller.startGame();
            GamePanelInit();
        }
    }



    class LoadGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                controller.load();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    class SaveGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            controller.ment();
        }
    }


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
        try { initialize(); }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }


    private void initialize() throws IOException, ClassNotFoundException {
        //TODO: Visszarakni a Start fg-be
        //TODO név bekérése
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("StartGame");
        setSize(600, 240);
        setLocationRelativeTo(null);
        setFocusable(true);
        setResizable(false);
        GridLayout a = new GridLayout(4, 3);
        setLayout(a);
        JpTextInput = new JPanel();
        JpAdd = new JPanel();
        JpStart = new JPanel();
        JpLoad = new JPanel();

        add(JpTextInput);
        add(JpAdd);
        add(JpStart);
        add(JpLoad);
        JpTextInput.add(new JLabel("Új játékos neve:"));
        JbAdd = new JButton();
        JbAdd.setText("Hozzáad");
        JbStart = new JButton();
        JbStart.setText("Start");
        JbLoad = new JButton();
        JbLoad.setText("Előző játék betöltése");
        JbSave = new JButton();
        JbSave.setText("Játék mentése");
        JtNameInput = new JTextField(16);

        JpStart.add(JbStart);
        JpLoad.add(JbLoad);
        JpTextInput.add(JtNameInput);
        JpAdd.add(JbAdd);
       // Startpanel1.add(JbSave);


        JbStart.addActionListener(new StartGameListener());
        JbLoad.addActionListener(new LoadGameListener());
        JbAdd.addActionListener(new UjJatekosListener());
       // JbSave.addActionListener(new SaveGameListener());

        setVisible(true);
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
