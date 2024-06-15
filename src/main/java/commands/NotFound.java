package commands;

public class NotFound extends Command{


    public NotFound(String cmd) {
        this.name = cmd;
    }

    @Override
    public void execute(String p) {
        System.out.printf("%s: command not found\n", this.name);
    }

    @Override
    public boolean isBiltin() {
        return false;
    }

}
