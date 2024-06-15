package commands;

public class Echo extends Command {

    public Echo() {
        this.prop = "";
        this.name = "echo";
        this.type = "builtin";
    }

    @Override
    public void execute(String p) {
        System.out.printf("%s\n", this.prop);
    }
}
