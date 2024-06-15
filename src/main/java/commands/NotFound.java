package commands;

public class NotFound extends Command{


    public NotFound(String cmd) {
        this.name = cmd;
    }

    @Override
    public void execute() {
        System.out.printf("%s: command not found\n", this.name);
    }

    @Override
    public void printType() {
        System.out.printf("%s: not found\n", this.name);
    }

}
