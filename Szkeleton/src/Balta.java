public class Balta extends Felszereles{

    public Balta() {
        setLejarat(1);
        setAktiv(true);
    }

    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        forras.getFelszereles().remove(this);
        cel.setHalott(true);
    } //Kubesz
}
