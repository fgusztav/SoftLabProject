import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String leironyelv = new String(); //csak példaként az első parancs
        String parameter = new String(); // masodik parancs
        Leironyelv banan = new Leironyelv();

        switch (leironyelv) {
            case "create":
                banan.create(parameter);




        }
      /*  TestClass test = new TestClass();

        System.out.println("\n1. Jatek kezdes");
        System.out.println("\n2. Jatekos hozzaadsa");

        Scanner in = new Scanner(System.in);
        int num = 2;
        while (num == 2) {
            num = in.nextInt();
            switch (num) {
                case 1:
                    /**
                     *Játék kezdes
                     */
          /*          System.out.println("\nJatek kezdes.");
                    test.JatekKezdes();
                    Jatek(in, test);
                    test.JatekVege();
                    break;
                case 2:
                    System.out.println("\nUj jatekost adott hozza!");
            }
        }*/
    }

    /**
     * A játék menüje , választási lehetőségei
     *
     * @param in   -Scanner
     * @param test _teszt osztály
     */
    public static void Jatek(Scanner in, TestClass test) {
        Virologus v = new Virologus(new Ures(), new Anyag (0, 0), 10);
        boolean vege = true;
        while (vege) {
            //Kb. amiket tud majd csinálni
            System.out.println("1. Mozog");
            System.out.println("2. Keni magat");
            System.out.println("3. Keni mast");
            System.out.println("4. Vitustanc agenst csinal");
            System.out.println("5. Vege");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    //választ hogy hova lép
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
                            Vitustanc a = new Vitustanc(v);
                            test.VirMagaraAgenstKen(a);
                            break;
                        case 2:
                            Benitottsag b = new Benitottsag(v);
                            test.VirMagaraAgenstKen(b);
                            break;
                        case 3:
                            Vedettseg c = new Vedettseg(v);
                            test.VirMagaraAgenstKen(c);
                            break;
                        case 4:
                            Amnezia d = new Amnezia(v);
                            test.VirMagaraAgenstKen(d);
                            break;
                    }
                    break;
                case 3:
                    Kiiras();
                    num = in.nextInt();
                    switch (num) {
                        case 1:
                            Vitustanc a = new Vitustanc(v);
                            test.VirKenVirt(a);
                            break;
                        case 2:
                            Benitottsag b = new Benitottsag(v);
                            test.VirKenVirt(b);
                            /**
                             * Anyag felvétel bénult játékostól
                             */
                            System.out.println("\n Anyag felvétel bénult játékostól");
                            test.AnyagfelvetelBenultJatekostol();
                            break;
                        case 3:
                            Vedettseg c = new Vedettseg(v);
                            test.VirKenVirt(c);
                            break;
                        case 4:
                            Amnezia d = new Amnezia(v);
                            test.VirKenVirt(d);
                            break;
                    }
                    break;
                case 4:
                    Vitustanc_kod k = new Vitustanc_kod(v);
                    test.VitustancAgenstLetrehoz(k);
                    break;
                case 5:
                    vege = false;
                    break;
            }
            test.JatekLeptetes();
        }
    }

    public static void Kiiras() {
        System.out.println("1. Vitustanccal");
        System.out.println("2. Benitoval");
        System.out.println("3. Vedettseggel");
        System.out.println("4. Amneziaval");
    }

    public static void Kiiras2() {
        System.out.println("1. Ures mezore");
        System.out.println("2. Raktarra");
        System.out.println("3. Varosra");
        System.out.println("4. Laborra");
    }

}