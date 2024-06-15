package commands;

import java.io.File;

public class Type extends Command {

    private Command reqCommand;

    public Type() {
        this.name = "type";
        this.type = "builtin";
    }

    @Override
    public void execute(String path) {
        if(reqCommand.isBiltin()) {
            System.out.println(reqCommand.name + " is a shell builtin");
            return;
        } 
        try {
            File file = this.fileExist(reqCommand.name, path);
            System.out.printf("%s is %s\n", reqCommand.name, file.getPath());
        } catch (Exception e) {
            System.out.printf("%s: not found\n", reqCommand.name);
        }
        
    }

    private File fileExist(String name, String path) throws Exception {
        String paths[] = this.splitArgs(path);
        for (String p : paths) {
            File file = new File(p, name);
            if (file.exists()) return file;
        }
        throw new Exception(name);
    }

    @Override
    public void setProp(String reqCommand) {
        CommandCreator cmdCreator = new CommandCreator();
        this.reqCommand = cmdCreator.createCommand(reqCommand);
    }

    public String[] splitArgs(String path) {
        return path.split(File.pathSeparator);
    }
    

}
