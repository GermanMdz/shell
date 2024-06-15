import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        HashMap<String, Command> builtinCommands = new HashMap<>();
        builtinCommands.put("echo", new Echo());
        builtinCommands.put("exit", new Exit());
        // builtinCommands.put("cd", new Cd());
        // builtinCommands.put("pwd", new Pwd());

        while(true) {
            System.out.print("$ ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            Command command = createCommand(builtinCommands, input);
            command.execute();
            
        }

    }

    private static Command createCommand(HashMap<String, Command> builtinCommands, String input) {
        String[] tokens = input.split(" ", 2);
        Command command = new NotFound(tokens[0]);
        if (builtinCommands.containsKey(tokens[0])) {
            command = builtinCommands.get(tokens[0]);
            if (tokens.length >= 1) command.setProp(tokens[1]);
        }
        return command;
    }
}
