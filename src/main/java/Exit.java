
public class Exit extends Command{

    @Override
    public void execute() {
        System.exit(Integer.parseInt(this.prop));
    }

}
