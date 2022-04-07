public class TestClass {
    public TestClass(){}

    public void Ures2Ures() {
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        v1.mozgas(u2);
    }

    public void AnyagfelvetelRaktarbol() {
        Ures u = new Ures();
        Virologus v2 = new Virologus(u, new Anyag(0, 0), 10);
        Raktar r = new Raktar(new Anyag(0, 0), false);
        v2.mozgas(r);
        v2.anyag_felvesz();
    }

    public void AnyagfelvetelBenultJatekostol() {
        Kesztyu k = new Kesztyu();
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        Virologus v2 = new Virologus(u2, new Anyag(0, 0), 10);
        v1.mozgas(u2);
        v2.megtolt_tarolo(v1);
        v2.felszereles_leadas(k);
        v1.felszereles_hozzaad(k);
    }

    public void FelszerelesFelvetele() {
        Ures u = new Ures();
        Kesztyu k = new Kesztyu();
        Varos var = new Varos(k, false);
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.mozgas(var);
        v.felszereles_hozzaad(k);
    }


    public void AmneziaLetapogatas() {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Amnezia_kod ak = new Amnezia_kod(v);
        Labor l = new Labor(ak);
        v.mozgas(l);
        v.kod_hozzaad(ak);
    }

    public void JatekLeptetes() {
        GameManager gm = new GameManager(4);
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Amnezia a = new Amnezia(v);
        gm.lep();
        v.lep();
    }

    public void VitustancAgenstLetrehoz(Kod k) {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.agens_letrehoz(k);
    }

    public void VitustancAlattLep() {
        Ures u = new Ures();
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        u.addMezo(u1);
        u.addMezo(u2);
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        Vitustanc vit = new Vitustanc(v);
        v.felszereles_hozzaad(k);
        v.megkenve(vit);
        vit.setVirologus(v);
        v.lep();
    }

    public void BenitasAlattLep() {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        Benitottsag b = new Benitottsag(v);
        v.megkenve(b);
        v.lep();
    }

    public void AmneziaAlattLep() {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        v.kod_hozzaad(new Vedettseg_kod(v));
        v.kod_hozzaad(new Amnezia_kod(v));
        Amnezia a = new Amnezia(v);
        v.megkenve(a);
        v.lep();
    }

    public void VedettsegAlattLep() {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        Kesztyu k = new Kesztyu();
        v.felszereles_hozzaad(k);
        v.megkenve(new Vitustanc(v));
        v.megkenve(new Benitottsag(v));
        v.megkenve(new Vedettseg(v));
        v.lep();
    }

    public void VirMagaraAgenstKen(Agens a) {
        Ures u = new Ures();
        Virologus v = new Virologus(u, new Anyag(0, 0), 10);
        v.kenes(v, a);
    }

    public void VirKenVirt(Agens a) {
        Ures u1 = new Ures();
        Ures u2 = new Ures();
        Virologus v1 = new Virologus(u1, new Anyag(0, 0), 10);
        Virologus v2 = new Virologus(u2, new Anyag(0, 0), 10);
        v2.getFelszereles().add(new Kesztyu());
        v1.kenes(v2, a);
    }

    public void JatekVege() {
        GameManager gm = new GameManager(4);
        gm.endGame();
    }

    public void JatekKezdes() {
        GameManager gm = new GameManager(4);
        gm.addPlayer();
        gm.startGame();
    }
}
