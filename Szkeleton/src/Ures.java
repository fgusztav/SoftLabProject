public class Ures extends Mezo{

    /**
     * Elfogadja a megadott virologust a mez�re
     *
     * @param vir Ezt a virol�gust fogadja el az adott mez�re
     */
    public void elfogad(Virologus vir) {
        System.out.println("Virol�gus �res mez�re l�p.");
    }

    /**
     * Elt�volitja az adott virologust a mez�r�l
     *
     * @param vir Ezt a virol�gust t�vol�tja el az adott mez�r�l
     */
    public void eltavolit(Virologus vir) {
        System.out.println("Virol�gus elhagyja az �res mez�t");
    }
}
