import java.io.File;
import java.util.Scanner;

import commands.Command;
import commands.CommandCreator;

public class Main {
    public static void main(String[] args) throws Exception {
        
        CommandCreator cmdCreator = new CommandCreator();
        String[] pathEnv = System.getenv("PATH").split(File.pathSeparator);
        while(true) {
            System.out.print("$ ");
            String input = waitForUserInput();

            Command command = createCommand(cmdCreator, input);
            command.execute(pathEnv);
        }
    }

    private static String waitForUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // scanner.close();
        return input;
    }

    private static Command createCommand(CommandCreator cmdCreator, String input) {
        return cmdCreator.createCommand(input);
    }
}
