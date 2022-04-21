public class Medvetanc extends Agens{
    public Medvetanc() {
        super();
    }

    @Override
    public void lep() {

    }

    @Override
    public void hatas(Virologus v) {
        if (getVirologus() != null) getVirologus().getMezo().anyagElpusztit();
    }
}


