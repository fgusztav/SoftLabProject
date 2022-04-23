import java.util.List;
import java.util.Random;

public class Medvetanc extends Agens{
    public Medvetanc() {
        super();
    }

    @Override
    public void lep() {

    }

    @Override
    public void hatas(Virologus v) {
        List<Mezo> mezok = v.getMezo().getSzomszedok();
        int rnd;
        if(mezok.size() > 0){

            rnd = new Random().nextInt(mezok.size());
            if(GameManager.rand == false){
                rnd = 0;
            }
            Mezo lep = mezok.get(rnd);
            v.mozgas(lep);
        }

        if (getVirologus() != null) getVirologus().getMezo().anyagElpusztit();
    }

    @Override
    public String toString() {
        return "Medvetanc";
    }
}


