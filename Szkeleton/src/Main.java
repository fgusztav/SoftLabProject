public class Main {
    public static void main(String[] args) {
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v = new Virologus(u1, new Anyag(0,0), 10);
        v.mozgas(u2);
    }
}
