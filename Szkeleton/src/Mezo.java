public abstract class Mezo {
    public Mezo(){}
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
}
