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
                System.out.println("L�trehozhat� ezzel a paranccsal �j virol�gus, vagy egy adott t�pus� mez� - v�ros, labor, �res, �v�hely, rakt�r.");
                System.out.println("\nParam�terei: Create <virol�gus_neve> vagy Create <varos/ures/labor/raktar/ovohely>");
                break;
            case "help":
                System.out.println(" Inform�ci� k�rhet� egy adott parancsr�l, vagy kilist�zhat� az �sszes parancs.");
                System.out.println("\nHelp [parancs_neve] - ahol a param�ter csak opcion�lis!");
                break;
            case "info":
                System.out.println("Els� param�terk�nt megadhatunk egy t�pust a m�sodik param�terk�nt a megfelel� objektum nev�t, ezut�n a program kilist�zza az objektum inform�ci�it.");
                System.out.println("\nInfo <Objektum_t�pusa> <Objektum_neve>");
                break;

            case "put":
                System.out.println(" Elhelyezi (�elteleport�lja�) a megadott virol�gust egy adott mez�re, mely b�rhol lehet a p�ly�n, �gy a j�t�k szokv�nyos m�k�d�s�nek r�sz�t k�pez� Move parancsot megker�lve. Ez�rt nem a mozg�s tesztel�s�re van (l�sd: Move),\n hanem a teszthez sz�ks�ges �llapot gyors l�trehoz�s�ra. ");
                System.out.println("\nParam�terei: Put <virologus_neve> <mezo_azonosito>");
                break;
            case "connect":
                System.out.println("K�t mez�t �sszekapcsol, szomsz�doss� teszi �ket.");
                System.out.println("\nParam�terei:Connect <mez�_azonos�t�1> <mez�_azonos�t�2>");
                break;
            case "list":
                System.out.println("Kilist�zza a j�t�kban szerepl� mez�ket vagy virol�gusokat a megadott param�terne megfelel�en.");
                System.out.println("\nParam�terei: List <mezok> vagy List <virologus> ");
                break;
            case "load":
                System.out.println(" F�jlbol bet�lt egy kor�bbi j�t�k �ll�st.");
                System.out.println("\nParam�terei: Load <fajlnev>");
                break;
            case "save":
                System.out.println("F�jlba ment egy aktu�lis j�t�k �ll�st.");
                System.out.println("\nParam�terei:Save <fajlnev>");
                break;
            case "move":
                System.out.println("Virol�gus mozog egy szomsz�dos mez�re. Error-t kell dobnia ha p�ld�ul a virol�gus b�nult, vagy az adott mez� nem szomsz�dos.");
                System.out.println("\nParam�terei: Move <virologus> <mezo>");
                break;
            case "print_to_file":
                System.out.println("on param�ter eset�n ki�rja a f�jlba a konzol kimenet�t, off eset�n nem �rja ki f�jlba.");
                System.out.println("\nParam�terei:Print_to_file <on/off>");
                break;
            case "give":
                System.out.println("A megadott virol�gushoz adhat anyagot vagy felszerel�st vagy �genst a meghat�rozott mennyis�gben.");
                System.out.println("\nParam�terei:Give <vir>  <nukleotid>/<aminosav>/<felszereles>/<agens>/<kod> <anyag_mennyiseg>/<felszereles_neve>/<agens_neve>/<kod_neve>\n");
                System.out.println("\nLehets�ges �rt�kei: Agens_neve vagy  kod_neve param�terek lehets�ges �rt�kei: \nAmnezia \nBenitottsag \nVitustanc \nVedettseg \nMedvetanc (csak mint �gens, nem k�d!)" +
                        " \nFelszereles_neve param�ter lehets�ges �rt�kei: \nKesztyu \nVedokopeny \nZsak \nBalta ");
                break;
            case "step":
                System.out.println(" L�ptet egy megadott virol�gust (megh�vva a l�p() f�ggv�ny�t) vagy a j�t�kban a soron k�vetkez� virol�gust l�pteti, ha nincs megadva param�ter.");
                System.out.println("\nParam�terei:Step <Virologus> - param�ter csak opcion�lis.");
                break;
            case "generate_map":
                System.out.println("Ha a random ki van kapcsolva: A megadott j�t�kos sz�m f�ggv�ny�ben l�trehoz egy p�ly�t, ahol l�trehoz adott ar�nyban rakt�rat, labort, v�rost, �v�helyet �s a marad�k mez�k pedig �res mez�k. Minden mez�t mindegyikkel �sszek�ti. A megadott param�ter f�ggv�ny�ben determinisztikusan hozza l�tre a p�ly�t.\n" +
                        "\tHa a random be van kapcsolva: \n" +
                        "A megadott j�t�kos sz�m f�ggv�ny�ben v�letlenszer�en gener�lja a mez�ket �s a mez�k egym�ssal val� szomsz�ds�g�t.\n");
                System.out.println("\nParam�terei:Generate_map <int: size>");
                break;
            case "smear_virus":
                System.out.println(" Egy virol�gus megken egy m�sik virol�gust, vagy �nmag�t egy adott �genssel.");
                System.out.println("\nParam�terei:Smear_virus <virologus_aki_ken> <virologus2> <agens_neve>");
                System.out.println("\nLehets�ges �rt�kei: Agens_neve param�terek lehets�ges �rt�kei: \nAmnezia \nBenitottsag \nVitustanc \nVedettseg \nMedvetanc ");
                break;
            case "kill":
                System.out.println("Kett� param�tere van, mindkett� param�terk�nt egy-egy virol�gus nevet v�r. Az els� virol�gus meg�li a m�sikat balt�val. ");
                System.out.println("\nParam�terei:Make_agent <virologus> <agens>");
                break;
            case "make_agent":
                System.out.println("�genst hoz l�tre egy adott virol�gus, ha ismeri a hozz� sz�ks�ges k�dot �s van hozz� elegend� anyaga.");
                System.out.println("\nParam�terei:Make_agent <virologus> <agens>");
                break;
            case "random":
                System.out.println("Ki- �s bekapcsolja, hogy a program random esem�nyeket t�nyleg v�letlenszer� kimenetellel hajtson v�gre, vagy determinisztikusan minden tesztel�skor ugyanazt a kimenetelt kapjuk.");
                System.out.println("\nParam�terei: Random <on/off>");
                break;
            case "clear":
                System.out.println(" Egy mez� �sszes t�r�lhet� rajta t�rolt objektum�t t�r�lj�k.");
                System.out.println("\nParam�terei:Clear <mez�_azonos�t�>");
                break;
            case "defensivecoat":
                System.out.println("A v�d�k�peny m�k�d�se determinisztikusan �ll�that�, hogy mindig v�djen, vagy semmik�pp se v�dje ki a m�sik virol�gus �ltali �gens ken�st. \nEz a parancs csak akkor relev�ns, ha a Random off van be�ll�tva (determinisztikus tesztel�s eset�n).");
                System.out.println("\nParam�terei:DefensiveCoat <on/off>");
                break;
            case "test_mode":
                System.out.println("Egy speci�lis parancs, amellyel a program automatikus tesztel�s �zemm�dba helyezhet�");
                break;
            case "set":
                System.out.println("Mez�kre helyez felszerel�st, anyagot, vagy k�dot (csak laborokn�l). \nHa az adott kateg�ri�j� objektumb�l m�r van egy az adott mez�n, akkor lecser�li azt. Ha p�ld�ul nem laborra akarunk k�dot elhelyezni akkor hib�t ad vissza.");
                System.out.println("\nParam�terei:Set <mez�_azonos�t�ja> <t�pus> [objektum_neve] [mennyis�g]");
                System.out.println("\nA <mez�_azonos�t�ja> param�ter a List mezok parancs �ltal visszaadott k�dok lehetnek.\n" +
                        "A <t�pus> param�ter lehets�ges �rt�kei:\n" +
                        "felszereles\n" +
                        "kod\n" +
                        "anyag\n" +
                        "medvetanc\n");
                break;
            default:
                System.out.println("Parancsok:\ncreate\nhelp\ninfo\nput\nconnect\nlist\nload\nsave\nmove\nprint_to_file\ngive\nstep\ngenerate_map\nsmear_virus\nkill\nmake_agent\nrandom\nclear\ndefensivecoat\ntest:mode\nT�bb inform�ci�: help <parancs_neve>\n");
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
        Main.gm=(GameManager) in.readObject();          //TODO: most �gy hirtelen nem tudom mi k�ne m�g ide
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

                //ellenorizz�k, hogy a virol�gus b�nult-e:
                for (Agens a : vir.getRakenve()) {
                    if (a.toString().equals("Benitottsag") && a.getKenve()) benult = true;
                }
            }
        }

        if (vir == null) {
            System.out.println("A megadott virol�gus nem l�tezik");
        }
        else if (benult) {
            System.out.println("Az adott virol�gus b�nult, ez�rt nem k�pes mozogni");
        }
        else if(vir.getMezo().getSzomszedok().contains(Main.gm.getMezok().get(Integer.parseInt(array[1]))))
        {
           vir.setMezo(Main.gm.getMezok().get(Integer.parseInt(array[1])));
        }
        else {
            System.out.println("Az adott mez? a virol�gus mez?j�vel nem szomsz�dos");
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
        boolean kod = false; //mivel az agens �s kod nevei ugyanazok a seg�d fuggv�nyn�l ezzel n�zi meg hogy melyiket kell adni neki

        switch (array[1]) {

            case "nukleotid":
                vir.setTarolo(new Anyag(Integer.parseInt(array[2]), vir.getTarolo().getAminosav()));
                break;
            case "aminosav":
                 vir.setTarolo(new Anyag(vir.getTarolo().getNukleotid(), Integer.parseInt(array[2])));
                break;
            case "felszereles":
                give_seged_fel(array[2], vir); //seg�d fg
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
                    System.out.println("Hiba: Medvet�nc k�d nem l�tezik");
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
            if (v1 == null) System.out.println("Hiba: Ismeretlen virol�gus");
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
            System.out.print("Nem egy mez�n �llnak!");
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
                System.out.println("A virol�gus nem ismeri a sz�ks�ges k�dot");
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
       //TODO: kod? esetleg azt is atrakhatnank a sima Mezo tipusba, virologusokat is t�r�lni kell?

    }

    public void defensivecoat(String parameter) {

    }

    public void test_mode(String parameter) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println("Adja a bementi f�jl nev�t: ");
            String fajlbe = sc.nextLine();
            System.out.println("Adja az elv�rt kimenetet taralmaz� f�jl nev�t: ");
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
        //TODO: typeCheck k�ne hogy Labor mezo-e mert csak ott lehet kod
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
