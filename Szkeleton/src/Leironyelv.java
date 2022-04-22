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

    }

    public void kill (String parameter){

    }

    public void make_agent (String parameter){

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
