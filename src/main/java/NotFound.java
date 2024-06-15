
public class NotFound extends Command{

    private String cmd;

    public NotFound(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public void execute() {
        System.out.printf("%s: command not found\n", this.cmd);
    }

}
