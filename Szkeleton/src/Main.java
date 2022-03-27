public class Main {

    public static void Ures2Ures() {
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        v1.mozgas(u2);
    }

    public static void AnyagfelvetelRaktarbol() {
        Ures u = new Ures();
        Virologus v2 = new Virologus(u, new Anyag(0, 0), 10);
        Raktar r = new Raktar(new Anyag(0, 0), false);
        v2.mozgas(r);
        v2.anyag_felvesz();
    }

    public static void AnyagfelvetelBenultJatekostol() {
        Kesztyu k = new Kesztyu();
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        Virologus v2 = new Virologus(u2, new Anyag(0, 0), 10);
        v1.mozgas(u2);
        v2.megtolt_tarolo(v1);
        v2.felszereles_leadas(k);
        v1.felszereles_hozzaad(k);
    }

    public static void FelszerelesFelvetele() {
        Ures u = new Ures();
        Kesztyu k = new Kesztyu();
        Varos var = new Varos(k, false);
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.mozgas(var);
        v.felszereles_hozzaad(k);
    }


    public static void AmneziaLetapogatas() {
        Ures u = new Ures();
        Amnezia_kod ak = new Amnezia_kod();
        Labor l = new Labor(ak);
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.mozgas(l);
        v.kod_hozzaad(ak);
    }

    public static void JatekLeptetes() {
        GameManager gm = new GameManager(4);
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Amnezia a = new Amnezia();
        gm.lep();
        v.lep();
    }

    public static void VitustancAgenstLetrehoz(Kod k) {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.agens_letrehoz(k);
    }

    public static void VitustáncAlattLep(){
        Ures u = new Ures();
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        u.addMezo(u1);
        u.addMezo(u2);
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        Vitustanc vit = new Vitustanc();
        v.felszereles_hozzaad(k);
        v.megkenve(vit);
        vit.setVirologus(v);
        v.lep();
    }
    public static void BenitasAlattLep(){
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        Benitottsag b = new Benitottsag();
        v.megkenve(b);
        v.lep();
    }
    public static void AmneziaAlattLep(){
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        v.kod_hozzaad(new Vedettseg_kod());
        v.kod_hozzaad(new Amnezia_kod());
        Amnezia a = new Amnezia();
        v.megkenve(a);
        v.lep();
    }
    public static void VedettsegAlattLep(){
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        v.megkenve(new Vitustanc());
        v.megkenve(new Benitottsag());
        v.megkenve(new Vedettseg());
        v.lep();
    }
    public static void VirMagaraAgenstKen(Agens a) {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);

        v.kenes(v, a);
    }

    /**
     * Végig kéne mennie az összes felszerlésen (amugy a VirMagaraAgenst kennél is ) szvl ott nem gondolkodtam el ezen
     * mert nem volt a szekvenciaban, de most hirtelen nem tudom hogy kéne azt bele irni
     * vagy feltételben oda irni hogy a felszerelést csak akkor vegye figyelmbe ha a cél és aki ken az nem ugyan az
     */
    public static void VirKenVirt(Agens a) {
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        Virologus v2 = new Virologus(u2, new Anyag(0, 0), 10);

        v1.kenes(v2, a);
    }

    public static void JatekVege(){
        GameManager gm = new GameManager(4);
        gm.lep();

    }

    public static void JatekKezdes(){
        GameManager gm = new GameManager(4);
        gm.addPlayer();
        gm.startGame();

    }


    public static void main(String[] args) {


        /**
         * A virológus lép üres mezőről üres mezőre.
         */
        System.out.println("\nA virolegus lep ures mezorol ures mezore");
        Ures2Ures();

        /**
         * Anyagfelvétel raktárból.
         */
        System.out.println("\nAnyagfelvetel rakterbol");
        AnyagfelvetelRaktarbol();

        /**
         * Anyagfelvétel bénult játékostól.
         */
        System.out.println("\nAnyagfelvetel benult jatekostol");
        AnyagfelvetelBenultJatekostol();

        /**
         * Felszerelés felvétele.
         */
        System.out.println("\nFelszereles felvetele");
        FelszerelesFelvetele();

        /**
         * Kód letapogatása.
         */
        System.out.println("\nKod letapogatasa");
        AmneziaLetapogatas();

        /**
         * Játék léptetése.
         */
        System.out.println("\nJatek leptetese");
        JatekLeptetes();

/**
 * A virológus Vitustánc ágenst hoz létre.
 */
        System.out.println("\nA virológus Vitustánc ágenst hoz létre");
        Vitustanc_kod k = new Vitustanc_kod();
        VitustancAgenstLetrehoz(k);


/**
 * A virológus ágenst ken magára.
 */
        System.out.println("\nA virológus ágenst ken magára.");
        Vedettseg a = new Vedettseg();
        VirMagaraAgenstKen(a);

/**
 * A virológus ágenst ken másra.
 */
        System.out.println("\nA virológus ágenst ken másra.");
        VirKenVirt(a);


        /**
         *Játék vége
         */
        System.out.println("\nJáték Vége.");
        JatekVege();

        /**
         *Játék kezdes
         */
        System.out.println("\nJáték kezdes.");
        JatekVege();

        /**
         * Vitustanc alatt lep.
         */
        System.out.println("\nVitustanc alatt lep");
        VitustáncAlattLep();

        /**
         * Benitas alatt lep.
         */
        System.out.println("\nBenitas alatt lep");
        BenitasAlattLep();

        /**
         * Amnezia alatt lep.
         */
        System.out.println("\nAmnezia alatt lep");
        AmneziaAlattLep();

        /**
         * Vedettseg alatt lep.
         */
        System.out.println("\nVedettseg alatt lep");
        VedettsegAlattLep();







    }





}
