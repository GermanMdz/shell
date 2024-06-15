import java.util.HashMap;
import java.util.Scanner;

import commands.Command;
import commands.Echo;
import commands.Exit;
import commands.NotFound;
import commands.Type;
import commands.CommandCreator;

public class Main {
    public static void main(String[] args) throws Exception {
        
        CommandCreator cmdCreator = new CommandCreator();

        while(true) {
            System.out.print("$ ");
            String input = waitForUserInput();

            Command command = createCommand(cmdCreator, input);
            command.execute();
        }
    }

    private static String waitForUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // scanner.close();
        return input;
    }

    private static Command createCommand(CommandCreator cmdCreator, String input) {
        String[] tokens = input.split(" ", 2);
        Command command = new NotFound(tokens[0]);
        if (cmdCreator.getBuiltinCommands().containsKey(tokens[0])) {
            command = cmdCreator.getBuiltinCommands().get(tokens[0]);
            if (tokens.length >= 1) command.setProp(tokens[1]);
        }
        return command;
    }
}
