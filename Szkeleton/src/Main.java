import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TestClass test = new TestClass();

        /* *//**
         * A virológus lép üres mezőről üres mezőre.
         *//*
        System.out.println("\nA virolegus lep ures mezorol ures mezore");
        Ures2Ures();

        *//**
         * Anyagfelvétel raktárból.
         *//*
        System.out.println("\nAnyagfelvetel rakterbol");
        AnyagfelvetelRaktarbol();

        *//**
         * Anyagfelvétel bénult játékostól.
         *//*
        System.out.println("\nAnyagfelvetel benult jatekostol");
        AnyagfelvetelBenultJatekostol();

        *//**
         * Felszerelés felvétele.
         *//*
        System.out.println("\nFelszereles felvetele");
        FelszerelesFelvetele();

        *//**
         * Kód letapogatása.
         *//*
        System.out.println("\nKod letapogatasa");
        AmneziaLetapogatas();

        *//**
         * Játék léptetése.
         *//*
        System.out.println("\nJatek leptetese");
        JatekLeptetes();

*//**
         * A virológus Vitustánc ágenst hoz létre.
         *//*
        System.out.println("\nA virológus Vitustánc ágenst hoz létre");
        Vitustanc_kod k = new Vitustanc_kod();
        VitustancAgenstLetrehoz(k);


*//**
         * A virológus ágenst ken magára.
         *//*
        System.out.println("\nA virológus ágenst ken magára.");
        Vedettseg a = new Vedettseg();
        VirMagaraAgenstKen(a);

*//**
         * A virológus ágenst ken másra.
         *//*
        System.out.println("\nA virológus ágenst ken másra.");
        VirKenVirt(a);


        *//**
         *Játék vége
         *//*
        System.out.println("\nJáték Vége.");
        JatekVege();

        *//**
         *Játék kezdes
         *//*
        System.out.println("\nJáték kezdes.");
        JatekVege();

        *//**
         * Vitustanc alatt lep.
         *//*
        System.out.println("\nVitustanc alatt lep");
        VitustáncAlattLep();*/

        System.out.println("\n1 . Játék kezdés");
        System.out.println("\n2 . Játékos hozzáadása");

        Scanner in = new Scanner(System.in);
        int num = 2;
        while (num == 2) {
            num = in.nextInt();
            switch (num) {
                case 1:
/**
 *Játék kezdes
 */
                    System.out.println("\nJáték kezdes.");
                    test.JatekKezdes();
                    Jatek(num, in, test);
                    test.JatekVege();
                    break;


                case 2:
                    System.out.println("\nUj játékost adott hozzá!");
            }
        }

        /**
         * Benitas alatt lep.
         */
        System.out.println("\nBenitas alatt lep");
        test.BenitasAlattLep();

        /**
         * Amnezia alatt lep.
         */
        System.out.println("\nAmnezia alatt lep");
        test.AmneziaAlattLep();

        /**
         * Vedettseg alatt lep.
         */
        System.out.println("\nVedettseg alatt lep");
        test.VedettsegAlattLep();

        /**
         * Vitustanc alatt lep.
         */
        System.out.println("\nVítustancalatt lep");
        test.VitustáncAlattLep();


    }

    /**
     * A játék menüje , választási lehetőségei
     *
     * @param num  -beolvasott szam
     * @param in   -Scanner
     * @param test _teszt osztály
     */
    public static void Jatek(int num, Scanner in, TestClass test) {
        boolean vege = true;
        while (vege) {
            System.out.println("1 . Mozog");
            System.out.println("2 . Keni Magát");
            System.out.println("3 . Keni Mást");
            System.out.println("4 . vége");
            num = in.nextInt();
            switch (num) {
                case 1:
                    Kiiras2();
                    num = in.nextInt();
                    switch (num) {
                        case 1:
                            test.Ures2Ures();
                            break;
                        case 2:
                            test.AnyagfelvetelRaktarbol();
                            break;
                        case 3:
                            test.FelszerelesFelvetele();
                            break;
                        case 4:
                            test.AmneziaLetapogatas();
                            break;
                    }
                    break;
                case 2:
                    Kiiras();
                    num = in.nextInt();
                    switch (num) {
                        case 1:
                            Vitustanc a = new Vitustanc();
                            test.VirMagaraAgenstKen(a);
                            break;
                        case 2:
                            Benitottsag b = new Benitottsag();
                            test.VirMagaraAgenstKen(b);
                            break;
                        case 3:
                            Vedettseg c = new Vedettseg();
                            test.VirMagaraAgenstKen(c);
                            break;
                        case 4:
                            Amnezia d = new Amnezia();
                            test.VirMagaraAgenstKen(d);
                            break;
                    }
                    break;
                case 3:
                    Kiiras();
                    num = in.nextInt();
                    switch (num) {
                        case 1:
                            Vitustanc a = new Vitustanc();
                            test.VirKenVirt(a);
                            break;
                        case 2:
                            Benitottsag b = new Benitottsag();
                            test.VirKenVirt(b);
                            ;
                            break;
                        case 3:
                            Vedettseg c = new Vedettseg();
                            test.VirKenVirt(c);
                            break;
                        case 4:
                            Amnezia d = new Amnezia();
                            test.VirKenVirt(d);
                            break;
                    }
                    break;
                case 4:
                    vege = false;

                    break;


            }
            test.JatekLeptetes();

        }

    }

    //csak kirija ezeket a dolgokat
    public static void Kiiras() {
        System.out.println("1 . Vitustánccal");
        System.out.println("2. Bénitóval");
        System.out.println("3. Védettség");
        System.out.println("4 . Amnézia");
    }

    //csak kirija ezeket a dolgokat
    public static void Kiiras2() {
        System.out.println("1 . Űres mezőre");
        System.out.println("2. Raktárra");
        System.out.println("3. Városra");
        System.out.println("4 . Laborra");
    }

}
