package commands;

import java.util.HashMap;

public class Type extends Command {

    private Command reqCommand;

    public Type() {
        this.name = "type";
        this.type = "builtin";
    }

    @Override
    public void execute() {
        reqCommand.printType();
    }

    // @Override
    public void setProp(String reqCommand) {
        CommandCreator cmdCreator = new CommandCreator();
        Command command = new NotFound(reqCommand);
        if (cmdCreator.getBuiltinCommands().containsKey(reqCommand)) {
            command = cmdCreator.getBuiltinCommands().get(reqCommand);
        }
        this.reqCommand = command;
    }

    

}
