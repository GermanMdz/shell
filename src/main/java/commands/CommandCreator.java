package commands;

import java.util.HashMap;

public class CommandCreator {
    
    private HashMap<String, Command> builtinCommands = new HashMap<>();

    public CommandCreator() {
        builtinCommands.put("echo", new Echo());
        builtinCommands.put("exit", new Exit());
        builtinCommands.put("type", new Type());
        builtinCommands.put("pwd", new Pwd());
    }

    public Command createCommand(String input) {
        String[] tokens = input.split(" ", 2);
        Command command = new NotFound(tokens[0]);
        if (this.builtinCommands.containsKey(tokens[0])) {
            command = this.builtinCommands.get(tokens[0]);
        }
        command.setProp("");
        if (tokens.length > 1) command.setProp(tokens[1]);
        return command;
    }

}
