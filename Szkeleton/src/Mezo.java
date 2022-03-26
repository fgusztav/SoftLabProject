

public abstract class Mezo {


    public Mezo(){

    }
    /**
     * Elfogadja a megadott virologust a mezõre
     * @param vir
     */
    abstract public void elfogad (Virologus vir);

    /**
     * Eltávolitja az adott virologust a mezõrõl
     * @param vir
     */
    abstract public void eltavolit(Virologus vir);
}
