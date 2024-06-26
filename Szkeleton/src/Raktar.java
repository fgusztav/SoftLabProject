import java.util.Random;

public class Raktar extends Mezo {
    public Raktar(){
        Anyag a = new Anyag(0, 0);
        if (GameManager.rand){
            Random ra = new Random();
            a = new Anyag(ra.nextInt(15), ra.nextInt(10));
        }
        setTarolo(a);
    }

    public Raktar (Anyag a){
        if (GameManager.rand){
            Random ra = new Random();
            a = new Anyag(ra.nextInt(15), ra.nextInt(10));
        }
        setTarolo(a);
    }

    @Override
    public void anyagElpusztit() {
        setTarolo(new Anyag(0,0));
    }

    @Override
    public String toString() {
        return "Raktar";
    }
}
