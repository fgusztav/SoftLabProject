import java.util.ArrayList;
import java.util.List;

public class Virologus {
    private Mezo mezo;
    private Anyag tarolo;
    private int maxAnyag;
    private List<Kod> ismert_hatasok = new ArrayList<>();
    private List<Agens> rakenve = new ArrayList<>();
    private List<Agens> agens = new ArrayList<>();

    /**
     * Virológus osztály konstruktora.
     * @param mezo Aktuális mező ahol a virológus tartózkodik.
     * @param tarolo A virológus által eltárolt anyag (nukleotid és aminosav).
     * @param maxAnyag A virológus max anyag tárolási kapacitása (minden fajta anyagból külön-külön ugyanannyi) zsák kapacitását nem számolva.
     */
    public Virologus(Mezo mezo, Anyag tarolo, int maxAnyag) {
        this.mezo = mezo;
        this.tarolo = tarolo;
        this.maxAnyag = maxAnyag;
    }




    public Mezo getMezo() {
        return mezo;
    }

    public void setMezo(Mezo mezo) {
        this.mezo = mezo;
    }

    public Anyag getTarolo() {
        return tarolo;
    }

    public void setTarolo(Anyag tarolo) {
        this.tarolo = tarolo;
    }

    public int getMaxAnyag() {
        return maxAnyag;
    }

    public void setMaxAnyag(int maxAnyag) {
        this.maxAnyag = maxAnyag;
    }


}
