public class Leironyelv {
    //minden parancsra egy fv.

    public void create(String parameter){
        boolean mezo = false;
        if(!mezo){
            switch (parameter){
                case "varos":
                    Varos v = new Varos();
                case "ures":
                    Ures u = new Ures();
                case "labor":
                    Labor l = new Labor();
                case "raktar":
                    Raktar r = new Raktar();
                case "ovohely":
                    Ovohely ov = new Ovohely();
                default:
                    System.out.println("Invalid parameter");
            }
        }
        else{
            //csak példanak csinaltam h én igy értelmeztem amit irtal, vagyis a createt igy oldanam meg
            //még talan a leiro nyelvnek csinalnek egy mezok listat, meg talan virologus
            //Virologus parameter = new Virologus(mezolista, Anyag tarolo = new Anyag(0,0), maxanyag = 50);
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

    }

    public void put (String parameter){

    }

    public void connect (String parameter){

    }

    public void list (String parameter){

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
