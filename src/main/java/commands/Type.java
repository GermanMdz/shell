package commands;

import java.io.File;

public class Type extends Command {

    private Command reqCommand;

    public Type() {
        this.name = "type";
        this.type = "builtin";
    }

    @Override
    public void execute(String[] paths) {
        if(reqCommand.isBiltin()) {
            System.out.println(reqCommand.name + " is a shell builtin");
            return;
        } 
        try {
            File file = this.fileExist(reqCommand.name, paths);
            System.out.printf("%s is %s\n", reqCommand.name, file.getPath());
        } catch (Exception e) {
            System.out.printf("%s: not found\n", reqCommand.name);
        }
        
    }

    @Override
    public void setProp(String reqCommand) {
        CommandCreator cmdCreator = new CommandCreator();
        this.reqCommand = cmdCreator.createCommand(reqCommand);
    }

}
