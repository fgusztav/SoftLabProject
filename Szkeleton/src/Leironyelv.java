import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Leironyelv {
    //minden parancsra egy fv.

    public void create(String parameter) {
        boolean mezo = false;
        if (!mezo) {
            switch (parameter) {
                case "varos":
                    Varos v = new Varos();
                    mezo = true;
                case "ures":
                    Ures u = new Ures();
                    mezo = true;
                case "labor":
                    Labor l = new Labor();
                    mezo = true;
                case "raktar":
                    Raktar r = new Raktar();
                    mezo = true;
                case "ovohely":
                    Ovohely ov = new Ovohely();
                    mezo = true;
            }
        } else {
            Virologus v = new Virologus(Main.gm.getMezok().get(0), new Anyag(0, 0), 40);
            v.setUserName(parameter);
        }
    }

    public void help(String parameter) {
        switch (parameter) {
            case "":
                System.out.println("create\nhelp\ninfo\nput\nconnect\nlist\nload\nsave\nmove\nprint_to_file\ngive\nstep\ngenerate_map\nsmear_virus\nkill\nmake_agent\nrandom\nclear\ndefensivecoat\ntest:mode");
                break;
            case "create":
                System.out.println("Létrehozható ezzel a paranccsal új virológus, vagy egy adott típusú mezõ - város, labor, üres, óvóhely, raktár.");
                System.out.println("\nParaméterei: Create <virológus_neve> vagy Create <varos/ures/labor/raktar/ovohely>");
                break;
            case "help":
                System.out.println(" Információ kérhetõ egy adott parancsról, vagy kilistázható az összes parancs.");
                System.out.println("\nHelp [parancs_neve] - ahol a paraméter csak opcionális!");
                break;
            case "info":
                System.out.println("Elsõ paraméterként megadhatunk egy típust a második paraméterként a megfelelõ objektum nevét, ezután a program kilistázza az objektum információit.");
                System.out.println("\nInfo <Objektum_típusa> <Objektum_neve>");
                break;

            case "put":
                System.out.println(" Elhelyezi (“elteleportálja”) a megadott virológust egy adott mezõre, mely bárhol lehet a pályán, így a játék szokványos mûködésének részét képezõ Move parancsot megkerülve. Ezért nem a mozgás tesztelésére van (lásd: Move),\n hanem a teszthez szükséges állapot gyors létrehozására. ");
                System.out.println("\nParaméterei: Put <virologus_neve> <mezo_azonosito>");
                break;
            case "connect":
                System.out.println("Két mezõt összekapcsol, szomszédossá teszi õket.");
                System.out.println("\nParaméterei:Connect <mezõ_azonosító1> <mezõ_azonosító2>");
                break;
            case "list":
                System.out.println("Kilistázza a játékban szereplõ mezõket vagy virológusokat a megadott paraméterne megfelelõen.");
                System.out.println("\nParaméterei: List <mezok> vagy List <virologus> ");
                break;
            case "load":
                System.out.println(" Fájlbol betölt egy korábbi játék állást.");
                System.out.println("\nParaméterei: Load <fajlnev>");
                break;
            case "save":
                System.out.println("Fájlba ment egy aktuális játék állást.");
                System.out.println("\nParaméterei:Save <fajlnev>");
                break;
            case "move":
                System.out.println("Virológus mozog egy szomszédos mezõre. Error-t kell dobnia ha például a virológus bénult, vagy az adott mezõ nem szomszédos.");
                System.out.println("\nParaméterei: Move <virologus> <mezo>");
                break;
            case "print_to_file":
                System.out.println("on paraméter esetén kiírja a fájlba a konzol kimenetét, off esetén nem írja ki fájlba.");
                System.out.println("\nParaméterei:Print_to_file <on/off>");
                break;
            case "give":
                System.out.println("A megadott virológushoz adhat anyagot vagy felszerelést vagy ágenst a meghatározott mennyiségben.");
                System.out.println("\nParaméterei:Give <vir>  <nukleotid>/<aminosav>/<felszereles>/<agens>/<kod> <anyag_mennyiseg>/<felszereles_neve>/<agens_neve>/<kod_neve>\n");
                System.out.println("\nLehetséges értékei: Agens_neve vagy  kod_neve paraméterek lehetséges értékei: \nAmnezia \nBenitottsag \nVitustanc \nVedettseg \nMedvetanc (csak mint ágens, nem kód!)" +
                        " \nFelszereles_neve paraméter lehetséges értékei: \nKesztyu \nVedokopeny \nZsak \nBalta ");
                break;
            case "step":
                System.out.println(" Léptet egy megadott virológust (meghívva a lép() függvényét) vagy a játékban a soron következõ virológust lépteti, ha nincs megadva paraméter.");
                System.out.println("\nParaméterei:Step <Virologus> - paraméter csak opcionális.");
                break;
            case "generate_map":
                System.out.println("Ha a random ki van kapcsolva: A megadott játékos szám függvényében létrehoz egy pályát, ahol létrehoz adott arányban raktárat, labort, várost, óvóhelyet és a maradék mezõk pedig üres mezõk. Minden mezõt mindegyikkel összeköti. A megadott paraméter függvényében determinisztikusan hozza létre a pályát.\n" +
                        "\tHa a random be van kapcsolva: \n" +
                        "A megadott játékos szám függvényében véletlenszerûen generálja a mezõket és a mezõk egymással való szomszédságát.\n");
                System.out.println("\nParaméterei:Generate_map <int: size>");
                break;
            case "smear_virus":
                System.out.println(" Egy virológus megken egy másik virológust, vagy önmagát egy adott ágenssel.");
                System.out.println("\nParaméterei:Smear_virus <virologus_aki_ken> <virologus2> <agens_neve>");
                System.out.println("\nLehetséges értékei: Agens_neve paraméterek lehetséges értékei: \nAmnezia \nBenitottsag \nVitustanc \nVedettseg \nMedvetanc ");
                break;
            case "kill":
                System.out.println("Kettõ paramétere van, mindkettõ paraméterként egy-egy virológus nevet vár. Az elsõ virológus megöli a másikat baltával. ");
                System.out.println("\nParaméterei:Make_agent <virologus> <agens>");
                break;
            case "make_agent":
                System.out.println("Ágenst hoz létre egy adott virológus, ha ismeri a hozzá szükséges kódot és van hozzá elegendõ anyaga.");
                System.out.println("\nParaméterei:Make_agent <virologus> <agens>");
                break;
            case "random":
                System.out.println("Ki- és bekapcsolja, hogy a program random eseményeket tényleg véletlenszerû kimenetellel hajtson végre, vagy determinisztikusan minden teszteléskor ugyanazt a kimenetelt kapjuk.");
                System.out.println("\nParaméterei: Random <on/off>");
                break;
            case "clear":
                System.out.println(" Egy mezõ összes törölhetõ rajta tárolt objektumát töröljük.");
                System.out.println("\nParaméterei:Clear <mezõ_azonosító>");
                break;
            case "defensivecoat":
                System.out.println("A védõköpeny mûködése determinisztikusan állítható, hogy mindig védjen, vagy semmiképp se védje ki a másik virológus általi ágens kenést. \nEz a parancs csak akkor releváns, ha a Random off van beállítva (determinisztikus tesztelés esetén).");
                System.out.println("\nParaméterei:DefensiveCoat <on/off>");
                break;
            case "test_mode":
                System.out.println("Egy speciális parancs, amellyel a program automatikus tesztelés üzemmódba helyezhetõ");
                break;
            case "set":
                System.out.println("Mezõkre helyez felszerelést, anyagot, vagy kódot (csak laboroknál). \nHa az adott kategóriájú objektumból már van egy az adott mezõn, akkor lecseréli azt. Ha például nem laborra akarunk kódot elhelyezni akkor hibát ad vissza.");
                System.out.println("\nParaméterei:Set <mezõ_azonosítója> <típus> [objektum_neve] [mennyiség]");
                System.out.println("\nA <mezõ_azonosítója> paraméter a List mezok parancs által visszaadott kódok lehetnek.\n" +
                        "A <típus> paraméter lehetséges értékei:\n" +
                        "felszereles\n" +
                        "kod\n" +
                        "anyag\n" +
                        "medvetanc\n");
                break;
        }
    }

    public void info(String parameter) {
        String array[] = parameter.split(" ");
        if (array[0].equals("Virologus")) {
            Virologus v;
            for (Virologus vir : Main.gm.getVirologusok()) {
                if (array[1].equals(vir.getUserName())) {
                    vir.toString();
                }
            }
        } else if (array[0].equals("Mezo")) {
            //TODO:Kiiratas
        } else {
            System.out.println("Invalid parameter");
        }
    }

    public void put(String parameter) {
        String array[] = parameter.split(" ");
        String v = array[0];

        int azon = Integer.parseInt(array[1]);
        Mezo m = Main.gm.getMezok().get(azon);

        for (Virologus vir : Main.gm.getVirologusok()) {
            if (v.equals(vir.getUserName())) {
                vir.setMezo(m);
            }
        }
    }

    public void connect(String parameter) {
        String array[] = parameter.split(" ");
        Main.gm.getMezok().get(Integer.parseInt(array[0])).setSzomszedok( Main.gm.getMezok().get(Integer.parseInt(array[1])));
        Main.gm.getMezok().get(Integer.parseInt(array[1])).setSzomszedok( Main.gm.getMezok().get(Integer.parseInt(array[2])));

    }

    public void list(String parameter) {
        switch (parameter) {
            case "virologus":
                for (Virologus vir : Main.gm.getVirologusok()) {
                    System.out.println(vir.getUserName());
                }
            case "mezok:":
                for (Mezo m : Main.gm.getMezok()) {
                    int i = 1;
                    System.out.println(i + " " + m.toString());
                    i++;
                }
        }
    }

    public void load(String parameter) {

    }

    public void save(String parameter) {

    }

    public void move(String parameter) {

    }

    public void print_to_file(String parameter) {

    }

    public void give(String parameter) {
        String array[] = parameter.split(" ");
        Virologus vir;
        //TODO: bocsesz elefeljetttem hogy kell meg keresni a virologust akinvel egyezik a neve, de remélem igy:
        for (int i = 0; i < Main.gm.getVirologusok().size(); i++) {
            Virologus v = Main.gm.getVirologusok().get(i);
            String name = v.getUserName();
            if (array[0].equals(name)) {
                vir = v;
            }
        }
        boolean kod = false; //mivel az agens és kod nveei ugyan azok a segéd fuggvényél ezzel nézi meg hogy melyik kell adni neki
        ///TODO: Ha az egyik casenél már használom a vir-t a többinél azt irja nincs inicializálva (szedjétek ki a kommenteteket és latjatok)
        switch (array[1]) {

            case "nukleotid":
                //vir.setTarolo(new Anyag(Integer.parseInt(array[2]), vir.getTarolo().getAminosav()));
                break;
            case "aminosav":
                // vir.setTarolo(new Anyag(vir.getTarolo().getNukleotid(), Integer.parseInt(array[2])));
                break;
            case "felszereles":
                //give_seged_fel(array[2], vir); //segéd fg
                break;
            case "agens":
                //give_seged_agens(array[2], kod, vir); //seged fg
                break;
            case "kod":
                kod = true;

                // give_seged_agens(array[2], kod, vir);
                break;

        }

    }

    public void give_seged_fel(String param, Virologus vir) {
        switch (param) {
            case "Kesztyu":
                vir.felszereles_hozzaad(new Kesztyu());
            case "Vedokopeny":
                vir.felszereles_hozzaad(new Vedokopeny());
            case "Zsak":
                vir.felszereles_hozzaad(new Zsak());
            case "Balta":
                vir.felszereles_hozzaad(new Balta());
        }
    }

    public void give_seged_agens(String param, boolean kod, Virologus vir) {
        switch (param) {
            case "Amnezia":
                if (kod) {
                    vir.kod_hozzaad(new Amnezia_kod(vir));
                } else {
                    vir.agens_letrehoz(new Amnezia_kod(vir));
                }
            case "Benitottsag":
                if (kod) {
                    vir.kod_hozzaad(new Benitottsag_kod(vir));
                } else {
                    vir.agens_letrehoz(new Benitottsag_kod(vir));
                }
            case "Vitustanc":
                if (kod) {
                    vir.kod_hozzaad(new Vitustanc_kod(vir));
                } else {
                    vir.agens_letrehoz(new Vitustanc_kod(vir));
                }
            case "Vedettseg":
                if (kod) {
                    vir.kod_hozzaad(new Vedettseg_kod(vir));
                } else {
                    vir.agens_letrehoz(new Vedettseg_kod(vir));
                }
                //TODO: medvetancbol is van agens meg kod???
          /*  case "Medvetanc":
                if(kod) {
                    vir.kod_hozzaad(new Amnezia_kod());
                }
                else{
                    vir.agens_letrehoz(new Amnezia_kod());
                }*/
        }
    }

    public void step(String parameter) {

    }

    public void generate_map(String parameter) {

    }

    public void smear_virus(String parameter) {
        String array[] = parameter.split(" ");
        Virologus v1, v2;
        for (int i = 0; i < Main.gm.getVirologusok().size(); i++) {
            Virologus v = Main.gm.getVirologusok().get(i);
            String name = v.getUserName();
            if (array[0].equals(name)) {
                v1 = v;
            }
            if (array[1].equals(name)) {
                v2 = v;
            }
        }
        //TODO: GetType
    }

    public void kill(String parameter) {

    }

    public void make_agent(String parameter) {
        String array[] = parameter.split(" ");
        for (int i = 0; i < Main.gm.getVirologusok().size(); i++) {
            Virologus v = Main.gm.getVirologusok().get(i);
            String name = v.getUserName();
            if (array[0].equals(name)) {
                for (int j = 0; j < v.getIsmert_hatasok().size(); j++) {
                    Kod temp_hatas = v.getIsmert_hatasok().get(j);
                    if (array[1].equals(temp_hatas.toString().toLowerCase())) {
                        v.agens_letrehoz(temp_hatas);
                        return;
                    }
                }
                System.out.println("A virológus nem ismeri a szükséges kódot");
            }
        }
    }

    public void random(String parameter) {
        switch (parameter) {
            case "on":
                GameManager.rand = true;
                break;
            case "off":
                GameManager.rand = false;
                break;
            default:
                invalid_param();
                break;
        }
    }

    public void clear(String parameter) {


    }

    public void defensivecoat(String parameter) {

    }

    public void test_mode(String parameter) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println("Adja a bementi fájl nevét: ");
            String fajlbe = sc.nextLine();
            System.out.println("Adja az elvárt kimenetet taralmazó fájl nevét: ");
            String fajlki = sc.nextLine();



        }
    }

    private void minimain() {


    }

    public void set(String parameter) {
        String array[] = parameter.split(" ");
        switch (array[1]) {
            case "felszereles":
                set_felszerel(array[2], Integer.parseInt(array[0]));
            case "kod":
                set_kod(array[2],  Integer.parseInt(array[0]));
            case "anyag":
                set_anyag(array[2], array[3], Integer.parseInt(array[0]));
            case "medvetanc":
                //TODO: medvetanc
        }

    }
    public void set_anyag(String param, String mennyiseg, int index){
        switch (param){
            case "Nukleodid":
                Main.gm.getMezok().get(index).setTarolo(new Anyag(Integer.parseInt(mennyiseg),   Main.gm.getMezok().get(index).getTarolo().getAminosav() ));
                break;
            case "Aminosac":
                Main.gm.getMezok().get(index).setTarolo(new Anyag(Main.gm.getMezok().get(index).getTarolo().getNukleotid(), Integer.parseInt(mennyiseg) ));
        break;
        }

    }

    public void set_kod(String param, int index){
        //TODO: typeCheck kéne hogy Labor mezo-e mert csak ott lehet kod
        switch (param){
            case "Amnezia":
               // Main.gm.getMezok().get(index).
                break;
            case "Benitottsag":
                break;
            case "Vitustanc":
                break;
            case "Vedettseg":
                break;
        }
    }

    public void set_felszerel(String param, int index) {
        switch (param) {
            case "Kesztyu":

               Main.gm.getMezok().get(index).setFelszerelesek(new Kesztyu());
                break;
            case "Vedokopeny":
                Main.gm.getMezok().get(index).setFelszerelesek(new Vedokopeny());
                break;
            case "Zsak":
                Main.gm.getMezok().get(index).setFelszerelesek(new Zsak());
                break;
            case "Balta":
                Main.gm.getMezok().get(index).setFelszerelesek(new Balta());
                break;


        }
    }

    private void invalid_param() {
        System.out.println("Invalid parameter given");
    }


}
