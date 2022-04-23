import java.util.Scanner;

public class Main {
    public static GameManager gm = new GameManager(4);

    public static void main(String[] args) {
        String parancs = new String(); //csak példaként az első parancs
        String parameter = new String(); // masodik parancs
        Leironyelv interfesz = new Leironyelv();

        interfesz.list("virologus");

        switch (parancs) {
            case "create":
                interfesz.create(parameter);
            case "help":
                interfesz.create(parameter);
            case "info":
                interfesz.create(parameter);
            case "put":
                interfesz.create(parameter);
            case "list":
                interfesz.create(parameter);
            case "load":
                interfesz.create(parameter);
            case "save":
                interfesz.create(parameter);
            case "move":
                interfesz.create(parameter);
            case "print_to_file":
                interfesz.create(parameter);
            case "give":
                interfesz.create(parameter);
            case "step":
                interfesz.create(parameter);
            case "generate_map":
                interfesz.create(parameter);
            case "smear_virus":
                interfesz.create(parameter);
            case "kill":
                interfesz.create(parameter);
            case "make_agent":
                interfesz.create(parameter);
            case "random":
                interfesz.create(parameter);
            case "clear":
                interfesz.create(parameter);
            case "defensivecoat":
                interfesz.create(parameter);
            case "test_mode":
                interfesz.create(parameter);
        }
    }
}