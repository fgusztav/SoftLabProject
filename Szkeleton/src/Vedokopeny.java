public class Vedokopeny extends Felszereles {
    /**
     * A felkent ágenseket nullázza le 82.3% valószinűséggel.
     */
    public Vedokopeny(){
        setAktiv(false);
    }

    @Override
    public void felszerelesHatas(Virologus forras, Virologus cel, Agens a) {
        //System.out.println("Vedokopeny.felszerelesHatas() -> Vedokopeny hatas.");
        for(int i = 0; i < getVirologus().getRakenve().size();i++){

        }
    }
}
