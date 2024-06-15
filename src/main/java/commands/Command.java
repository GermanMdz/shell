package commands;

public abstract class Command {

    protected String name;
    protected String prop;
    protected String type;

    public abstract void execute();

    public void setProp(String input) {
        this.prop = input;
    }

    public void printType() {
        System.out.printf("%s is a shell %s\n", this.name, this.type);
    }

}
