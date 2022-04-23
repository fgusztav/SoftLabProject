import java.util.Scanner;

public class Main {
    public static GameManager gm = new GameManager(4);

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String bemenet = sc.nextLine();
            String parancs = bemenet.split(" ")[0];
            //String parancs = new String(); //csak példaként az első parancs
            String parameter = bemenet.split(" ", 1)[1];
            //String parameter = new String(); // masodik parancs
            Leironyelv interfesz = new Leironyelv();

            interfesz.list("virologus");

            switch (parancs) {
                case "create":
                    interfesz.create(parameter);
                case "help":
                    interfesz.help(parameter);
                case "info":
                    interfesz.info(parameter);
                case "put":
                    interfesz.put(parameter);
                case "list":
                    interfesz.list(parameter);
                case "load":
                    interfesz.load(parameter);
                case "save":
                    interfesz.save(parameter);
                case "move":
                    interfesz.move(parameter);
                case "print_to_file":
                    interfesz.print_to_file(parameter);
                case "give":
                    interfesz.give(parameter);
                case "step":
                    interfesz.step(parameter);
                case "generate_map":
                    interfesz.generate_map(parameter);
                case "smear_virus":
                    interfesz.smear_virus(parameter);
                case "kill":
                    interfesz.kill(parameter);
                case "make_agent":
                    interfesz.make_agent(parameter);
                case "random":
                    interfesz.random(parameter);
                case "clear":
                    interfesz.clear(parameter);
                case "defensivecoat":
                    interfesz.defensivecoat(parameter);
                case "test_mode":
                    interfesz.test_mode(parameter);
            }
        }
    }
}