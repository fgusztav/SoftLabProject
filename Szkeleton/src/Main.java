import java.util.Scanner;

public class Main {
    public static GameManager gm = new GameManager(4);

    public static void main(String[] args) {
        String leironyelv = new String(); //csak példaként az első parancs
        String parameter = new String(); // masodik parancs
        Leironyelv banan = new Leironyelv();

        banan.list("mezok");

        switch (leironyelv) {
            case "create":
                banan.create(parameter);
            case "help":
                banan.create(parameter);
            case "info":
                banan.create(parameter);
            case "put":
                banan.create(parameter);
            case "list":
                banan.create(parameter);
            case "load":
                banan.create(parameter);
            case "save":
                banan.create(parameter);
            case "move":
                banan.create(parameter);
            case "print_to_file":
                banan.create(parameter);
            case "give":
                banan.create(parameter);
            case "step":
                banan.create(parameter);
            case "generate_map":
                banan.create(parameter);
            case "smear_virus":
                banan.create(parameter);
            case "kill":
                banan.create(parameter);
            case "make_agent":
                banan.create(parameter);
            case "random":
                banan.create(parameter);
            case "clear":
                banan.create(parameter);
            case "defensivecoat":
                banan.create(parameter);
            case "test_mode":
                banan.create(parameter);
        }
    }
}