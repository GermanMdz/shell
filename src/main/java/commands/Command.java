package commands;

public abstract class Command {

    protected String name;
    protected String prop;
    protected String type;

    public abstract void execute(String path);

    public void setProp(String input) {
        this.prop = input;
    }

    public boolean isBiltin() {
        return true;
    }

}
