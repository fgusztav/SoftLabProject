import java.util.ArrayList;
import java.util.List;

public abstract class Mezo {
    private List<Mezo> szomszedok;
    private List<Felszereles> felszerelesek;
    private Anyag tarolo;

    private List<Mezo> mezok;
    public Mezo(){
        szomszedok = new ArrayList<Mezo>();
        felszerelesek = new ArrayList<Felszereles>();
        tarolo = new Anyag(0,0);
    }

    public List<Mezo> getSzomszedok() {
        System.out.println("Mezok lekerdezese.");
        return szomszedok;
    }

    public List<Felszereles> getFelszerelesek() {
        return felszerelesek;
    }

    public void setFelszerelesek(List<Felszereles> felszerelesek) {
        this.felszerelesek = felszerelesek;
    }

    public Anyag getTarolo() {
        return tarolo;
    }

    public void setTarolo(Anyag tarolo) {
        this.tarolo = tarolo;
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
        szomszedok.add(mezo);
    }

    /**
     * Medvetanc agens hatása hívja meg, de csak raktárban nem üres, ahol elpusztítja az anyagot.
     */
    public void anyagElpusztit() {}
}
