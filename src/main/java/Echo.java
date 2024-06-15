
public class Echo extends Command {

    @Override
    public void execute() {
        System.out.printf("%s\n", this.prop);
    }
}
