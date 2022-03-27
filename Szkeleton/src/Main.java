public class Main {

    public static void Ures2Ures (){
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0,0), 10);
        v1.mozgas(u2);
    }

    public static void AnyagfelvetelRaktarbol() {
        Ures u = new Ures();
        Virologus v2 = new Virologus(u, new Anyag(0,0), 10);
        Raktar r = new Raktar(new Anyag(0, 0), false);
        v2.mozgas(r);
        v2.anyag_felvesz();
    }

    public static void AnyagfelvetelBenultJatekostol(){
        Kesztyu k = new Kesztyu();
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0,0 ), 10);
        Virologus v2 = new Virologus(u2, new Anyag(0,0 ), 10);
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

    public static void AmneziaLetapogatas(){
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





    }



}
