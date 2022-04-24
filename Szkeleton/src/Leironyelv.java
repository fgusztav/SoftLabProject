import java.io.*;
import java.util.Scanner;

public class Leironyelv {
    //minden parancsra egy fv.

    public void create(String parameter) {
        switch (parameter) {
            case "varos":
                Varos v = new Varos();
                Main.gm.getMezok().add(v);
                break;
            case "ures":
                Ures u = new Ures();
                Main.gm.getMezok().add(u);
                break;
            case "labor":
                Labor l = new Labor();
                Main.gm.getMezok().add(l);
                break;
            case "raktar":
                Raktar r = new Raktar();
                Main.gm.getMezok().add(r);
                break;
            case "ovohely":
                Ovohely ov = new Ovohely();
                Main.gm.getMezok().add(ov);
                break;
            default:
                Virologus vi = new Virologus(null, new Anyag(0,0));
                Main.gm.getVirologusok().add(vi);
                break;
        }
    }

    public void help(String parameter) {
        switch (parameter) {
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
            default:
                System.out.println("Parancsok:\ncreate\nhelp\ninfo\nput\nconnect\nlist\nload\nsave\nmove\nprint_to_file\ngive\nstep\ngenerate_map\nsmear_virus\nkill\nmake_agent\nrandom\nclear\ndefensivecoat\ntest:mode\nTöbb információ: help <parancs_neve>\n");
                break;
        }
    }

    public void info(String parameter) {
        String[] array = parameter.split(" ");
        if (array[0].equals("virologus")) {
            Virologus v;
            for (Virologus vir : Main.gm.getVirologusok()) {
                if (array[1].equals(vir.getUserName())) {
                    System.out.println(vir.toString());
                }
            }
        } else if (array[0].equals("mezo")) {
            for (int i = 0; i < Main.gm.getMezok().size(); i++) {
                if (Integer.parseInt(array[1]) == (i+1)) System.out.println(Main.gm.getMezok().get(i).toString());
            }
        } else {
            invalid_param();
        }
    }

    public void put(String parameter) {
        String[] array = parameter.split(" ");

        int azon = Integer.parseInt(array[1]);
        Mezo m = Main.gm.getMezok().get(azon);

        for (Virologus vir : Main.gm.getVirologusok()) {
            if (array[0].equals(vir.getUserName())) {
                vir.setMezo(m);
            }
        }
    }

    public void connect(String parameter) {
        String[] array = parameter.split(" ");
        Mezo m1 = Main.gm.getMezok().get(Integer.parseInt(array[0]));
        Mezo m2 = Main.gm.getMezok().get(Integer.parseInt(array[1]));
        m1.getSzomszedok().add(m2);
        m2.getSzomszedok().add(m1);
    }

    public void list(String parameter) {
        switch (parameter) {
            case "virologus":
                for (Virologus vir : Main.gm.getVirologusok()) {
                    System.out.println(vir.getUserName());
                }
            case "mezok":
                int i = 1;
                for (Mezo m : Main.gm.getMezok()) {
                    System.out.println(i + " " + m.toString());
                    i++;
                }
        }
    }

    public void load(String parameter) {
        try (
                FileInputStream file = new FileInputStream(parameter);
                ObjectInputStream in = new ObjectInputStream(file)
            )
        {
        Main.gm=(GameManager) in.readObject();          //TODO: most így hirtelen nem tudom mi kéne még ide
        }catch(IOException | ClassNotFoundException e){

            e.printStackTrace();
        }
    }


    public void save(String parameter) {
        if(!Main.gm.print_to_file){
                try
                        (
                        FileOutputStream file = new FileOutputStream(parameter);
                        ObjectOutputStream out = new ObjectOutputStream(file);
                        )
                {
                    out.writeObject(Main.gm);
                }
                catch(IOException e) {e.printStackTrace();}
        }else{
                try(

                        FileOutputStream file = new FileOutputStream(parameter);
                        ObjectOutputStream out = new ObjectOutputStream(file);
                )
                {   PrintStream printStream = new PrintStream(new FileOutputStream(parameter, true),
                        true);
                    System.setOut(printStream);

                    out.writeObject(Main.gm);

                }catch(IOException e)
                {
                    e.printStackTrace();
                }
        }
    }

    public void move(String parameter) {
        String[] array = parameter.split(" ");
        Virologus vir = null;
        boolean benult = false;
        for (Virologus v : Main.gm.getVirologusok()) {
            String name = v.getUserName();
            if (array[0].equals(name)) {
                vir = v;

                //ellenorizzük, hogy a virológus bénult-e:
                for (Agens a : vir.getRakenve()) {
                    if (a.toString().equals("Benitottsag") && a.getKenve()) benult = true;
                }
            }
        }

        if (vir == null) {
            System.out.println("A megadott virológus nem létezik");
        }
        else if (benult) {
            System.out.println("Az adott virológus bénult, ezért nem képes mozogni");
        }
        else if(vir.getMezo().getSzomszedok().contains(Main.gm.getMezok().get(Integer.parseInt(array[1]))))
        {
           vir.setMezo(Main.gm.getMezok().get(Integer.parseInt(array[1])));
        }
        else {
            System.out.println("Az adott mez? a virológus mez?jével nem szomszédos");
        }
    }

    public void print_to_file(String parameter) {
        switch (parameter) {
            case "on":
                GameManager.print_to_file = true;
                break;
            case "off":
                GameManager.print_to_file = false;
                break;
            default:
                invalid_param();
                break;
        }
    }

    public void give(String parameter) {
        String[] array = parameter.split(" ");
        Virologus vir = null;
        for (Virologus v : Main.gm.getVirologusok()) {
            String name = v.getUserName();
            if (array[0].equals(name)) {
                vir = v;
            }
        }
        boolean kod = false; //mivel az agens és kod nevei ugyanazok a segéd fuggvénynél ezzel nézi meg hogy melyiket kell adni neki

        switch (array[1]) {

            case "nukleotid":
                vir.setTarolo(new Anyag(Integer.parseInt(array[2]), vir.getTarolo().getAminosav()));
                break;
            case "aminosav":
                 vir.setTarolo(new Anyag(vir.getTarolo().getNukleotid(), Integer.parseInt(array[2])));
                break;
            case "felszereles":
                give_seged_fel(array[2], vir); //segéd fg
                break;
            case "agens":
                give_seged_agens(array[2], kod, vir); //seged fg
                break;
            case "kod":
                kod = true;
                 give_seged_agens(array[2], kod, vir);
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
            case "Medvetanc":
                if(kod) {
                    System.out.println("Hiba: Medvetánc kód nem létezik");
                }
                else {
                    vir.agens_letrehoz(new Amnezia_kod());
                }
        }
    }

    public void step(String parameter) {
        if (parameter.equals("")) {
            int idx = Main.gm.getSoros()+1;
            Main.gm.getVirologusok().get(idx).lep();
        }
        else {
            Virologus v1 = null;
            for (Virologus v : Main.gm.getVirologusok()) {
                String name = v.getUserName();
                if (parameter.equals(name)) {
                    v1 = v;
                }
            }
            if (v1 == null) System.out.println("Hiba: Ismeretlen virológus");
            v1.lep();
        }
    }

    public void generate_map(String parameter) {
        Main.gm.palya_generalas(Integer.parseInt(parameter));
    }

    public void smear_virus(String parameter) {
        String[] array = parameter.split(" ");
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
        String[] array = parameter.split(" ");

        Virologus v1 = null, v2 = null;
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
        if(v1.getMezo() == v2.getMezo()){
            v2.setHalott(true);
        }
        else{
            System.out.print("Nem egy mezõn állnak!");
        }
    }

    public void make_agent(String parameter) {
        String[] array = parameter.split(" ");
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
        Main.gm.getMezok().get(Integer.parseInt(parameter)).getFelszerelesek().clear();
        Main.gm.getMezok().get(Integer.parseInt(parameter)).setTarolo(new Anyag (0, 0));
       //TODO: kod? esetleg azt is atrakhatnank a sima Mezo tipusba, virologusokat is törölni kell?

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

            try {
                File myObj = new File(fajlbe);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }

        }
    }

    private void minimain() {


    }

    public void set(String parameter) {
        String[] array = parameter.split(" ");
        try {
            switch (array[1]) {
                case "felszereles":
                    set_felszerel(array[2], Integer.parseInt(array[0]));
                case "kod":
                    set_kod(array[2], Integer.parseInt(array[0]));
                case "anyag":
                    set_anyag(array[2], array[3], Integer.parseInt(array[0]));
                case "medvetanc":
                    //TODO: medvetanc
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    private void set_anyag(String param, String mennyiseg, int index){
        switch (param){
            case "nukleodid":
                Main.gm.getMezok().get(index).setTarolo(new Anyag(Integer.parseInt(mennyiseg),   Main.gm.getMezok().get(index).getTarolo().getAminosav() ));
                break;
            case "aminosav":
                Main.gm.getMezok().get(index).setTarolo(new Anyag(Main.gm.getMezok().get(index).getTarolo().getNukleotid(), Integer.parseInt(mennyiseg) ));
        break;
        }

    }

    private void set_kod(String param, int index){
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

    private void set_felszerel(String param, int index) {
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
