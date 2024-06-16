package commands;

public class Pwd extends Command{

    public Pwd() {
        this.name = "pwd";
        this.type = "builtin";
    }

    @Override
    public void execute(String[] paths) {
        System.out.println(System.getProperty("user.dir"));
    }

}
