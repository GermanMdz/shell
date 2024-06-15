package commands;

public class Exit extends Command{

    
    public Exit() {
        this.name = "exit";
        this.type = "builtin";
    }

    @Override
    public void execute(String p) {
        System.exit(Integer.parseInt(this.prop));
    }

}
