import java.util.Random;

public class Vedokopeny extends Felszereles {
    /**
     * A felkent ágenseket nullázza le 82.3% valószinűséggel.
     */
    public Vedokopeny(){
        setAktiv(false);
    }

    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {

        float rnd;
        rnd = new Random().nextFloat();
        if(GameManager.rand == false){
            cel.getRakenve().remove(a);
        }
        else{
            if(rnd <= 0.823){
                cel.getRakenve().remove(a);
            }
        }
    }
}
