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
            }
        }
        else{
            //csak példanak csinaltam h én igy értelmeztem amit irtal, vagyis a createt igy oldanam meg
            //még talan a leiro nyelvnek csinalnek egy mezok listat, meg talan virologus
            //Virologus parameter = new Virologus(mezolista, Anyag tarolo = new Anyag(0,0), maxanyag = 50);
        }

}

}
