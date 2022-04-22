public class Leironyelv {
    //minden parancsra egy fv.

    public void create(String parameter){
        boolean mezo = false;
        if(!mezo){
            switch (parameter){
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
        }
        else{
            Virologus v = new Virologus(Main.gm.getMezok().get(0), new Anyag(0, 0), 40);
            v.setUserName(parameter);
        }
    }

    public void help(String parameter){
        switch (parameter) {
            case "":
            case "create":
            case "help":
            case "info":
            case "put":
            case "connect":
            case "list":
            case "load":
            case "save":
            case "move":
            case "print_to_file":
            case "give":
            case "step":
            case "generate_map":
            case "smear_virus":
            case "kill":
            case "make_agent":
            case "random":
            case "clear":
            case "defensivecoat":
            case "test_mode":
        }
    }

    public void info (String parameter){
        String array [] = parameter.split(" ");
        if (array[0].equals("Virologus")){
            Virologus v;
            for (Virologus vir : Main.gm.getVirologusok()){
                if (array[1].equals(vir.getUserName())){
                    vir.toString();
                }
            }
        }
        else if (array[0].equals("Mezo")) {
            //TODO:Kiiratas
        }
        else {
            System.out.println("Invalid parameter");
        }
    }

    public void put (String parameter){
        String array [] = parameter.split(" ");
        String v = array[0];

        int azon = Integer.parseInt(array[1]);
        Mezo m = Main.gm.getMezok().get(azon);

        for (Virologus vir : Main.gm.getVirologusok()){
            if (v.equals(vir.getUserName())){
                vir.setMezo(m);
            }
        }
    }

    public void connect (String parameter){

    }

    public void list (String parameter){
        switch(parameter){
            case "virologus":
                for (Virologus vir : Main.gm.getVirologusok()){
                    System.out.println(vir.getUserName());
                }
            case "mezok:":
                for (Mezo m : Main.gm.getMezok()){
                    int i = 1;
                    System.out.println(i + " " + m.toString());
                    i++;
                }
        }
    }

    public void load (String parameter){

    }

    public void save (String parameter){

    }

    public void move (String parameter){

    }

    public void print_to_file (String parameter){

    }

    public void give (String parameter){

    }

    public void step (String parameter){

    }

    public void generate_map (String parameter){

    }

    public void smear_virus (String parameter){
        String array [] = parameter.split(" ");
        Virologus v1, v2;
        for (int i = 0; i < Main.gm.getVirologusok().size(); i++){
            Virologus v = Main.gm.getVirologusok().get(i);
            String name = v.getUserName();
            if (array[0].equals(name)){
                v1 = v;
            }
            if (array[1].equals(name)){
                v2 = v;
            }
        }
        //TODO: GetType
    }

    public void kill (String parameter){

    }

    public void make_agent (String parameter) {
        String array [] = parameter.split(" ");
        for (int i = 0; i < Main.gm.getVirologusok().size(); i++){
            Virologus v = Main.gm.getVirologusok().get(i);
            String name = v.getUserName();
            if (array[0].equals(name)){
                //TODO: GetType
                switch(array[1]){
                    case "amnezia":
                        v.agens_letrehoz(new Amnezia_kod());
                    case "benitottsag":
                        v.agens_letrehoz(new Benitottsag_kod(v));
                    case "vedettseg":
                        v.agens_letrehoz(new Vedettseg_kod(v));
                    case "vitustanc":
                        v.agens_letrehoz(new Vitustanc_kod(v));
                }
            }
        }
    }

    public void random (String parameter){

    }

    public void clear (String parameter){

    }

    public void defensivecoat (String parameter){

    }

    public void test_mode (String parameter){

    }


}
