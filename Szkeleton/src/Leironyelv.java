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
           /* case "ovohely":
                Ovohely v = new Ovohely();*/ //csak ahogy lattam m�g nincs ovohely class szvl ezt most egyenl�re kivettem
        }}
        else{
            //csak p�ldanak csinaltam h �n igy �rtelmeztem amit irtal, vagyis a createt igy oldanam meg
            //m�g talan a leiro nyelvnek csinalnek egy mezok listat, meg talan virologus
            //Virologus parameter = new Virologus(mezklista, Anyag tarolo = new Anyag(0,0), maxanyag = 50);
        }

}

}
