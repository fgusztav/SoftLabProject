public class Raktar extends Mezo {

    //TODO: Raktárba  ha belép egy Medve, akkor elpusztítja az osszes anyagot (feladat leiras szerint csak a raktarban)
    public Raktar (Anyag a){
        setTarolo(a);
    }

    /**
     * Elfogadja a megadott virologust a mez�re
     *
     * @param vir Ezt a virol�gust fogadja el az adott mez�re
     */
    public void elfogad(Virologus vir) {
        
        System.out.println("Raktar.elfogad() -> Virologus belepett a raktarba.");
    }

    /**
     * Elt�volitja az adott virologust a mez�r�l
     *
     * @param vir Ezt a virol�gust t�vol�tja el az adott mez�r�l.
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Raktar.eltavolit() -> Virologus kilepett a raktarbol.");
    }

    @Override
    public void anyagElpusztit() {
        setTarolo(new Anyag(0,0));
    }
}
