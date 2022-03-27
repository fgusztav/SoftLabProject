import java.util.ArrayList;
import java.util.List;

public abstract class Mezo {

    private List<Mezo> mezok;
    public Mezo(){
        mezok = new ArrayList<Mezo>();
    }

    public List<Mezo> getMezok() {
        System.out.println("Mezok lekerdezese.");
        return mezok;
    }

    /**
     * Elfogadja a megadott virologust a mezőre
     * @param vir Ezt a virológust fogadja el az adott mezőre
     */
    public abstract void elfogad (Virologus vir);

    /**
     * Eltávolitja az adott virologust a mezőről
     * @param vir Ezt a virológust távolítja el az adott mezőről.
     */
    public abstract void eltavolit(Virologus vir);

    public void addMezo(Mezo mezo){
        mezok.add(mezo);
    }
}
