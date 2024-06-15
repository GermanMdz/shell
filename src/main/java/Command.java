
public abstract class Command {

    protected String prop;

    public abstract void execute();

    public void setProp(String input) {
        this.prop = input;
    }

}
