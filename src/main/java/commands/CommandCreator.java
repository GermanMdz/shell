package commands;

import java.util.HashMap;

public class CommandCreator {
    
    private HashMap<String, Command> builtinCommands = new HashMap<>();
    
    public HashMap<String, Command> getBuiltinCommands() {
        return builtinCommands;
    }

    public CommandCreator() {
        builtinCommands.put("echo", new Echo());
        builtinCommands.put("exit", new Exit());
        builtinCommands.put("type", new Type());
    }

}
