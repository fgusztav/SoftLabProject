import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

public class View extends JFrame implements Serializable {

    private Controller controller;
    private JButton JbStart, JbLoad, JbAdd, JbSave;

    private JList JlKod, JlHatas,JlAgens, JlFelszereles, JlAnyag;
    private DefaultListModel<String> kodmodell, hatasmodell, agensmodell, felszerelesmodell, anyagmodell;
    private JButton JbAgensL, JbKenes, JbLepes;
    private JPanel JpTextInput, JpAdd, JpStart, JpLoad;

    private JPanel JPanelNorth, JPanelEast, JPanelWest, JPanelCenter;
    private JTextField JtNameInput;


    private JButton JBujjatek;
    private JPanel JPuj, JPnyertes, JPGameend;


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
        setSize(600, 600);
        JButton JMenuItemSave, JMenuItemExit;
        JMenuBar mb = new JMenuBar();
        JMenuItemSave = new JButton("Save");
        JMenuItemExit = new JButton("Exit");
        mb.add(JMenuItemExit);
        mb.add(JMenuItemSave);
        setJMenuBar(mb);
        setLayout(new GridLayout(3, 20));
        JPanelNorth = new JPanel();
        JPanelEast = new JPanel();
        JPanelWest = new JPanel();
        JPanelCenter = new JPanel();


        add(JPanelCenter);
        add(JPanelEast);
        add(JPanelWest);
        add(JPanelNorth);

       kodmodell = new DefaultListModel<String>();
        if(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getIsmert_hatasok().size()>0) {
            kodmodell.remove(0);
            for(int i=0; i<(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getIsmert_hatasok().size());++i)
            kodmodell.addElement(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getIsmert_hatasok().get(i).toString());
        } else {kodmodell.addElement("Nincs még ismert kód");}

        JlKod  = new JList<>(kodmodell);
        JPanelEast.add(JlKod,BorderLayout.NORTH);

        hatasmodell = new DefaultListModel<String>();
        if(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getRakenve().size()>0) {
            hatasmodell.remove(0);
            for(int i=0; i<(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getRakenve().size());++i)
                hatasmodell.addElement(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getRakenve().get(i).toString());
        } else {hatasmodell.addElement("Nincs aktív hatás");}

        JlHatas  = new JList<>(hatasmodell);
        JPanelEast.add(JlHatas,BorderLayout.CENTER);

        felszerelesmodell = new DefaultListModel<String>();
        if(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getFelszereles().size()>0) {
            felszerelesmodell.remove(0);
            for(int i=0; i<(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getFelszereles().size());++i)
                felszerelesmodell.addElement(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getFelszereles().get(i).toString());
        } else {felszerelesmodell.addElement("Nincs felszerelés");}

        JlFelszereles  = new JList<>(felszerelesmodell);
        JPanelEast.add(JlFelszereles,BorderLayout.SOUTH);

        agensmodell = new DefaultListModel<String>();
        if(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getAgens().size()>0) {
            agensmodell.remove(0);
            for(int i=0; i<(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getAgens().size());++i)
                agensmodell.addElement(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getAgens().get(i).toString());
        } else {agensmodell.addElement("Nincs felszerelés");}

        JlAgens  = new JList<>(agensmodell);
        JPanelWest.add(JlAgens,BorderLayout.NORTH);

        anyagmodell = new DefaultListModel<String>();
        if(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getTarolo()!=null)
        {   anyagmodell.remove(0);
            anyagmodell.addElement(controller.gameManager.getVirologusok().get(controller.gameManager.getSoros()).getTarolo().toString());
        } else {anyagmodell.addElement("Nincs anyag a tárolóban");}

        JlAnyag  = new JList<>(anyagmodell);
        JPanelWest.add(JlAnyag,BorderLayout.CENTER);

        JbAgensL = new JButton();
        JbAgensL.setText("Ágens létrehozása");
        JbKenes = new JButton();
        JbKenes.setText("Kenés");
        JbLepes = new JButton();
        JbLepes.setText("Lépés");

        JPanelCenter.add(JbAgensL);
        JPanelCenter.add(JbKenes);
        JPanelCenter.add(JbLepes);

        JbAgensL.addActionListener(new AgensLListener());
        JbLepes.addActionListener(new LepesListener());
        JbKenes.addActionListener(new KenesListener());

        JMenuItemExit.addActionListener(new ExitGameListener());
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
     * Ágens létrehozása listener.
     */
    class AgensLListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

        }
    }
    /**
     * Ágens létrehozása listener.
     */
    class ExitGameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }
    /**
     * Kenes listener.
     */
    class KenesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

        }
    }
    /**
     * Lepes listener.
     */
    class LepesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

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
    void frissit()
    {
        //Ujraervenyesitjuk es ujra kirajzoljuk
        this.revalidate();
        this.repaint();

    }

    /**
     * Kiírja a játék befejezésével járó információkat (helyezések, nyertes stb…)
     */
    void gameOver() {
        JPanelNorth.setVisible(false);
        JPanelEast.setVisible(false);
        JPanelWest.setVisible(false);
        JPanelCenter.setVisible(false);


        setSize(600, 600);
        setLayout(new GridLayout(3, 3));
        JPnyertes = new JPanel();
        JPGameend = new JPanel();
        JPuj = new JPanel();

        JBujjatek = new JButton();
        JBujjatek.setText("Új játék");

        add(JPuj);
        JPGameend.add(new Label("Game end"));
        //TODO:  a nyertes játékosnak itt keressem meg a nevét?
        JPnyertes.add(new JLabel("Nyertes játékos neve:"));

        JPuj.add(JBujjatek);



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
        //TODO hibakezelés, ha név nélkül indítjuk a játékot
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("StartGame");
        setSize(600, 240);
        setLocationRelativeTo(null);
        setFocusable(true);
        setResizable(false);
        setLayout(new GridLayout(4, 3));
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
